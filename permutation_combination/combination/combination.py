def ncr(n, r):

	if r > n or n < 0 or r < 0:
		return -1

	if r > n // 2:
		r = n - r
	ans = 1
	for i in range(1, r + 1):
		ans *= n - r + i
		ans //= i
	return ans

def main():

	combination = ncr(15, 5)
	if combination > 0:
		print(combination)
	else:
		print('Invalid Input')

if __name__ == '__main__':
	main()
