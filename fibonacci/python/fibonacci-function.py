def fib(n):
    r5 = 5.0**0.5
    return int(1/r5*(((1+r5)/2)**n-((1-r5)/2)**n))

while True:
    x = int(input("Which fibonacci number would you like to know? "))
    print(fib(x))
