#!/usr/bin/env ruby
def gcd(a, b)
	if b.zero?
		return a
	else
		return gcd(b, a % b)
	end

end

# verify it works
unless ARGV[0] and ARGV[1]
  puts "Please pass 2 numbers as arguments, i.e. ./gcd.rb 14 28"
else
  puts gcd((ARGV[0]).to_i, (ARGV[1]).to_i)
end
