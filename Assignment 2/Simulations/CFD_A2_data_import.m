function CFD_A2_data_import(name, tstep, tlimit)
disp('Creating data structure to import to')
disp(' ')
tsteps = ceil(tlimit/tstep);
data.CF_centre = cell(1,tsteps);
data.CP_Centre = data.CF_centre;
data.CP02 = data.CF_centre;
data.CP04 = data.CF_centre;
data.CP06 = data.CF_centre;
data.CP08 = data.CF_centre;
data.CP09 = data.CF_centre;

folder = [ name, '\'];
filename = ['DWing-waves-', name];
formatspec = '%05d';
disp(['Starting import from ', folder, filename])
disp(' ')
%%
for n = 1:tsteps
    disp(['Importing data from time step ', num2str(n)])
    num = sprintf(formatspec,n);
    % Centre CF
    data.CF_centre{n} = csvread([folder, 'Centreline_Cf__', num, '.csv'], 1,0)/(0.5*1025*0.5^2);
    % Centre CP
    data.CP_centre{n} = csvread([folder, 'Centreline_CP__', num, '.csv'], 1,0);
    % CP02
    data.CP02{n} = csvread([folder, 'CP_xc_=_0.2__', num, '.csv'], 1,0);
    % CP04
    data.CP04{n} = csvread([folder, 'CP_xc_=_0.4__', num, '.csv'], 1,0);
    % CP06
    data.CP06{n} = csvread([folder, 'CP_xc_=_0.6__', num, '.csv'], 1,0);
    % CP08
    data.CP08{n} = csvread([folder, 'CP_xc_=_0.8__', num, '.csv'], 1,0);
    % CP09
    data.CP09{n} = csvread([folder, 'CP_xc_=_0.9__', num, '.csv'], 1,0);
end
%%
% CL
disp('Importing CL history')
disp(' ')
data.CL = csvread([folder, 'CL.csv'], 1,0);
% CD
disp('Importing CD history')
disp(' ')
data.CD = csvread([folder, 'CD.csv'], 1,0);
% CM
disp('Importing CM history')
disp(' ')
data.CM = csvread([folder, 'CM.csv'], 1,0);
% LD
disp('Importing LD history')
disp(' ')
data.LD = csvread([folder, 'LD.csv'], 1,0);
%%
disp(' ')
disp(['Data import complete, saving to Matlab-Data-Processing\', name])
disp(' ')
save(['Matlab-Data-Processing\', name], 'data')
disp('Finito!')
end