%% CFD5 Assignment 2 Calculations
% Alasdair Gray, S1208454
% 18/11/2016
clear all, hold off, close all, clc
%% Define Concstants
Snumber = 1208454; % Student number used for sweep angle
Re = 5*10^4; % Reynolds Number
Fr = 0.5048; % Froude number
Wave_Steepness = 1/100; % Wave steepness (wave height/wavelength)
aoa = 30; % Angle of attack in degrees
nu = 10^-6; % Kinematic viscosity of water in m^2/s
g = 9.81; % Gravitational acceleration in m^2/s^2
%% Calculate remaining parameters
sweep = (Snumber-1115272)/(565434)*10 + 62.5;
c = ((Re*nu)^2/(Fr^2*g))^(1/3);
U = Re*nu/c;
lambda = 10*c;
H = lambda*Wave_Steepness;
apex_depth = -0.2*lambda;
C = sqrt((g*lambda)/(2*pi));
T = lambda/C;
f = 1/T;
omega = 2*pi/T; % Wave frequency
q = 2*pi/lambda; % Wave number
span = c*sin(deg2rad(90-sweep)); % Base span
Area = 1/2*c*span; % Wing planform area
AR = span^2/Area; % Wing Aspect ratio
kv = csvread('images\Kv.csv',1,0);
kp = csvread('images\Kp.csv',1,0);
KV = interp1(kv(:,1), kv(:,2), AR);
KP = interp1(kp(:,1), kp(:,2), AR);
CL = KP*sin(deg2rad(aoa))*cos(deg2rad(aoa))^2+KV*cos(deg2rad(aoa))*sin(deg2rad(aoa))^2;
%% Plots
% x = linspace(-5*c, 5*c, 200);
% z = linspace(-4*c, 0 , 200);
% t = linspace(0, 10*T, 100);
% [X,Z] = meshgrid(x,z);
% 
% V = zeros(length(x), length(z), length(t));
% 
% for i = 1:length(t)
%     V(:,:,i) = -(H*omega/2)*exp(q*Z).*cos(q*X - omega*t(i));
%     eta(:,i) = H/2*sin(q*x - omega*t(i));
%     subplot(2,1,2), contourf(X,Z,V(:,:,i)),colorbar('southoutside'), hold on
%     subplot(2,1,2), plot([0, c*cos(deg2rad(aoa))], [apex_depth, apex_depth-c*sin(deg2rad(aoa))], 'k-', 'LineWidth', 2), hold off
%     subplot(2,1,1), plot(x,eta(:,i)), axis([min(x), max(x), min(min(eta)), max(max(eta))]);
%     pause(0.001)
% end

%% Simulation Values
% Figure out some rough domain sizes and the timestep
leg = {};
i = 10:5:50;
for n = 1:length(i)
    x = linspace(0,2*pi,i(n));
    leg{n} = num2str(i(n));
    plot(x, sin(x), '*-'), hold on
    legend(leg)
end
x_dom = (4 + 15)*c;
y_dom = -apex_depth+5*c; 
strouhal = 10;
f_vortex = strouhal*U/c;
T_vortex = 1/f_vortex;
t_step = T/20;
t_ratio = t_step/T_vortex;