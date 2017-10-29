import sys
import os

def factorial(n):
    if(n<=1):
        return 1
    else:
        return(n*(factorial(n-1)))
        
n=int(input().strip())  
print(factorial(n))
