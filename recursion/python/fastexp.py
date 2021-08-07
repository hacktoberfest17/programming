from sys import argv

def fastexp(a, b):
    if b == 0:
        return 1
    elif b % 2 == 0:
        return fastexp(a, b // 2) ** 2
    else:
        return a * fastexp(a, b // 2) ** 2

def usage():
    print("Usage: python3 fastexp.py X Y")
    print("X and Y must be >= 0")

def main():
    if len(argv) < 3 or int(argv[1]) < 0 or int(argv[2]) < 0:
        usage()
        return 1
    else:
        print("%s ** %s = [%d]" % (argv[1], argv[2], fastexp(int(argv[1]), int(argv[2]))))

if __name__ == "__main__":
    main()
