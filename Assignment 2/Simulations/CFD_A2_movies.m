function CFD_A2_movies(name)
%% Close all plots, load data and find number and length of timesteps
hold off, close all
load(['Matlab-Data-Processing\', name, '.mat']);
tstep = data.CL(2,1)-data.CL(1,1);
tsteps = length(data.CP_centre);
%% Find max and min CL, CD and times of occurence
t1 = length(data.CL)-ceil(0.8003/tstep); % index of time point one wave period before end
[data.CLmin, data.CLminloc] = min(data.CL(t1:end,2));
data.CLmint = tstep*data.CLminloc;
[data.CLmax, data.CLmaxloc] = max(data.CL(t1:end,2));
data.CLmaxt = tstep*data.CLmaxloc;
[data.CDmin, data.CDminloc] = min(data.CD(t1:end,2));
data.CDmint = tstep*data.CDminloc;
[data.CDmax, data.CDmaxloc] = max(data.CD(t1:end,2));
data.CDmaxt = tstep*data.CDmaxloc;
%% Plot average CP profiles

save(['Matlab-Data-Processing\', name], 'data')
end