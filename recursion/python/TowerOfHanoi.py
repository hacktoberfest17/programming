#!/usr/local/bin/python
A = [5,4,3,2,1]
B = [] * 5
C = [] * 5

def TowerOfHanoi(n, from_rod, to_rod, aux_rod):
	if n > 0:
		# move n - 1 disks from source to auxiliary, so they are out of the way
		TowerOfHanoi(n - 1, from_rod, aux_rod, to_rod)
		# move the nth disk from source to target
		to_rod.append(from_rod.pop())
		# Display our progress
		print(A, ' -- ', B, ' -- ', C)
		# move the n - 1 disks that we left on auxiliary onto target
		TowerOfHanoi(n - 1, aux_rod, to_rod, from_rod)

def main():
	print(A, ' -- ', B, ' -- ', C)
	TowerOfHanoi(5, A, B, C)

if __name__ == '__main__':
	main()
