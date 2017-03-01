clear all, hold off, close all, clc
rho = 1000;
nu = 1.5*10^-6;
%Pdes = 1*10^4;
Pdes = input('Enter desired power in watts: ');
B = 3;
%U = 25/2.25;
U = input('Enter design wind speed in m/s: ');
R = 1.2*sqrt(Pdes/(0.5*0.59*pi*rho*U^3));
X = 6;
omega =X*U/R;
%design_points = 20;
design_points = input('Enter number of design points along blade; ');
r = linspace(0.1*R, 0.99*R, design_points);
C = 1/B.*16.*pi.*r./0.5.*(sin(1/3.*atan2(R,X*r))).^2;
theta = 2/3*atan2(R,X*r)-deg2rad(15);
load('Airfoil Data/s833.mat')

% [~, P] = wind_turb_power(omega, B, U, R, C, theta, Pdes, data, rho, nu);

xinit = [omega, R, C, theta];
lb = [0, 0, zeros(size(C)), -pi/2*ones(size(C))];
ub = [inf, inf, inf*ones(size(C)), pi/2*ones(size(C))];
options = optimoptions(@fmincon,'Algorithm','sqp', 'PlotFcn', @optimplotfval,...
    'FiniteDifferenceStepSize', 0.005, 'FiniteDifferenceType','central',...
    'StepTolerance', 1e-12, 'TypicalX', xinit, 'Display', 'iter-detailed', 'UseParallel', true,...
     'MaxFunctionEvaluations', 100000);

nonlcon = @(x)wind_turb_power(x(1), B, U, x(2), x(3:2+length(C)), x(3+length(C):2*length(C)+2), Pdes, data, rho, nu);
fun = @(x) x(2);
x_opt = fmincon(fun,xinit,[],[],[],[],lb,ub,nonlcon, options);
omega_opt = x_opt(1)
R_opt = x_opt(2)
C_opt = x_opt(3:2+length(C))
theta_opt = x_opt(3+length(C):2*length(C)+2)
[~, Pdiff] = wind_turb_power(omega_opt, B, U, R_opt, C_opt, theta_opt, Pdes, data)