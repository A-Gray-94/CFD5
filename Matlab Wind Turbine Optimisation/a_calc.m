function [a, a2] = a_calc(R,r,B,phi,cn,sigma,ct)
    ac = 0.2;
    f = B/2*(R-r)./(r.*sin(phi));
    F = 2/pi*acos(exp(-f));
    a = (1+(4*F.*(sin(phi).^2))./(sigma.*cn)).^(-1);
    a2 = ((4*F.*sin(phi).*cos(phi))./(sigma.*ct) - 1).^(-1);
    for i = 1:length(a)
        if a(i)>ac
            K = (4*F(i).*(sin(phi(i)).^2))./(sigma(i).*cn(i));
            a(i) = 0.5*(2+K*(1-ac) - sqrt((K*(1-2*ac)+2)^2+4*(K*ac^2-1)));
        end
%         if a2(i)<0
%             a2(i) = 0;
%         end
%         if a(i)<0
%             a(i) = 0;
%         end
%         if a2(i)>1
%             a2(i) = 1;
%         end
%         if a(i)>1
%             a(i) = 1;
%         end
    end