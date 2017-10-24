# What is the 10,001st prime number?


def sieve(n):
    """pre: n is an int, n >= 4
    post: returns a list of primes <= n"""
    s = range(2, n + 1)
    i = 0        # index of divisor
    d = s[i]     # divisor is first elt
    while d * d <= n:
        s = [n for n in s if n <= d or n % d != 0]
        i += 1
        d = s[i]  # next divisor
    return s


# The size of the sieve was determined by binary search and
# really should be counted in the time.
if __name__ == "__main__":
    print(sieve(105000)[10000])  # 104743, 0.22629523277282715 sec.
# p7-brute.py is only 0.01 sec longer and is completely general-purpose.
