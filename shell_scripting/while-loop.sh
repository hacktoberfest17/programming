#while loop in action
count=1
while [ $count -le 10 ]
do 
echo $count
count=`expr $count +1`
done


