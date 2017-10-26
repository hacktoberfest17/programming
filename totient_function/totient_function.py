import math

def phi(n):
	total = n
	for i in range(2,int(math.sqrt(n) + 1)):
		if n % i == 0:
			while n % i == 0:
				n //= i
			total *= (1 - (1 / i))
	if n > 1:
		total *= (1 - (1 / n))
	return int(total) 

def main():

	for i in range(1, 11):
		print('phi(%d) = %d' % (i, phi(i)))

if __name__ == '__main__':
	main()
