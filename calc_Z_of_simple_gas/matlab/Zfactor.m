% -------- Short Description --------

%   Zscipt calculates Z for various P and T from composition input, assuming gas
%   of C1,C2,C3 only. 

% -------- Description --------

%   User is asked to provide composition values for C1,C2 & C3 and then Z
%   is calculated for T(50-200F) and P(14.7 and 100-2000 psia). Main output 
%   is a plot of Z vs P for four different T.
%   Secondary output is a table of Z values for the various P & T. Currently
%   the table is not displayed by default, however this can be changed by
%   removing the percent sign "%" from the last line of the script's
%   .m file.

%% --- 1. Input ---

% -- First-time Input

disp('Enter composition of gas. Note that the decimal point is "." and not ","')
C1= input('Enter C1: ')
C2= input('Enter C2: ')
C3= input('Enter C3: ')

% -- 1.2 Check if sum of C1,C2,C3 = 1 & user errors

proceed='n'; % So that it will enter the while_loop the first time if C1+C2+C3~=1
while C1+C2+C3~=1 & proceed== 'n'
    proceed= input('The given composition does not account for 100% of gas (sum of C1,C2,C3 =/=1). Continue anyway? (y/n | include single quotes in your answer): ');
    if proceed == 'n'
        disp('Enter composition of gas. Note that the decimal point is "." and not ","')
        C1= input('Enter C1: ')
        C2= input('Enter C2: ')
        C3= input('Enter C3: ')
    end
end

%% --- 2. Calculations ---

% -- 2.1 Basic Calculations

C = [C1 C2 C3];             % arranging composition values in a vector
MW = [16 30 44];            % Molecular weights for C1, C2 & C3 respectively
Sg = sum(C.*MW)/28.97       % Calculating Specific gravity for the specified (via composition) gas
Ppc = 677+15*Sg -37.5*Sg^2  % Calc of pseudo-critical Pressure
Tpc = 168+325*Sg-12.5*Sg^2  % Calc of pseudo-critical Temperature
Ppsia = [ 14.7 100:100:2000]; % Creates Pressure vector of 14.7 100 200 300... 2000 psia
Tf = [50:50:200];           % Creates Temperature vector (in Fahrenheit) with the following: 50 100 150 200
Tr = Tf+459.67;             % Converts the above to Rankine. Note that Tf(i) corresponds to Tr(i), e.g. Tf(3)= 150 & Tr(3)=150+459.67=Tf(3)+459.67
Ppr = Ppsia / Ppc;          % Calc of pseudo-reduced Pressure vector
Tpr = Tr/ Tpc;              % Calc of pseudo-reduced temperature vector
Ppr_mat=repmat(Ppr',1,length(Tpr)); % Create new Pressure matrix by repeating previous P values 4 times (for 4 different Temperature values) for element-wise calculations
Tpr_mat=repmat(Tpr,length(Ppr),1);  % Create new Temperature matrix by repeating previous T values 21 times (for 21 different Pressure values) for element-wise calculations

% -- 2.2 Calc of Z without loops

A= 1.39*(Tpr_mat-0.92).^0.5-0.36*Tpr_mat-0.101;
C= 0.132-0.32*log10(Tpr_mat);
D= 10.^(0.3106-0.49*Tpr_mat+0.1824*Tpr_mat.^2);
B= (0.62-0.23*Tpr_mat).*Ppr_mat+(0.066./(Tpr_mat-0.86)-0.037).*Ppr_mat.^2+0.32./(10.^(9.*(Tpr_mat-1))).*Ppr_mat.^6;
Znl= A+(1-A)./exp(B)+C.*Ppr_mat.^D;  % nl simply stands for no-loop.
Z= Znl';

%% --- 3. Output ---

% -- 3.1 Plot Z vs P

figure
plot(Ppsia,Z(1,:),Ppsia,Z(2,:),Ppsia,Z(3,:),Ppsia,Z(4,:))
title('Z vs P for various T')
xlabel('Pressure (psia)')
ylabel('Z')
legend('T=50F','T=100F','T=150F','T=200F')

% -- 3.2 Table output

%This will produce a table for which each row corresponds to a given
%Temperature (50, 100, 150, 200) and each column to a given Pressure
%(14.7,100,200...2000|N=21 values, 20 for 100...2000 plus 14.7).
%Simply remove the "%" from the last line.

%TABLE=array2table(Z)