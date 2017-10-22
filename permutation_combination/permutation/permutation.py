def npr(n, r):

	if r > n or n < 0 or r < 0:
		return -1
	ans = 1
	for i in range(n, n - r, -1):
		ans *= i
	return ans

def main():
	permutation = npr(15, 5)
	if permutation > 0:
		print(permutation)
	else:
		print('Invalid Input')

if __name__ == '__main__':
	main()
