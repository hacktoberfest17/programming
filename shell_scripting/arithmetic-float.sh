#arithmetic operations on float and real nos
a=10.5 b=3.5
# using | for feeding arithmetic operations to bc
c=`echo $a + $b | bc`
d=`echo $a - $b | bc`
e=`echo $a \* $b | bc`
f=`echo $a / $b | bc`
echo $c $d $e $f
