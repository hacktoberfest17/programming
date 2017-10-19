#!/usr/bin/env python

import sys

def fib(N):
  a = 0
  b = 1
  for _ in range(N):
    a, b = b, a+b
  return a

if __name__ == '__main__':
  if len(sys.argv) >= 2:
    print(fib(int(sys.argv[1])))
  else:
    print(fib(int(input())))
