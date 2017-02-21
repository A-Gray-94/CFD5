clear all, hold off, close all, clc
load s834
reynolds = [50, 100, 200, 500, 1000]*1000;
symbol = {'o', '*', '+', 's', '^'};
for n = 1:length(CL)
    [~, loc] = min(abs(reynolds-Re(n)));
    yyaxis left 
    plot(Alpha(n), CL(n), [symbol{loc}]), hold on
    yyaxis right
    plot(Alpha(n), CD(n), [symbol{loc}]), hold on
end
yyaxis left, ylabel('C_L')
yyaxis right, ylabel('C_D')
xlabel('\alpha (deg)')