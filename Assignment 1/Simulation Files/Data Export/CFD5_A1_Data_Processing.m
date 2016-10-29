% For reference data in mat files was saved using:
% loc = [0.031, 0.125, 0.25, 0.375, 0.5, 0.625, 0.75, 0.875, 1];
% funcs = {'u', 'urms', 'tke'};
% 
% for x = 1:length(loc);
%     for f = 1:length(funcs)
%
% data{1} = u0.031, data{2} = urms0.031, data{3} = tke0.031, data{4} = u0.125 etc
%%
clear all, hold off, close all, clc
models = {'KW', 'KWSST'};
durbin = {'WD', 'ND'};
grids = {'coarse', 'med', 'fine'};

for model = 1:length(models)
    for durb = 1:length(durbin)
        for grid = 1:length(grids)
        % Load mat files
        filename = [models{model}, '_', durbin{durb}, '_', grids{grid}, '_grid'];
        load(filename);
        % Correct TKE values
        for n = 2:3:26
            data{n}(:,2) = sqrt(data{n}(:,2)./sqrt(3));
        end
        % find reattachment point
        upper_cf = data{28};
        fun = @(x) interp1(upper_cf(:,1), upper_cf(:,2), x,'pchip');
        data{length(data)+1} = fminbnd(fun,0,1);
        disp([filename, 'Reattaches at ', num2str(data{length(data)})])
        % Store CL, CLP and CLS
        CL_hists = [data{31}, data{32}, data{33}];
        data{length(data)+1} = CL_hists(end, 2); %CL
        data{length(data)+1} = CL_hists(end, 4); %CLP
        data{length(data)+1} = CL_hists(end, 6); %CLS
        % Store Number of Elements
        if grid == 1
            data{length(data)+1} = 50199; % Coarse grid
        elseif grid == 2
            data{length(data)+1} = 73434; % Medium Grid
        else 
            data{length(data)+1} = 104518; % Fine Grid
        end
        clearvars CL_hists fun upper_cf
        save([filename, '_processed'], 'data');
        end
    end
end