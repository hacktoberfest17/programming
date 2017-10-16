def factorial(num):
    if num <= 1:
        return 1
    else:
        return num * factorial(num - 1)

def main():
    print(factorial(7))

if __name__ == '__main__':
    main()
