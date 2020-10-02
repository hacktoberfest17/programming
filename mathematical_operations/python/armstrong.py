number = int(input("Enter a number: "))

# initialize sum
sum = 0  
temp = number  
  
while temp > 0:  
   digit = temp % 10  
   sum += digit ** 3  
   temp //= 10  
    
  # displaying the result
if number == sum:  
   print(number,"is an Armstrong number")  
else:  
   print(number,"is not an Armstrong number")  
