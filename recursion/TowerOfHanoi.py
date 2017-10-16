def TowerOfHanoi(top, start, via, end):
	if top == 1:
		print(start + ' --> ' + end)
	else:
		TowerOfHanoi(top - 1, start, end, via)
		print(start + ' --> ' + end)
		TowerOfHanoi(top - 1, via, start, end)

def main():
	blocks = 5
	TowerOfHanoi(5, 'A', 'B', 'C')

if __name__ == '__main__':
	main()
