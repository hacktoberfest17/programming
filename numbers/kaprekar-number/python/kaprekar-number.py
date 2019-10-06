import math 

def iskaprekar( n): 
	if n == 1 : 
		return True
	
	sq_n = n * n 
	count_digits = 1
	while not sq_n == 0 : 
		count_digits = count_digits + 1
		sq_n = sq_n / 10
	
	sq_n = n*n 
	
	r_digits = 0
	while r_digits< count_digits : 
		r_digits = r_digits + 1
		eq_parts = (int) (math.pow(10, r_digits)) 
		
		if eq_parts == n : 
			continue
				
		sum = sq_n/eq_parts + sq_n % eq_parts 
		if sum == n : 
			return True
	
	return False
	
i=1
while i<10000 : 
	if (iskaprekar(i)) : 
		print i," ", 
	i = i + 1
