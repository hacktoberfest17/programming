def fizz_buzz(var):
  if var%3 == 0 and var%5 == 0:
    return 'FizzBuzz'
  
  elif var%3 == 0:
    return 'Fizz'

  elif var%5 == 0:
    return 'Buzz'
  
  else:
    return var
