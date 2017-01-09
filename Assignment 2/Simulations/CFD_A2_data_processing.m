function CFD_A2_data_processing(name)
%% Close all plots, load data and find number and length of timesteps
hold off, close all
load(['Matlab-Data-Processing\', name, '.mat']);
tstep = data.CL(2,1)-data.CL(1,1);
tsteps = length(data.CP_centre);
%% Find max and min CL, CD and times of occurence
data.t1 = length(data.CL)-ceil(0.8003/tstep); % index of time point one wave period before end

[data.CLmin, data.CLminloc] = min(data.CL(data.t1:end,2));
data.CLminloc = data.CLminloc + data.t1-1;
data.CLmint = tstep*data.CLminloc;
[data.CLmax, data.CLmaxloc] = max(data.CL(data.t1:end,2));
data.CLmaxloc = data.CLmaxloc + data.t1-1;
data.CLmaxt = tstep*data.CLmaxloc;

[data.CDmin, data.CDminloc] = min(data.CD(data.t1:end,2));
data.CDminloc = data.CDminloc + data.t1-1;
data.CDmint = tstep*data.CDminloc;
[data.CDmax, data.CDmaxloc] = max(data.CD(data.t1:end,2));
data.CDmaxloc = data.CDmaxloc + data.t1-1;
data.CDmaxt = tstep*data.CDmaxloc;

[data.CMmin, data.CMminloc] = min(data.CM(data.t1:end,2));
data.CMminloc = data.CMminloc + data.t1-1;
data.CMmint = tstep*data.CMminloc;
[data.CMmax, data.CMmaxloc] = max(data.CM(data.t1:end,2));
data.CMmaxloc = data.CMmaxloc + data.t1-1;
data.CMmaxt = tstep*data.CMmaxloc;
%% Calculate average profiles over final wave period
data.CP_centre_av = zeros(size(data.CP_centre{end}));
data.CF_centre_av = zeros(size(data.CF_centre{end}));
data.CP02_av = zeros(size(data.CP02{end}));
data.CP04_av = zeros(size(data.CP04{end}));
data.CP06_av = zeros(size(data.CP06{end}));
data.CP08_av = zeros(size(data.CP08{end}));
data.CP09_av = zeros(size(data.CP09{end}));
for n = data.t1:tsteps
    data.CP_centre_av = data.CP_centre_av + data.CP_centre{n}/(tsteps - data.t1 + 1);
    data.CF_centre_av = data.CF_centre_av + data.CF_centre{n}/(tsteps - data.t1 + 1);
    data.CP02_av = data.CP02_av + data.CP02{n}/(tsteps - data.t1 + 1);
    data.CP04_av = data.CP04_av + data.CP04{n}/(tsteps - data.t1 + 1);
    data.CP06_av = data.CP06_av + data.CP06{n}/(tsteps - data.t1 + 1);
    data.CP08_av = data.CP08_av + data.CP08{n}/(tsteps - data.t1 + 1);
    data.CP09_av = data.CP09_av + data.CP09{n}/(tsteps - data.t1 + 1);
end
%%
save(['Matlab-Data-Processing\', name], 'data')
end