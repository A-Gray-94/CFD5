clear all, hold off, close all, clc
Pdes = 1*10^6;
B = 3;
U = 25/2.25;
R = 1.8*sqrt(Pdes/(0.5*0.59*pi*1.2*U^3));
X = 6;
omega =X*U/R;
design_points = 10;
r = linspace(0.1*R, 0.99*R, design_points);
C = 0.9/B.*16.*pi.*r./0.5.*(sin(1/3.*atan2(R,X*r))).^2;
theta = 2/3*atan2(R,X*r)-deg2rad(20);

% [~, P] = wind_turb_power(omega, B, U, R, C, theta, Pdes);

xinit = [omega, R, C, theta];
lb = [0, 0, zeros(size(C)), -pi/2*ones(size(C))];
ub = [inf, inf, inf*ones(size(C)), pi/2*ones(size(C))];
options = optimoptions(@fmincon,'Algorithm','sqp', 'PlotFcn', @optimplotfval,...
    'FiniteDifferenceStepSize', 0.04, 'FiniteDifferenceType','central',...
    'StepTolerance', 1e-12, 'TypicalX', xinit, 'Display', 'iter-detailed', 'UseParallel', true);

nonlcon = @(x)wind_turb_power(x(1), B, U, x(2), x(3:2+length(C)), x(3+length(C):2*length(C)+2), Pdes);
fun = @(x) x(2);
x_opt = fmincon(fun,xinit,[],[],[],[],lb,ub,nonlcon, options)
omega_opt = x_opt(1);
R_opt = x_opt(2);
C_opt = x_opt(3:2+length(C));
theta_opt = x_opt(3+length(C):2*length(C)+2);
[~, Pdiff] = wind_turb_power(omega_opt, B, U, R_opt, C_opt, theta_opt, Pdes)