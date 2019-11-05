string = ARGV[0]

def check_palindrome(str)
  str_unique = find_unique(str)
  values = str_unique.values
  count_of_1_char = values.count 1
  count_of_zero_char = values.count 0
  len = values.length
  if count_of_1_char == 1 || count_of_zero_char == values.length
    puts "String can be a palindrome"
  else
    puts "String can not be a palindrome"
end

end

def find_unique(str)
  a = {}
  str.each_char do |chars|
      cnt = str.count chars
      a[chars] = cnt%2 unless a.key? chars
  end
  a
end

check_palindrome(string)

