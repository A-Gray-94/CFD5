function anew = new_a2(omega, U, R, r, C, theta, a, a2, data, B, sigma, rho, nu)
[un,ut,phi,Ueff,aoa,Re,cl,cd,cn,ct] = flow_angles(omega, U, r, C, theta, a, a2, data, rho, nu);
a2 = a2_calc(R,r,B,phi,sigma,ct);
end