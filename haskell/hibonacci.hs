
recursive_fib    :: Integer -> Integer
recursive_fib 0  = 1
recursive_fib 1  = 1
recursive_fib n  = recursive_fib (n-1) + recursive_fib (n-2)

zipped_fib       :: [Integer]
zipped_fib       = 1 : 1 : zipWith (+) zipped_fib (tail zipped_fib)



main = do
  print (take 10 zipped_fib)
  print (map recursive_fib [1..10])
