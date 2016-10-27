function CFD5_A1_Export(save_name)
loc = [0.031, 0.125, 0.25, 0.375, 0.5, 0.625, 0.75, 0.875, 1];
funcs = {'u', 'urms', 'tke'};

for x = 1:length(loc);
    for f = 1:length(funcs)
        filename = [num2str(loc(x)), 'c_', funcs{f}, '.csv'];
        data{(x-1)*length(funcs)+f} = csvread(filename,1,0); 
        delete(filename)
    end
end
data{length(data)+1} = csvread('upper_cf.csv',1,0);
delete('upper_cf.csv')
data{length(data)+1} = csvread('upper_tau.csv',1,0);
delete('upper_tau.csv')
data{length(data)+1} = csvread('upper_y+.csv',1,0);
delete('upper_y+.csv')
if nargin ==1
    save(save_name, 'data');
else
    save('CFD5_A1_Data', 'data')
end