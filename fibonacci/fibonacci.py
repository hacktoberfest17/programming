#!/usr/bin/python
"""
Script to generate fibonacci series in python_2.7
"""

def fibonacci_series():
	"""
	arguments:
	----------
		none

	returns:
	--------
		v: series of int

	description:
	------------
		function to return fibonacci series from 1 to n terms
	"""
	#first and second terms
	n1 = 0
	n2 = 1

	#getting number of terms
	n = int(raw_input("Enter the number of terms: "))
	print "Fibonacci Series: ",

	if n == 0:
		print n1
	elif n == 1:
		print n1,", ",n2
	else:
		print n1,", ",n2,", ",
		for i in range(1,n):
			print n2+n1,", ",
			n3 = n2+n1
			n1 = n2
			n2 = n3

if __name__ == "__main__":
	fibonacci_series()
