public class tower_of_hanoi {
	public static void TowerOfHanoi(int top, char start, char via, char end) {
		if (top == 1) 
			System.out.println(start + " --> " + end);
		else {
			TowerOfHanoi(top - 1, start, end, via);
			System.out.println(start + " --> " + end);
			TowerOfHanoi(top - 1, via, start, end);
		}
	}

	public static void main(String[] args) {
		int blocks = 5;							// Number of blocks in the tower 
		TowerOfHanoi(blocks, 'A', 'B', 'C');	// Moving all blocks from A to C
	}
}
