#! /usr/bin/python

number = int(input("Enter the number: "));
i = 0;
for j in range(1,number +1):
    if(number%j == 0):
        i= i+1;

if(i==2):
    print(number, "is a prime number");
else:
    print(number, "is not a prime number");
