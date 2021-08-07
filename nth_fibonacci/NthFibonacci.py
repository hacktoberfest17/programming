#!/usr/bin/env python

import sys
from math import sqrt


def fib_formula(n):
    return int(((1+sqrt(5))**n-(1-sqrt(5))**n)/(2**n*sqrt(5)))


def fib(n):
    a = 0
    b = 1
    for _ in range(n):
        a, b = b, a + b
    return a


if __name__ == '__main__':
    if len(sys.argv) >= 2:
        print(fib(int(sys.argv[1])))
    else:
        print(fib(int(input())))
