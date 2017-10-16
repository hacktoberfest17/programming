#!/usr/bin/python
"""

Script to generate fibonacci series in python_2.7 and python_3

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
	numbers = list()

	#getting number of terms
	n = int(input("Enter the number of terms: "))
	

	if n == 0:
		numbers.append(n1)
	elif n == 1:
		numbers.append(n1)
		numbers.append(n2)
	else:
		numbers.append(n1)
		numbers.append(n2)
		for i in range(1,n):
			numbers.append(n2+n1)
			n3 = n2+n1
			n1 = n2
			n2 = n3
	print("Fibonacci Series: " + str(numbers))

if __name__ == "__main__":
	fibonacci_series()
