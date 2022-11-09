import sys
import os

ef factorial(n):
    if(n<=1):
        return 1
    else:
        return(n*(factorial(n-1)))
        
n=int(input().strip())  
print(factorial(n))
