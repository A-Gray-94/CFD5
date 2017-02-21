%function delta = induction_factor_delt(B, vfar, omega, r, C, Beta,a,a_tang)
while delta > 0.0001;
% Calculate axial and tangential wind speeds
v_ax = (1-a).*vfar; 
v_tang = (1+a).*omega.*r;
% calculate effective wind angle and then angle of attack
theta = atan2(v_ax,v_tang); 
aoa = theta - Beta;
% Calculate Raynolds Number
Re = C.*sqrt(v_ax.^2+v_tang.^2)/1.4207e-5;
% Lookup COefficients of lift and drag based on aoa and reynolds number
CL = 0.2*pi*sin(aoa)
CD = CL.^2
CX = CL.*sin(theta) - CD.*cos(theta);
CY = CL.*cos(theta) + CD.*sin(theta);
f = B/2*(max(r)-r)./(r.*sin(theta));
Fp = 2/pi*acos(exp(-f));
sigma = C*B./(2*pi*r);
a_new = 1./((4*Fp.*(sin(theta).^2))./(sigma.*CY)+1)
a_tang_new = 1./((4*Fp.*sin(theta).*cos(theta))./(sigma.*CX)-1)
a_crit = 0.2;
for n = 1:length(a_new)
if a_new(n) > 0.2
    K = 4*Fp(n)*(sin(theta(n)).^2)./(sigma(n).*CY(n));
    a_new(n) = 0.5*(2+K*(1-2*a_crit)-sqrt((K*(1-2*a_crit)+2).^2+4*(K*a_crit^2-1)));
end
end
delta = max(abs([a_new-a, a_tang_new-a_tang]));
end