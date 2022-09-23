# -*- coding: utf-8 -*-

from decimal import *
getcontext().Emax=999999999999

def fatorial(x):
    if x <= 2:
        print("Enter number > 2")
        return None
    fat = Decimal(1.0)
    f = Decimal(x)
    i = Decimal(2.0)

    while i <= f:
        fat = fat * i
        i = i + 1

    return fat


def main():
    number = int(input("Enter your number for fatorial: "))
    print(fatorial(number))


if __name__ == "__main__":
    main()
