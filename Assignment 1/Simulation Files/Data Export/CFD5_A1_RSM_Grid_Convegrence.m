clear all, hold off, close all, clc

models = {'KW', 'KWSST'};
durbin = {'WD', 'ND'};
grids = {'fine', 'med', 'coarse'};
model = 2;
durb = 2;
x = zeros(3,1);
cl = x;
clp = x;
cls = x;
xr = x;


for grid = 1:length(grids)
    filename = ['RSM_', grids{grid}, '_grid_processed'];
    load(filename)
    x(grid) = data{41};
    cl(grid) = data{38};
    clp(grid) = data{39};
    cls(grid) = data{40};
    xr(grid) = data{37};
    clearvars data
end
x = x.^(-1/2);
x = x./min(x);
% XR Convergence
RefinementAnalysis(x,xr)
figure(1), title('Richardson extrapolation, Reattchment Length');
xlabel('h');
ylabel('$X_R$', 'Interpreter','latex', 'FontSize', 14);
print(['Grid Convergence\RSM_xr_convergence'], '-dpng');
savefig(['Grid Convergence\RSM_xr_convergence']);
close all
% CL Convergence
RefinementAnalysis(x,cl)
figure(1), title('Richardson extrapolation, Lift Coefficient');
xlabel('h');
ylabel('$C_L$', 'Interpreter','latex', 'FontSize', 14);
print(['Grid Convergence\RSM_CL_convergence'], '-dpng');
savefig(['Grid Convergence\RSM_CL_convergence']);
close all
% CLP Convergence
RefinementAnalysis(x,clp)
figure(1), title('Richardson extrapolation, Pressure Lift Coefficient');
xlabel('h');
ylabel('$C_{LP}$','Interpreter','latex', 'FontSize', 14);
print(['Grid Convergence\RSM_CLP_convergence'], '-dpng');
savefig(['Grid Convergence\RSM_CLP_convergence']);
close all
% CLS Convergence
RefinementAnalysis(x,cls)
figure(1), title('Richardson extrapolation, Shear Lift Coefficient');
xlabel('h');
ylabel('$$C_{L\tau}$$', 'Interpreter','latex', 'FontSize', 14, 'FontSize', 14);
print(['Grid Convergence\RSM_CLS_convergence'], '-dpng');
savefig(['Grid Convergence\RSM_CLS_convergence']);
close all