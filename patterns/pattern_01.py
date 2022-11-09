def pattern01(n):
    pattern = ''
    for i in range(n - 1, -1, -1):
        spaces = ' ' * i
        stars = '*' * (n - i)
        pattern +=  spaces + stars + '\n'
    return pattern

if __name__ == '__main__':
    n = int(input("Enter a range: "))
    print(pattern01(n))