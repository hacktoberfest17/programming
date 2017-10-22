def modular_exponential(base, power, modulus):

	if base > modulus:
		base %= modulus

	result = 1

	while power > 0:
		if power & 1:
			result = (result * base) % modulus
		power = power >> 1
		base = (base * base) % modulus
	return result


def main():
	print(modular_exponential(24, 2015, 1000))

if __name__ == '__main__':
	main()
