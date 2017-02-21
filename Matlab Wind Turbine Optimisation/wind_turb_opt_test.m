clear all, hold off, close all, clc
addpath(genpath('Airfoil Data'))
Pdes = 10^5;

x0 = [omegainit, Rinit, Cinit, Betainit];
lb = [0.1*vfar/Rinit,Rinit/2,0.001*Rinit*ones(size(Cinit)),-pi/2*ones(size(Betainit))];
ub = [15*vfar/Rinit,2*Rinit,4*pi*rinit/B,pi/2*ones(size(Betainit))];
options = optimoptions('fmincon','Display','iter','Algorithm','interior-point');
fun = @(x)Wind_Turbine_Calc_opt(B, vfar, x(1), x(2), x(3:2+length(Cinit)), x(3+length(Cinit):2*length(Cinit)+2));
nonlcon = @(x)Wind_Turbine_Calc_Pow_con(Pdes, B, vfar, x(1), x(2), x(3:2+length(Cinit)), x(3+length(Cinit):2*length(Cinit)+2));
x = fmincon(fun,x0,[],[],[],[],lb,ub,nonlcon,options);
TurbParam.Omega = x(1);
TurbParam.R = x(2);
TurbParam.C = x(3:3+design_points-1);
TurbParam.Beta = x(length(x)-design_points+1:end);
TurbParam