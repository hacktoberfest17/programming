#until loop in action
count=1
until [ $count -ge 10 ]
do
	echo $count
	count=`expr $count + 1`
done
