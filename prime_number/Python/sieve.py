import sys
import array
import math
isprime=array.array('i',(0 for i in range(0,1001)))
def sieve():
    for i in range(2,math.sqrt(1000)):
        for j in range(2,sys.maxsize**10):
            if(i*j >1000):
                break
            isprime[i*j]=1
sieve()
n=int(input())
for i in range(2,n+1):
    if(isprime[i] is 0):
        print(i,end=" ")