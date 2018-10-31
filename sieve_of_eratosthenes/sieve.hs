primes = sieve [2..]
       where
       sieve (p:xs) = p : sieve [a | a <- xs, a `mod` p /= 0]
