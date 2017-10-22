#while loop in action
count=1
while [ $count -le 10 ]
do
	if [ $count -eq 4 ]
	then
		continue
	fi
	echo $count
	count=`expr $count +1`
done


