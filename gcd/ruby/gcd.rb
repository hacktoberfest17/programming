#!/usr/bin/env ruby
def gcd(a, b)
	if b.zero?
		return a
	else
		return gcd(b, a % b)
	end

end

# verify it works
puts(gcd(15, 25))
puts(gcd(100, 10))
