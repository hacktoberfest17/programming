#!/bin/env python

def factorial(n):
    return 1 if (n < 1) else n * factorial(n-1)
    
user_input = int(input("Enter a number: "))

if user_input < 0:
    print("Sorry, factorial does not exist for negative numbers.")
else:
    print("The factorial of {} is {}".format(user_input, factorial(user_input))
