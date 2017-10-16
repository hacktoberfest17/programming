def TowerOfHanoi(n, from_rod, to_rod, aux_rod):
	if n == 1:
		print(from_rod + ' --> ' + to_rod)
	else:
		TowerOfHanoi(top - 1, from_rod, aux_rod, to_rod)
		print(start + ' --> ' + end)
		TowerOfHanoi(top - 1, aux_rod, to_rod, from_rod)

def main():
	blocks = 5
	TowerOfHanoi(5, 'A', 'B', 'C')

if __name__ == '__main__':
	main()
