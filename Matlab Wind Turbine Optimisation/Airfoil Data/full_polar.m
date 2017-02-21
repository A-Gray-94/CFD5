%% Creating a full airfoil polar
function [alpha, CL, CD] = full_polar(aoa, cl, cd)

%% Fist find alpha where cl = 0 and the max cl
maxcl = 1.2;
mincl = -1.2;
mincd = min(cd);
maxcd = 2;
alpha = -90:0.5:90;
CL = zeros(size(alpha));
CD = CL;
maxaoa = max(aoa);
minaoa = min(aoa);
transition_point = 30;
%% Create the CL and CD vectors
for i = 1:length(alpha)
    if alpha(i)<= maxaoa && alpha(i)>=minaoa %% If aoa is in range of supplied data then use that data
        CL(i) = interp1(aoa,cl,alpha(i));
        CD(i) = interp1(aoa,cd,alpha(i));
    elseif alpha(i) > maxaoa && alpha(i)<transition_point
        CL(i) = interp1(aoa,cl,alpha(i), 'linear', 'extrap')*(cos(deg2rad(90*(alpha(i)-maxaoa)/(transition_point-maxaoa)))^2) + maxcl*sin(2*deg2rad(alpha(i)))*(sin(deg2rad(90*(alpha(i)-maxaoa)/(transition_point-maxaoa)))^2);
        CD(i) = interp1(aoa,cd,alpha(i), 'linear', 'extrap')*(cos(deg2rad(90*(alpha(i)-maxaoa)/(transition_point-maxaoa)))^2) + (-0.5*(cos(deg2rad(2*alpha(i)))-1)*(maxcd-mincd)+mincd)*(sin(deg2rad(90*(alpha(i)-maxaoa)/(transition_point-maxaoa)))^2);
    elseif alpha(i) >= transition_point 
        CL(i) = maxcl*sin(2*deg2rad(alpha(i)));
        CD(i) = (-0.5*(cos(deg2rad(2*alpha(i)))-1)*(maxcd-mincd)+mincd);
        elseif alpha(i) <= -transition_point 
        CL(i) = -mincl*sin(2*deg2rad(alpha(i)));
        CD(i) = (-0.5*(cos(deg2rad(2*alpha(i)))-1)*(maxcd-mincd)+mincd);
    elseif alpha(i) < minaoa
        CL(i) = interp1(aoa,cl,alpha(i), 'linear', 'extrap')*(cos(deg2rad(90*(alpha(i)-minaoa)/(-transition_point-minaoa)))^2) + -mincl*sin(2*deg2rad(alpha(i)))*(sin(deg2rad(90*(alpha(i)-minaoa)/(-transition_point-minaoa)))^2);
        CD(i) = interp1(aoa,cd,alpha(i), 'linear', 'extrap')*(cos(deg2rad(90*(alpha(i)-minaoa)/(-transition_point-minaoa)))^2) + (-0.5*(cos(deg2rad(2*alpha(i)))-1)*(maxcd-mincd)+mincd)*(sin(deg2rad(90*(alpha(i)-minaoa)/(-transition_point-minaoa)))^2);
    end
end
