function [c, ceq] = wind_turb_power(omega, B, U, R, C, theta, Pdes, data, rho, nu)
rho = 1000;
nu = 1.5*10^-6;
r = linspace(0.1*R, 0.99*R, length(C));
sigma = cos(theta).*C*B./(2*pi*r);
a = 0.3*ones(size(C));
a2 = 0.1*ones(size(C));
delta = 1;
epsilon = 0.001;
count = 0;
% %%
% options = optimoptions(@fmincon,'Algorithm','sqp', 'PlotFcn', @optimplotfval,...
%     'FiniteDifferenceStepSize', 0.01, 'FiniteDifferenceType','central',...
%     'StepTolerance', 1e-10, 'TypicalX', [0.25, 0.25], 'Display', 'iter-detailed');
% for sec = 1:length(C)
%     fun = @(x) sum(abs(x-new_a(omega, U, R, r(sec), C(sec), theta(sec), x(1), x(2), data, B, sigma(sec), rho, nu)));  
%     aa2 = fmincon(fun, [a(sec), a2(sec)], [], [], [], [], [0, 0], [1, 1], [], options);
%     a(sec) = aa2(1);
%     a2(sec) = aa2(2);
% end
% a
% a2
%%
% count = 0;
% while delta > epsilon && count<100
%     count = count+1;
%     aold = a;
%     a2old = a2;
%     [un,ut,phi,Ueff,aoa,Re,cl,cd,cn,ct] = flow_angles(omega, U, R, r, C, theta, a, a2, data, rho, nu);
%     [anew, a2new] = a_calc(R,r,B,phi,cn,sigma,ct);
% %     anew = smooth(anew,'sgolay')';
% %     a2new = smooth(a2new,'sgolay')';
%     figure(1), plot(r,anew,r,a2new), drawnow
%     delta = sum(abs(anew-a)+abs(a2new-a2));
%     a = 0.8*a+0.2*anew;
%     a2 = 0.8*a2+0.2*a2new;
% %     a = anew;
% %     a2 = a2new;
% %     pause(0.1)
% end
%%

while delta > epsilon && count <100
    count = count+1;
    [anew, a2new] = new_a(omega, U, R, r, C, theta, a, a2, data, B, sigma, rho, nu);
    delta = sum(abs([anew, a2new] - [a, a2]));
%     figure(1), plot(r,anew,r,a2new), drawnow
%     pause(0.2)
    a = real(0.8*a+0.2*anew);
    a2 = real(0.8*a2+0.2*a2new);
end
%%
[Un,Ut,phi,Ueff,aoa,Re,cl,cd,cn,ct] = flow_angles(omega, U, r, C, theta, a, a2, data, rho, nu);
Ft = 0.5*rho*ct.*C.*Ueff.^2;
ceq = Pdes-B*omega*trapz(r, Ft.*r);
c = [];

%% Plots
figure(2), subplot(2,2,1), [hAx,hLine1,hLine2] = plotyy(r,C,r,rad2deg(theta)); xlabel('Radius(m)');
ylabel(hAx(1),'Chord Length (m)');  ylabel(hAx(2),'Twist angle (deg)');
subplot(2,2,2), plot(r,rad2deg(aoa),r,rad2deg(phi)), xlabel('Radius(m)'), ylabel('\alpha, \phi (deg)')
subplot(2,2,3), plot(r,Ft), xlabel('Radius(m)'), ylabel('Tangential Force (N/m)')
subplot(2,2,4), plot(r,a,r,a2), xlabel('Radius(m)'), ylabel('Induction Factor ')
%legend('Axial', 'Tangential')
drawnow