clear all, hold off, close all, clc

models = {'KW', 'KWSST'};
leg_model = {'K-\omega ', 'K-\omega SST '};
line = {'-', '--', ':', '-.'};
durbin = {'WD', 'ND'};
durbin_leg = {'Durbin Limiter', 'No Scale Limiter'};
grids = {'fine', 'med', 'coarse'};
loc = [0.031, 0.125, 0.25, 0.375, 0.5, 0.625, 0.75, 0.875, 1];
funcs = {'u', 'urms', 'tke'};
funcs_label = {'$\frac{u_i}{U_{\infty}}$', '$u_{rms}$', 'TKE (J/kg)'};
xlims = {[-0.5, 1.5], [0, 7], [0, 70]};
ylims = {[0, 0.2], [0, 0.2], [0, 0.2]};
for model = 1:length(models)
    for durb = 1:length(durbin)
        filename = [models{model}, '_', durbin{durb}, '_med_grid_processed'];
        clearvars data
        load(filename)
        leg{(model-1)*length(durbin)+durb} = [leg_model{model}, durbin_leg{durb}];
        if model == length(models)
            leg{length(leg)+1} = 'Crompton Data';
        end
        for x = 1:length(loc)
            for f = 1:length(funcs)
                figure((x-1)*length(funcs)+f), plot(data{(x-1)*length(funcs)+f}(:,2), data{(x-1)*length(funcs)+f}(:,1), line{(model-1)*length(durbin)+durb}, 'LineWidth', 1.5), hold on
                axis([xlims{f}, ylims{f}])
                xlabel(funcs_label{f},'Interpreter','latex', 'FontSize', 18)
                ylabel('$\frac{y}{c}$','Interpreter','latex', 'FontSize', 18,'rot',0)
                legend(leg, 'Location', 'Best')
                title(['$\frac{x}{C} = $', num2str(loc(x))],'Interpreter','latex', 'FontSize', 18)
            end
        end
    end
end

% Plot Experimental Data
clearvars data
load('Crompton_Data')
for x = 1:length(loc)
    for f = 1:length(funcs)
        figure((x-1)*length(funcs)+f), plot(data{(x-1)*length(funcs)+f}(:,1), data{(x-1)*length(funcs)+f}(:,2), '*')
        axis([xlims{f}, ylims{f}])
        xlabel(funcs_label{f},'Interpreter','latex', 'FontSize', 18)
        ylabel('$\frac{y}{c}$','Interpreter','latex', 'FontSize', 18,'rot',0)
        legend(leg, 'Location', 'Best')
        title(['$\frac{x}{C} = $', num2str(loc(x))],'Interpreter','latex', 'FontSize', 18)
        savefig(['Plot Images\', num2str(loc(x)), '_xc_', funcs{f}, '.fig'])
        print(['Plot Images\', num2str(loc(x)), '_xc_', funcs{f}], '-dpng')
    end
end

% Create CP Plot
for model = 1:length(models)
    for durb = 1:length(durbin)
        filename = [models{model}, '_', durbin{durb}, '_med_grid_processed'];
        clearvars data
        load(filename)
        figure(length(loc)*length(funcs)+1),plot([data{34}(:,1); flipud(data{35}(:,1)); flipud(data{36}(:,1))],[data{34}(:,2); flipud(data{35}(:,2)); flipud(data{36}(:,2))], line{(model-1)*length(durbin)+durb}, 'LineWidth', 1.5), hold on 
        figure(length(loc)*length(funcs)+2),plot(data{28}(:,1),data{28}(:,2), line{(model-1)*length(durbin)+durb}, 'LineWidth', 1.5), hold on        
    end
end


clearvars data
load('Crompton_Data')
figure(length(loc)*length(funcs)+1),plot([data{32}(:,1); data{33}(:,1)], [data{32}(:,2); data{33}(:,2)], '*', 'MarkerSize', 8)
axis([0,1,-1.5, 1]), set(gca,'Ydir','reverse')
xlabel('$\frac{x}{C} $','Interpreter','latex', 'FontSize', 18)
ylabel('$C_P$','Interpreter','latex', 'FontSize', 18,'rot',0)
legend(leg, 'Location', 'Best')
savefig('Plot Images\CP.fig')
print('Plot Images\CP', '-dpng')

figure(length(loc)*length(funcs)+2), plot(0.47, 0, '*')
axis([0,1,0,0.01])
xlabel('$\frac{x}{C} $','Interpreter','latex', 'FontSize', 18)
ylabel('$C_f$','Interpreter','latex', 'FontSize', 18,'rot',0)
legend(leg, 'Location', 'Best')
savefig('Plot Images\CF.fig')
print('Plot Images\CF', '-dpng')