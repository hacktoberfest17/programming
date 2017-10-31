num1 = ARGV[0].to_f
num2 = ARGV[1].to_f

def add_numbers(number1, number2)
  number1 + number2
end

total = add_numbers(num1, num2)
puts "Total: #{total}"
