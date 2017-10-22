echo "Enter a no between 10 and 20:\c"
read num
#lt=less than
if [ $num -lt 10 ]
then 
echo "Under 10"
#greater than
elif [ $num -gt 20 ]
then
echo 
echo "More than 20"
else
echo "thats right"
fi
