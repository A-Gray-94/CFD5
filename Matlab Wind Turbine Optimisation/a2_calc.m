function a2 = a2_calc(R,r,B,phi,sigma,ct)
    f = B/2*(R-r)./(r.*sin(phi));
    F = 2/pi*acos(exp(-f));
    a2 = ((4*F.*sin(phi).*cos(phi))./(sigma.*ct) - 1).^(-1);
    for i = 1:length(a)
        if a2(i)<0
            a2(i) = 0;
        end
        if a2(i)>1
            a2(i) = 1;
        end
    end