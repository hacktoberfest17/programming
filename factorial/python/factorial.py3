def factorial(num):
    fac = 1
    if num == 0 or num == 1 :
	    return fac
    else:
        for n in range(1,num+1):
            fac = n*fac
    return fac

number = input("Enter number: ")

if(number.isdigit() and int(number)>0):
    print("Factorial of %s is %d"%(number,factorial(int(number))))

else:
    print("Invalid input")
    
                
