%% BEM Wind turbine analysis function 27/3/16, Aladair Gray
function [c,ceq] = Wind_Turbine_Calc_pow_con(Pdes, B, vfar, omega, R, C, Beta)
% Vfar = farfield wind speed in m/s
% omega = wind turbine rotational speed in Rad/s
% R = Blade swept radius in m
% C = Vector containg chord lengths in m at evenly spaced point along blade 
% C = Vector containg twist angles in radians at evenly spaced point along
% blade, 0 radians is in plane of rotation
%% Diagnostics
if length(C) ~= length(Beta)
    disp('Chord length and twist angle vectors are different lengths, check input and try again')
    return
end
if R<0
    disp('Blade length is negative, check input and try again')
    return
end
if omega<0
    disp('Rotational speed is negative, check input and try again')
    return
end
if vfar<0
    disp('Wind speed is negative, check input and try again')
    return
end
%%
% Create vector of radius values for each chord point
r = linspace(0.05*R, R, length(C));
% initial guess for axial induction factor
a = 1/3*ones(size(r)); 
% initial guess for tangential induction factor
a_tang = 0*ones(size(r)); 
count = 0;
delta = 1;

while delta > 0.0001;
    if count >30
        break
    end
    count = count+1;
    % Calculate axial and tangential wind speeds
    v_ax = (1-a).*vfar;
    v_tang = (1+a).*omega.*r;
    % calculate effective wind angle and then angle of attack
    theta = atan2(v_ax,v_tang);
    aoa = theta - Beta;
    % Calculate Raynolds Number
    Re = C.*sqrt(v_ax.^2+v_tang.^2)/1.4207e-5;
    % Lookup COefficients of lift and drag based on aoa and reynolds number
    [TurbPerformance.CL, TurbPerformance.CD] = Turb_Aero_Coeff(aoa,Re,r);
    TurbPerformance.CX = TurbPerformance.CL.*sin(theta) - TurbPerformance.CD.*cos(theta);
    TurbPerformance.CY = TurbPerformance.CL.*cos(theta) + TurbPerformance.CD.*sin(theta);
    f = B/2*(max(r)-r)./(r.*sin(theta));
    Fp = 2/pi*acos(exp(-f));
    sigma = C*B./(2*pi*r);
    a_new = 1./((4*Fp.*(sin(theta).^2))./(sigma.*TurbPerformance.CY)+1);
%     a_tang_new = 1./((4*Fp.*sin(theta).*cos(theta))./(sigma.*CX)-1);
    a_crit = 0.2;
    for n = 1:length(a_new)
        if a_new(n) > 0.2
            K = 4*Fp(n)*(sin(theta(n)).^2)./(sigma(n).*TurbPerformance.CY(n));
            a_new(n) = 0.5*(2+K*(1-2*a_crit)-sqrt((K*(1-2*a_crit)+2).^2+4*(K*a_crit^2-1)));
        end
    end
%     delta = max(abs([a_new-a, a_tang_new-a_tang]));
    delta = max(abs(a_new-a));
    a = 0.5*(a_new+a);
%     a_tang = 0.5*(a_tang_new+a_tang);
%     a_tang(end) = interp1(r(1:end-1),a_tang(1:end-1),max(r),'pchip');
    a(end) = interp1(r(1:end-1),a(1:end-1),max(r),'pchip');
end
%% Power Output Calculation
% Calculate axial and tangential wind speeds
    v_ax = (1-a).*vfar;
    v_tang = (1+a).*omega.*r;
    % calculate effective wind angle and then angle of attack
    TurbPerformance.theta = atan2(v_ax,v_tang);
    TurbPerformance.aoa = theta - Beta;
    % Calculate Raynolds Number
    Re = C.*sqrt(v_ax.^2+v_tang.^2)/1.4207e-5;
%     TurbPerformance.CL = 0.2*pi*sin(TurbPerformance.aoa)+0.1;
%     TurbPerformance.CD = CL.^2+0.01;
%     TurbPerformance.CX = TurbPerformance.CL.*sin(TurbPerformance.theta) - TurbPerformance.CD.*cos(TurbPerformance.theta);
    Torque = 0.5*1.2*(v_ax.^2+v_tang.^2).*TurbPerformance.CX.*C.*r;
    Tau = @(x) interp1(r,(0.5*1.2*(v_ax.^2+v_tang.^2).*TurbPerformance.CX.*C.*r),x,'pchip');
    TurbPerformance.Power = omega*B*integral(Tau,min(r),max(r));
    TurbPerformance.CP = TurbPerformance.Power/(0.5*1.2*pi*R^2*vfar^3);
    ceq = TurbPerformance.Power-Pdes;
    c=[];
