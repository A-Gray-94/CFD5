function [Uphi, phi_0, coeffs, sigma] = uncertainty(h,phi)

fun = @(coeff) sum((phi - (coeff(1)*h.^coeff(2)+coeff(3))).^2);
[coeffs] = fminsearch(fun,[phi(1)/h(1), 1, phi(1)]);
sigma = std(abs(phi - (coeffs(1).*h.^coeffs(2)+coeffs(3))));
if coeffs(2)>=0.95
    Uphi = 1.25*abs(phi-coeffs(3))+sigma;
else
    Uphi = sigma + ((max(phi)-min(phi))/(1-(min(h)/max(h))));
end
phi_0 = coeffs(3);
end
