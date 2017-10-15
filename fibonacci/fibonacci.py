num=int(input("Enter the number of elements of the series:"))
n1=0
n2=1
i=2
if num<=0:
    print("Enter a positive number.")
elif num=1:
    print("Fibonacci series upto",num,":")
    print(n1)
else:
    print(n1)
    print(n2)
    while i<num:
        n3=n1+n2
        print(n3)
        n1=n2
        n2=n3
        i=i+1
