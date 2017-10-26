def fibo(n):
  # if n is 1 return 1
  if n == 1:
    return 1
  # if n is 2 still return 1
  elif n == 2:
    return 1
  # else return the sum of last to terms
  elif n > 2:
    return fibo(n-1) + fibo(n-2)

# for loop for sum fibonacci numbers upto n
for i in range(1, 10):
  # printing fibonacci numbers according to term number 
  print(i, ":", fibo(i))