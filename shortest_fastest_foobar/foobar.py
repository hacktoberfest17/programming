def main():
    x = int(input("Enter any number: "))
    if x % 3 == 0:
        if x % 5 == 0:
            print("FizzBuzz")
        else:
            print("Fizz")
    if x % 5 == 0:
        print("Buzz")
        
        
main()
