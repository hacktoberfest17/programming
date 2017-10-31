def factorial(number = 0)
  return "Factorial cannot be calculated of a negative number" if num < 0

  if number <= 1
    1
  else
    number * factorial(number - 1)
  end
end
