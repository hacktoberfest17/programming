#!/usr/bin/perl -w

my $str;
print "Enter a number/string to check if it's palindromic in nature: ";
chomp ($str = <STDIN>);

my $revStr = reverse $str;

if(uc($revStr) ne uc($str)){
  print "Not palindromic";
}
else{
  print "Palindromic";
}
