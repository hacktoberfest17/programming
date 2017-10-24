#!/usr/local/bin/python3.6
#This is my way of calculating factorial, i call it the half reverse way
from decimal import Decimal

factorial=input("Please give a number to factor: ")
factorial=int(factorial)
sum=1

halfF=factorial/2
halfF=int(halfF+1)
m=[]	#Here i use an array as a POC to display the results that will be used to calculate factorial
for i in range(1,halfF):
	j=factorial-i
	s=j*i
	m.append(s)
	print(i,"*",j,"=",s)
	sum*=s
sum*=2
print(sum)
print(m)
