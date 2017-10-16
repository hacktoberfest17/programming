#!/usr/bin/python
"""
Script to perform linear search on an array
"""

def linear_search(array,x):
    """
	arguments:
	----------
		array: list
        x: int

	returns:
	--------
		i/str: int or str

	description:
	------------
    Function to return index of element in an array using linear search method.
    """
    #initializing index holder
    i = 0
    length = len(array)

    #iterate till array[i] matches with x while i is within the index span of
    #array length
    while i < length and array[i] != x:
        i += 1
    if i == len(array):
        return "Element not found in array"
    else:
        return i+1

if __name__ == "__main__":
    #getting array and element from user
    array = (raw_input("Enter elements of array with space as delimeter:\n").strip()).split(" ")
    array = [int(element) for element in array]
    element = int(raw_input("Enter the element you want to search:\n"))
    
    print linear_search(array,element)
