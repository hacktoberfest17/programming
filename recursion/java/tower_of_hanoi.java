public class tower_of_hanoi {
	public static void TowerOfHanoi(int n, char from_rod, char to_rod, char aux_rod) {
		if (n == 1) 
			System.out.println(from_rod + " --> " + to_rod);
		else {
			TowerOfHanoi(n- 1, from_rod, aux_rod, to_rod);
			System.out.println(from_rod + " --> " + to_rod);
			TowerOfHanoi(n - 1, aux_rod, to_rod, from_rod);
		}
	}

	public static void main(String[] args) {
		int blocks = 5;							// Number of blocks in the tower 
		TowerOfHanoi(blocks, 'A', 'C', 'B');	// Moving all blocks from A to C
	}
}
