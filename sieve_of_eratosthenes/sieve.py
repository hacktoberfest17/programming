limit = input("Enter end range : ")
prime = [True] * (limit+1)
prime[0] = prime[1] = False
i = 2
while i <= limit:
	if prime[i]:
		j = i + i
		while j <= limit:
			prime[j] = False
			j += i
	i += 1

q = input("Enter the number of queries : ")
while q:
	number = input("Enter a number : ")
	print "PRIME" if prime[number] else "NOT PRIME"
	q -= 1
