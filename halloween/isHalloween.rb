require 'date'

date = Date.today

if date.mon == 10 and date.day == 31
  puts "Happy Halloween!"
elsif date.mon == 10 
  puts "It's October, but today is not Halloween!"
else 
  puts "It's not October"
end
