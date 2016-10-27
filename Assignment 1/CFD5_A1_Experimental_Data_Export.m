loc = [0.031, 0.125, 0.25, 0.375, 0.5, 0.625, 0.75, 0.875, 1];
funcs = {'velocity', 'urms'};

for x = 1:length(loc);
    for f = 1:length(funcs)
        filename = ['x', num2str(loc(x)), '_', funcs{f}, '.csv'];
        data{(x-1)*(length(funcs)+1)+f} = csvread(filename,1,0);
        if f ==2
            data{(x-1)*(length(funcs)+1)+f+1} = data{(x-1)*(length(funcs)+1)+f}
            data{(x-1)*(length(funcs)+1)+f+1}(:,1) = 0.5*(3*data{(x-1)*(length(funcs)+1)+f}(:,1).^2);
        end
    end
end
data{length(data)+1} = csvread('CP_Upper.csv',1,0);

data{length(data)+1} = csvread('CP_Lower.csv',1,0);

save('Crompton_Data', 'data')