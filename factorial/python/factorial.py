"""

Script to generate Factorial in python 2.7 and 3

"""

result = [i for i in range(1000)]

def fact_dp(n):
    result[0] = 1
    end = min(n, 1000) + 1
    for i in range(1, end):
        result[i] = i * result[i - 1]
    
    return result[n]

if __name__ == '__main__':
    
    n = None
    
    try:
        n = int(input("Enter a number :"))
    except ValueError:
        print("Not a number")

    if (n <= 0):
        print (1)
    else:
        print("Factorial : " + str(fact_dp(n)))
