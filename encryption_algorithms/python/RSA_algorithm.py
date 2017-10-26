#RSA encryption algorithm

def main():
    n = e = d = 0
    while 1:
        print("""
    1. Set Public Key
    2. Encode
    3. Decode
    0. Quit
    Your choice? """, end = "")
        choice = int(input())
        if not choice:
            return
        if choice == 1:
            n, e, d = set_keys()
        if choice == 2:
            if not n:
                n = int(input("Public Key: "))
                e = int(input("e: "))
            encode(n, e)
        if choice == 3:
            if not d:
                n, e, d = set_keys()
            decode(d, n)
 
def set_keys():
    """This fuction asks for 2 primes.
    It sets a public key and an encoding number, 'e'."""
    p = int(input("prime(p): "))
    q = int(input("prime(q): "))
    n = p * q
    m = (p - 1) * (q - 1)
    e = get_e(m)
    print("N = ", n, "\ne = ", e)
    d = get_d(e, m)
    while d < 0:
         d += m
    return [n, e, d]
 
def encode(n, e):
    """This function asks for a number and encodes it using 'n' and 'e'."""
    while 1:
        c = int(input("Number to encode: "))
        if not c:
            return
        print(pow(c, e, n))
 
def decode(d, n):
    """This function asks for a number and decodes it using 'd' and 'n'."""
    while 1:
        c = int(input("Number to decode: "))
        if not c:
            return
        else:
            print(pow(c, d, n))
      
def even(x):
    """True if x is even."""
    return x % 2 == 0
 
def get_e(m):
    """Finds an e coprime with m."""
    e = 2
    while gcd(e, m) != 1:
        e += 1
    return e
 
def gcd(a,b):
    """Euclid's Algorithm: Takes two integers and returns gcd."""
    while b > 0:
        a, b = b, a % b
    return a
 
def get_d(e, m):
    """Takes encoding number, 'e' and the value for 'm' (p-1) * (q-1).
    Returns a decoding number."""
    x = lasty = 0
    lastx = y = 1
    while m != 0:
        q = e // m
        e, m = m, e % m
        x, lastx = lastx - q*x, x
        y, lasty = lasty - q*y, y
    return lastx
 
if __name__ == "__main__":
    main()
