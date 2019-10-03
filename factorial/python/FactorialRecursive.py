def factorial(n):
    if n == 0:
        return 1
    return n * factorial(n-1)

n = int(input("Number: "))
print("Factorial of {}: {}".format(n, factorial(n)))
