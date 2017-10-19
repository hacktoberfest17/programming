fibonacci :: [Integer]
fibonacci = 1 : 1 : zipWith (+) fibonacci (tail fibonacci)

main :: IO ()
main = do
  putStrLn "Fibonacci"
  putStrLn "---------"
  putStrLn "Please choose a number:"
  input <- getLine
  putStrLn ""
  putStrLn "Result:"
  putStrLn . show $ take (read input :: Int) fibonacci
