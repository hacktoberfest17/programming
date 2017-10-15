import future

def fib(n):
    a, b = 0, 1
    while a < n:
        print(a)
        a, b = b, a+b
fib(1000)