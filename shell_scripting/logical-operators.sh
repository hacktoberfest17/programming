echo "Enter a no between 50 and 100"
read num
#-a for and
#-o for or
if [ $num -le 100 -a $num -ge 50 ]
then 
echo "Correct"
fi


