#!/usr/bin/perl -w


my ($a, $b, $fib) = (1, 0, 0);

print "Enter the number of term to be printed: ";
chomp($range = <STDIN>);

my $iterator = 0;
while ($iterator < $range) {
  $fib = $a + $b;
  $a = $b;
  $b = $fib;
  $iterator++;
}

print "Output: $fib";
