clear all, clc
Re = [50, 100, 200, 500, 1000]*1000;
airfoil = {'833', '834', '835'};
for i = 1:length(airfoil)
    Length = 0;
    Alpha = zeros(length(Re),length(-90:0.5:90));
    CL = Alpha;
    CD = Alpha;
    for j = 1:length(Re)
        %% Initialize variables
        filename = ['C:\Users\Ali\Documents\MEGA\CFD Stuff\Matlab Wind Turbine Optimisation\Airfoil Data\xf-s', airfoil{i},'-nr-',num2str(Re(j)),'.txt'];
        startRow = 13;
        endRow = numel(textread(filename,'%1c%*[^\n]'))+5;
        
        %% Format string for each line of text:
        %   column1: double (%f)
        %	column2: double (%f)
        %   column3: double (%f)
        % For more information, see the TEXTSCAN documentation.
        formatSpec = '%8f%9f%10f%[^\n\r]';
        
        %% Open the text file.
        fileID = fopen(filename,'r');
        
        %% Read columns of data according to format string.
        % This call is based on the structure of the file used to generate this
        % code. If an error occurs for a different file, try regenerating the code
        % from the Import Tool.
        dataArray = textscan(fileID, formatSpec, endRow-startRow+1, 'Delimiter', '', 'WhiteSpace', '', 'HeaderLines', startRow-1, 'ReturnOnError', false);
        
        %% Close the text file.
        fclose(fileID);
        
        %% Post processing for unimportable data.
        % No unimportable data rules were applied during the import, so no post
        % processing code is included. To generate code which works for
        % unimportable data, select unimportable cells in a file and regenerate the
        % script.
        
        %% Allocate imported array to column variable names
        [Alpha(j,:), CL(j,:), CD(j,:)] = full_polar(dataArray{1}', dataArray{2}', dataArray{3}');
        %% Clear temporary variables
        clearvars filename startRow endRow formatSpec fileID dataArray ans;
    end
    data = {Alpha, Re, CL, CD};
    save(['s', airfoil{i}], 'data');
    clearvars -except Re airfoil i j
end