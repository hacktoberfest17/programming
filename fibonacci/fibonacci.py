n=int(input("Enter the number of terms needed "))
a,b = 0,1
print a,b,
while(n-2):
    c=a+b
    a=b
    b=c
    print c,
    n=n-1

