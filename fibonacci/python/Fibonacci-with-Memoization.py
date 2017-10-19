##################################################
# Recursive Fibonacci in Python with Memoization #
#################################################


# Array for saving calculated ones 
fib_mem = [0]*100000
fib_mem[0] = 0
fib_mem[1] = 1


def fibonacci(n):
  
    # first two elements are 0 and 1
    if n <= 1:
        return fib_mem[n]
    
    # if it calculated before return it from fib_mem
    if fib_mem[n]:
        return fib_mem[n]
    
    # else calculate and save it into fib_mem
    else:
        fib_mem[n] = fibonacci(n - 1) + fibonacci(n - 2)
        return fib_mem[n]


def main():
  
    # Take input 
    n = int(input("Enter the number of terms: \n"))

    # setting the values of array
    temp = fibonacci(n)
    
    # loop an print the series
    for i in range(n):
        print(fib_mem[i])

# Run the script
main()
 
