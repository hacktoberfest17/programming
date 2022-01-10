#This Scripts will allow to count prime numbers between two integers

# Taking input from the users   
min = int(input("Enter minumum number: "))  
max = int(input("Enter maximum number: ")) 
count = 0

for num in range(min, max+1):
    if num > 1:
        for a in range(2, num):
            if (num % a) == 0:
                break
        else:
            # If you want to print prime numbers between two integers then comment out the next line
            #print(num)
            count += 1
print('Total Number: ', count)