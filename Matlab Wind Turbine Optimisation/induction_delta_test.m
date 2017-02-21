clear all, hold off, close all, clc
B = 3;
R = 20;
vfar = 25/2.25;
omega =7*vfar/R;
C = logspace(0.7,0,100);
Beta = linspace(pi/8,0,length(C));
TurbPerformance = Wind_Turbine_Calc(B, vfar, omega, R, C, Beta)