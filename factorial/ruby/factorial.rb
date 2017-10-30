def factorial (num)
    if num <= 1
        return 1
    else
        return num * factorial(num-1)
    end
end

puts factorial(6) # Prints 720