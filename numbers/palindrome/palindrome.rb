# assuming that palindrome only care about letters and numbers
def is_palindrome?(input)
  if input.is_a? Numeric
    input = input.to_s
  else
    input.downcase!
    input.gsub!(/[^\w|\d]/, "") # omit everything that is not word or number
  end
  input == input.reverse
end

puts "tests should PASS:"
p is_palindrome?("Hannah")
p is_palindrome?(123321)
p is_palindrome?("Was it a car or a cat I saw?")
p is_palindrome?("Salisbury moor, sir, is roomy. Rub Silas")

puts "tests should FAIL:"
p is_palindrome?("Hanna")
p is_palindrome?(37)
p is_palindrome?("palindrome")
p is_palindrome?("To be or not to be")


