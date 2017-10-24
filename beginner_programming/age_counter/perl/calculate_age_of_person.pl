#!/usr/bin/perl

use Time::Local;

$No_Of_Secs_In_A_Day  = 24 * 60 * 60;
$No_Of_Days_In_A_Year = 365;
print "Enter DOB in following format: (DD/MM/YYYY): ";
chomp($DOB = <STDIN>);
($Day, $Month, $Year) = split(/\D/, $DOB);

$DOB_Time = timelocal($Secs, $Mins, $Hours, $Day, ($Month-1), $Year);
$Age      = time() - $DOB_Time;
$Age      = int($Age/$No_Of_Secs_In_A_Day);
$Age      = int($Age/$No_Of_Days_In_A_Year);
print "Age of person is $Age";
