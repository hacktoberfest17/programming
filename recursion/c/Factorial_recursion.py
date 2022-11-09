def factorial(num):
    fac = 1
    if num == 0 or num == 1 :
	    return fac
    else:
        return factorial(num-1)*num

number = input("Enter number: ")

if(number.isdigit() and int(number)>0):
    print("Factorial of %s is %d"%(number,factorial(int(number))))

else:
    print("Invalid input")
    
                
