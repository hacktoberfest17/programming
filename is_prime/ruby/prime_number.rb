#!/usr/bin/env ruby

def is_prime?(num)
  if num == 2
    return true
  elsif num < 2 || num % 2 == 0
    return false
  end
  for i in 3..Math.sqrt(num)
    return false if num % i == 0
  end
  return true
end

def is_number?(str)
  begin
    Float(str)
  rescue
    return false
  end
  return true
end

def prompt(*args)
  print(*args)
  gets.chomp
end

puts <<BANNER
This script will continually ask the user for numbers unless they enter "q" to close the program.
It will also check if the input is a valid number before attempting to check if it is prime.
BANNER
prompt_text = 'Please enter a number: '
number = prompt(prompt_text)
while number.casecmp('q') != 0
  if is_number?(number)
    if is_prime?(Float(number))
      puts "#{number} is prime"
    else
      puts "#{number} is not prime"
    end
  else
    puts "#{number} is not a valid number"
  end
  number = prompt(prompt_text)
end
