#!/usr/bin/perl -w

print "Enter a positive integer: ";
chomp($number = <STDIN>);

my ($iterator, $status) = (2, 0);

while($iterator <= $number-1) {
  if ($number % $iterator == 0) {
    $status = 1;
    last;
  }
  $iterator++;
}

if ($status == 0) {
  print "$number IS a prime number";
} else {
  print "$number is NOT a prime number";
}
