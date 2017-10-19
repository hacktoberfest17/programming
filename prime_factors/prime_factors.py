import math

def PrimeFactors(num):
	primeFactors = []
	for i in range(2, int(math.sqrt(num)) + 1):
		while num % i == 0:
			primeFactors.append(i)
			num //= i
	if num > 2:
		primeFactors.append(num)
	return primeFactors

def main():
	factors = PrimeFactors(36)
	print(factors)

if __name__ == '__main__':
	main()
