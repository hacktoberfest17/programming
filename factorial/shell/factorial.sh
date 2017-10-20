#!/bin/bash
fact=1
#taking input from user
echo -e "Please enter a finite possitive number"
read n
#if enter value less than 0
if [ $n -le 0 ] ; then
echo "invalid number"
exit
fi
#factorial logic
if [ $n -gt 0 ] ; then
for((i=$n;i>=1;i--))
do
fact=`expr $fact \* $i`
done
fi
echo "The factorial of $n is $fact"
