def gcd(a, b):
	if b == 0:
		return a
	else:
		return gcd(b, a % b)

def main():
	print(gcd(36, 6))

if __name__ == '__main__':
	main()
