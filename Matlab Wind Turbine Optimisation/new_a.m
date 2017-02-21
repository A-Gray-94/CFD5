function [anew, a2new] = new_a(omega, U, R, r, C, theta, a, a2, data, B, sigma, rho, nu)
[~,~,phi,~,~,~,~,~,cn,ct] = flow_angles(omega, U, r, C, theta, a, a2, data, rho, nu);
[anew, a2new] = a_calc(R,r,B,phi,cn,sigma,ct);
end