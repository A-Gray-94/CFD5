%% CFD Assignment 2, Plots for days
%
% This script is gonna make a lot of plots
%% Some housekeeping
clear all, hold off, close all, clc
names = {'FM', 'FT', 'MM', 'CT', 'CM'};
titles = {'Fine Mesh', 'Fine Time', 'Medium Mesh', 'Coarse Time', 'Coarse Mesh'};
symbols = {'*', '+', 'o', 's', '^'};
mesh_size = [3773512,499006,499006,499006,70204];
time_step = [0.04, 0.02, 0.04, 0.08, 0.04];
locs = [0.2, 0.4, 0.6, 0.8, 0.9];
plot_type = {'Time Averaged', 'at max $C_L$', 'at min $C_L$'};
CLmin = zeros(1,5);
CLmax = CLmin;
CLav = CLmin;
CLamp = CLmin;
CDmin = CLmin;
CDmax = CLmin;
CDav = CLmin;
CDamp = CLmin;
CMmin = CLmin;
CMmax = CLmin;
CMav = CLmin;
CMamp = CLmin;
%% make dem plots bruh

for i = 1:length(names)
    name = names{i};
    load(['Matlab-Data-Processing\', name], 'data')
    plot_data = {data.CP_centre_av, data.CP_centre{data.CLmaxloc}, data.CP_centre{data.CLminloc};
        data.CP02_av, data.CP02{data.CLmaxloc}, data.CP02{data.CLminloc};
        data.CP04_av, data.CP04{data.CLmaxloc}, data.CP04{data.CLminloc};
        data.CP06_av, data.CP06{data.CLmaxloc}, data.CP06{data.CLminloc};
        data.CP08_av, data.CP08{data.CLmaxloc}, data.CP08{data.CLminloc};
        data.CP09_av, data.CP09{data.CLmaxloc}, data.CP09{data.CLminloc}};
    CLmin(i) = data.CLmin;
    CLmax(i) = data.CLmax;
    CLav(i) = 0.5*(CLmax(i)+CLmin(i));
    CLamp(i) = CLmax(i) - CLmin(i);
    CDmin(i) = data.CDmin;
    CDmax(i) = data.CDmax;
    CDav(i) = 0.5*(CDmax(i)+CDmin(i));
    CLamp(i) = CDmax(i) - CDmin(i);
    CMmin(i) = data.CMmin;
    CMmax(i) = data.CMmax;
    CMav(i) = 0.5*(CMmax(i)+CMmin(i));
    CMamp(i) = CMmax(i) - CMmin(i);
    %{
    for loc = 1:6
        for j = 1:3
            figure(3*(loc-1)+j), plot(normalise(plot_data{loc,j}(:,1)), plot_data{loc,j}(:,2),...
                symbols{i}, 'MarkerSize', 9, 'LineWidth', 1.5), hold on;
            axis tight
            if loc ==1
                xlabel('$\frac{x}{C} $','Interpreter','latex', 'FontSize', 18)
                title(['Centreline ', '$C_P$', ' distribution, ', plot_type{j}], 'Interpreter','latex', 'FontSize', 16)
                savename = ['Centre-CP', plot_type{j}]; 
                ylim([-3, 1.1])
            else
                xlabel('\eta', 'FontSize', 18)
                title(['Spanwise ', '$C_P$', ' distribution at ', '$\frac{x}{C} = $', num2str(locs(loc-1)), ', ', plot_type{j}], 'Interpreter','latex', 'FontSize', 16)
                savename = ['Spanwise-CP',num2str(locs(loc-1)), plot_type{j}];
                ylim([-4, 1])
            end
            ylabel('$C_P$','Interpreter','latex', 'FontSize', 18)           
            legend(titles, 'Location', 'best')
            set(gca,'Ydir','reverse')
            if i == length(names)
                drawnow
                print(['Matlab-Data-Processing\plot-images\', savename, '.png'], '-dpng')
                savefig(['Matlab-Data-Processing\plot-images\', savename, '.fig'])
            end
        end
    end
    %}
end
hold off, close all

%%
%{
for i = 1:length(names)
    name = names{i};
    load(['Matlab-Data-Processing\', name], 'data')
    plot_data = {data.CP_centre_av, data.CP_centre{data.CLmaxloc}, data.CP_centre{data.CLminloc};
        data.CP02_av, data.CP02{data.CLmaxloc}, data.CP02{data.CLminloc};
        data.CP04_av, data.CP04{data.CLmaxloc}, data.CP04{data.CLminloc};
        data.CP06_av, data.CP06{data.CLmaxloc}, data.CP06{data.CLminloc};
        data.CP08_av, data.CP08{data.CLmaxloc}, data.CP08{data.CLminloc};
        data.CP09_av, data.CP09{data.CLmaxloc}, data.CP09{data.CLminloc}};
    for loc = 1:6
        figure(6*(i-1)+loc)
        for j = 1:3
            plot(normalise(plot_data{loc,j}(:,1)), plot_data{loc,j}(:,2),...
                symbols{j+2}, 'MarkerSize', 9, 'LineWidth', 1.5), hold on;
        end
        legend(plot_type, 'Location', 'best', 'Interpreter', 'latex', 'FontSize', 14)
        set(gca,'Ydir','reverse')
        if loc ==1
            xlabel('$\frac{x}{C} $','Interpreter','latex', 'FontSize', 18)
            title(['Centreline ', '$C_P$', ' distribution, ', titles{i}], 'Interpreter','latex', 'FontSize', 16)
            savename = ['Centre-CP', titles{i}];
            ylim([-3, 1.1])
        else
            xlabel('\eta', 'FontSize', 18)
            title(['Spanwise ', '$C_P$', ' distribution at ', '$\frac{x}{C} = $', num2str(locs(loc-1)), ', ', titles{i}], 'Interpreter','latex', 'FontSize', 16)
            savename = ['Spanwise-CP',num2str(locs(loc-1)), titles{i}];
        end
        print(['Matlab-Data-Processing\plot-images\', savename, '.png'], '-dpng')
        savefig(['Matlab-Data-Processing\plot-images\', savename, '.fig'])
    end
end
hold off, close all 
%}
%% Uncertainty stuff
phi = [CLav; CDav; CMav; CLmax; CDmax; CMmax; CLmin; CDmin; CMmin];
Uphi = zeros(size(phi,1),6);
phi_0 = zeros(size(phi,1),2);
coeffs = zeros(size(phi,1),6);
sigma = zeros(size(phi,1),2);
Ucom = zeros(size(phi,1),1);
hmesh = ([mesh_size(1), mesh_size(3), mesh_size(5)]/mesh_size(3)).^(-1/3);
htime = [0.5, 1, 2];
line = {'o', 's'};
quantity = {'Average $C_L$', 'Average $C_D$', 'Average $C_M$', 'Maximum $C_L$', 'Maximum $C_D$', 'Maximum $C_M$', 'Minimum $C_L$', 'Minimum $C_D$', 'Minimum $C_M$'};
for quant = 1:size(phi,1)
    for var = 1:1
        if var ==1 
            h = hmesh;
            x = [1 3 5];
            y = [1 2 3];
        else
            h = htime;
            x = [2 3 4];
            y = [4 5 6];
        end
        [Uphi(quant, y), phi_0(quant, var), coeffs(quant, y), sigma(quant, var)] = uncertainty(h,phi(quant,x));
        figure(quant), errorbar([0,h], [phi_0(quant, var), phi(quant,x)]/phi(quant,3), [0, Uphi(quant, y)]/phi(quant,3), line{var}, 'LineWidth', 1.5), hold on
        xx = linspace(0, max(h), 100);
        yy = coeffs(quant,1)*xx.^coeffs(quant,2)+coeffs(quant,3);
        plot(xx, yy/phi(quant,3), 'LineWidth', 1.5)
    end
    title([quantity{quant}, ', Uncertainty quantification'], 'Interpreter', 'latex', 'FontSize', 18)
    xlabel('Grid size (N$^{-1/3}$), normalised ', 'FontSize', 18, 'Interpreter', 'latex')
    ylabel([quantity{quant}, ' (normalised)'], 'Interpreter', 'latex', 'FontSize', 18)
    text(1.01, 1.01, ['P = ', num2str(coeffs(quant,2))], 'FontSize', 14)
    grid on
    print(['Matlab-Data-Processing\plot-images\',quantity{quant}, ', Uncertainty quantification', '.png'], '-dpng')
    savefig(['Matlab-Data-Processing\plot-images\',quantity{quant}, ', Uncertainty quantification', '.fig'])
end
