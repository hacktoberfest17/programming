print "Enter the number of term(s): "
t = gets.chomp.to_i

# and now we do the numbers
n1 = 0
n2 = 1

if t == 1
	print "Fibonacci Series: #{n1}"

elsif t > 1
	print "Fibonacci Series: #{n1}, #{n2}, "
		for iteration in 1..t
			print n2 + n1,", "
			n3 = n2 + n1
			n1 = n2
			n2 = n3
	end
else
	print "Not accepted."
end
