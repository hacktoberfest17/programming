def pattern02(n):
    pattern = ''
    for i in range(n, 0, -1):
        stars = '*' * i
        pattern += stars + '\n'
    return pattern

if __name__ == '__main__':
    n = int(input("Enter a range: "))
    print(pattern02(n))