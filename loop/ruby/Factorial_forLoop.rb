def factorial number
  result = 1

  for i in 1..number 
    result *= i
  end

  result
end

puts factorial 6