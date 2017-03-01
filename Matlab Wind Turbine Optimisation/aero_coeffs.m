function [cl, cd] = aero_coeffs(aoa, re, data)
cl = zeros(size(aoa));
cd = cl;
for n = 1:length(aoa)
    if re(n) >= max(data{2})
        cl(n) = interp1(data{1}(end,:), data{3}(end,:), rad2deg(aoa(n)));
        cd(n) = interp1(data{1}(end,:), data{4}(end,:), rad2deg(aoa(n)));
    elseif re(n) <= min(data{2})
        cl(n) = interp1(data{1}(1,:), data{3}(1,:), rad2deg(aoa(n)));
        cd(n) = interp1(data{1}(1,:), data{4}(1,:), rad2deg(aoa(n)));
    elseif isnan(re(n))
        cl(n) = 0;
        cd(n) = 1;
    else     
        Re1 = find(data{2}<re(n),1,'last');
        weight = 1-(re(n) - data{2}(Re1))/(data{2}(Re1+1)-data{2}(Re1));
        cl(n) = weight*interp1(data{1}(Re1,:), data{3}(Re1,:), rad2deg(aoa(n))) + (1-weight)*interp1(data{1}(Re1+1,:), data{3}(Re1+1,:), rad2deg(aoa(n)));
        cd(n) = weight*interp1(data{1}(Re1,:), data{4}(Re1,:), rad2deg(aoa(n))) + (1-weight)*interp1(data{1}(Re1+1,:), data{4}(Re1+1,:), rad2deg(aoa(n)));
end
end