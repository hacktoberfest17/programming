def pattern03(n):
    pattern = ''
    for i in range(n, 0, -1):
        spaces = ' ' * (n - i)
        stars = '*' * i
        pattern += spaces + stars + '\n'
    return pattern

if __name__ == '__main__':
    n = int(input("Enter a range: "))
    print(pattern03(n))