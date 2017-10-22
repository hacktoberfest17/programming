#pattern
a=1
while [ $a -le 3 ]
do
	b=1
	while [ $b -le 3 ]
	do
		c=1
		while [ $c -le 3 ]
		do
			echo "$a$b$c"
			c=`expr $c + 1`
		done
		b=`expr $b + 1`
	done
	a=`expr $a + 1`
done
