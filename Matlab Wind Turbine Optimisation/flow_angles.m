function [Un,Ut,phi,Ueff,aoa,Re,cl,cd,cn,ct] = flow_angles(omega, U, r, C, theta, a, a2, data, rho, nu)
    Un = U*(1-a);
    Ut = omega*r.*(1+a2);
    phi = atan2(Un,Ut);
    Ueff = sqrt(Un.^2 + Ut.^2);
    aoa = phi - theta;
    Re = Ueff.*C*rho/nu;
    [cl, cd] = aero_coeffs(aoa, Re, data);
    cn = cl.*cos(phi) + cd.*sin(phi);
    ct = cl.*sin(phi) - cd.*cos(phi);
end