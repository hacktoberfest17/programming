from functools import reduce

factorial = lambda w: reduce(lambda x,y: x*y, range(1,w+1), 1 if w >= 0 else 'Invalid input')
n = int(input('Enter your number: '))
print(factorial(n))
