def squareRoot(num):
	x = num
	y = 1
	e = 0.00000001

	while x - y > e:
		x = (x + y) / 2
		y = num / x
	return x

def main():
	print(squareRoot(6))

if __name__ == '__main__':
	main()
