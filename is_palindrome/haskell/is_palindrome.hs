isPalindrome :: [Char] -> String
isPalindrome word
  | word == reverse word = word ++ " is a palindrome."
  | otherwise            = word ++ " is not a palindrome."

main = do  
    putStrLn "Enter the word"  
    w <- getLine  
    putStrLn (isPalindrome w) 
