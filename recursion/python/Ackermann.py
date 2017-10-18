def Ackermann(m, n):
	stack = [m]
	while len(stack) != 0:
		m = stack.pop()
		if m == 0:
			n = n + 1
		elif n == 0:
			stack.append(m - 1)
			n = 1
		else:
			stack.append(m - 1)
			stack.append(m)
			n -= 1
	return n

def main():
	print(Ackermann(3, 4))

if __name__ == '__main__':
	main()
