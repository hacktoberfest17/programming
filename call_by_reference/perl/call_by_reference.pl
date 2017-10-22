#!/usr/bin/perl -w

my $num1 = 100;
my $num2 = 5;

sub swap{
  $temp = $_[0];
  $_[0] = $_[1];
  $_[1] = $temp;
  return;
}

print "Value of num1 BEFORE swap $num1\n";
print "Value of num2 BEFORE swap $num2\n\n";

swap($num1, $num2);

print "Value of num1 AFTER swap $num1\n";
print "Value of num2 AFTER swap $num2";
