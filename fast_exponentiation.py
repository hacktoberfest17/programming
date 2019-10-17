def fast_exp(x, n, p):
    """
    compute (x^n)%p
    """
    r = 1
    while (n):
        if n%2 == 1:
            r=(r*x)%p
            n-=1
        x = (x*x)%p
        n = n/2
    return r%p
