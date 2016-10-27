function RefinementAnalysis(x,f)
% perform an analysis of results obtained from a mesh refinement study.
% Several metrics are computed including;
% - order of convergence
% - Richardson extrapolation of the continum value (zero mesh spacing)
% - Grid convergence index
%

% how many grids have been used ?
N=size(x,1);

fprintf('%i grids have been used.\n\n',N);
fprintf('Grid  Spacing  Function\n');
for i=1:N
    fprintf('%4i %6.3f %13.6f\n',i,x(i),f(i));
end
fprintf('\n\n');

% compute the mesh spacing
r=ones(N-1);
r(1:N-1)=x(2:N)./x(1:N-1);

% Estimate the order of convergence using the first three data pairs 
% and assuming that the grid refinement ratio is constant, r(1) = r(2).
% This is done using Eqn. 5.10.6.1 of (Roache, 1998).

p = abs(log( abs( f(3) - f(2) ) / abs( f(2) - f(1) ) )  /  log( r(1) ));

fprintf('Order of convergence using the first three finest grids\n');
fprintf('and assuming constant grid refinement.\n');
fprintf('Order of Convergence, p = %f\n\n',p);
 
%Perform Richardson extrapolation to estimate a zero grid value of f.

fexact = f(1) + ( f(1) - f(2) ) / ( r(1)^p - 1.0 );

fprintf('Richardson Extrapolation: Use above order of convergence\n');
fprintf('and first and second finest grids\n');
fprintf('Estimate to zero grid value, f_exact = %f\n\n', fexact);

%plot the points and the estimate
plot(x,f,'o-',[0],[fexact],'^','LineWidth',2,'MarkerSize',15);
title('Richardson extrapolation');
xlabel('h');
ylabel('f');

%Compute Grid Convergence Index (GCI) for each fine grid using Eqn. 5.6.1
%from Roache's book. Use factor of safety as recommended on page 123.

if ( N>2 ) 
   fsafe = 1.25;
else
   fsafe = 3.0;
end

for i=1:N-1
    gcif(i) = fsafe * ( abs( f(i+1) - f(i) ) / abs(f(i)) ) ...
    / ( r(i)^p - 1.0 );
end

fprintf('Grid Convergence Index on fine grids. Using p=%.3f \n',p);
fprintf('Factor of Safety = %.2f\n\n', fsafe);
fprintf('  Grid      Refinement\n');
fprintf('  Step      Ratio, r      GCI\n')
for i=1:N-1
   fprintf(' %2i %2i %13.6f %13.6f\n', i, i+1, r(i), gcif(i)*100.0);
end
fprintf('\n');

%Examine if asymptotic range has been achieved by examining ratio 
%of Eqn. 5.10.5.2 of Roache's book is one.

if ( N>2 ) 
   fprintf('Checking for asymptotic range using Eqn. 5.10.5.2.\n');
   fprintf('A ratio of 1.0 indicates asymptotic range.\n\n');
   fprintf('Grid Range   Ratio\n');
   for i = 1:N-2
      ratio = r(i)^p * gcif(i) / gcif(i+1);
      fprintf(' %1i%1i %1i%1i  %13.6f\n', i, i+1, i+1, i+2, ratio);
   end
   fprintf('\n');
end 
fprintf('\n--- End of Report ---\n\n');

