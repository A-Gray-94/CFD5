function [c,ceq] = WTPC(x)
ceq = @(x)Wind_Turbine_Calc_pow(Pdes, B, vfar, x(1), x(2), x(3:3+length(Cinit)), x(4+length(Cinit):2*length(Cinit)+2));
c = [ ];