#!/usr/bin/perl -w

# subroutine to calculate factorial
sub getFactorial {
  my ($num) = @_;
  return 1 if $num == 0;
  return getFactorial($num-1) * $num;
}

print "Enter a number to calculate factorial: ";
chomp ($sample = <STDIN>);

if($sample == 0 or $sample == 1){
  print "Factorial of $sample is 1";
} elsif($sample < 0){
  print "Cannot calculate factorial of negative number";
} else {
  $fact = getFactorial($sample);
  print "Factorial of $sample is $fact";
}
