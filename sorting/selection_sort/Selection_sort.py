#!/usr/bin/python

"""
Script to perform sorting on an list using selection sort
"""


def find_smallest_index(L,i):
	"""
	arguments:
	---------
		L: list
		i: int

	returns:
	--------
		i: int

	description:
	------------
		Returns index of smallest value from a list from given index position (i) till end of the list

	>>> find_smallest_index([1,4,2,3],1)
	2

	>>> find_smallest_index([8,6,4,1,2],2)
	3
	"""
	#initialising placeholders for minvalue and minindex
	min_value = L[i]
	min_value_index = i

	for i in range(i,len(L)):
		if L[i] < min_value :
			min_value = L[i]
			min_value_index = i

	return min_value_index

def Selection_sort():
	"""
	arguments:
	---------
		none

	returns:
	--------
		array: list

	description:
	------------
		Returns a sorted form of a given list

	>>> Selection_sort()
	Enter the elements of array with space as delimeter: 4 6 7 8 2
	Sorted list: [2, 4, 6, 7, 8]

	>>> Selection_sort()
	Enter the elements of array with space as delimeter: 9 0 0 0 1
	Sorted list: [9, 0, 0, 0, 1]

	"""
	#getting elements of list from user
	L = (raw_input("Enter the elements of array with space as delimeter: \n").strip()).split(" ")
	L = [int(element) for element in L]

	for i in range(len(L)):
		smallest_index = find_smallest_index(L,i)
		L[i],L[smallest_index] = L[smallest_index],L[i]
		print L

	print "Sorted list : ",L
	return L

if __name__ == "__main__":
	Selection_sort()
