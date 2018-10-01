	package cc;
	
	import java.util.ArrayList;
	import java.util.HashMap;
	import java.util.Scanner;
	
	public class SubhamAndXOR {
	
		public static void main(String[] args) {
	
			Scanner scan = new Scanner(System.in);
			int n = scan.nextInt();
//			int[] arr = new int[n];
			int count = 0, temp;
		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < n; ++i) {
			temp = scan.nextInt();
			if (map.containsKey(temp)) {
				map.put(temp, map.get(temp) + 1);
			} else {
				map.put(temp, 1);
			}
		}

		ArrayList<Integer> list = new ArrayList<>(map.keySet());
		int y;
		for (int x : list) {
			y = map.get(x);
			if (y >= 2) {
				count += (y * (y - 1)) / 2;
			}
		}
	
//			for (int i = 0; i < n; ++i) {
//				arr[i] = scan.nextInt();
//			}
//	
//			for (int i = 1; i < n; ++i) {
//				for (int j = 0; j < i; ++j) {
//					if ((arr[i] ^ arr[j]) == 0) {
//						++count;
//					}
//				}
//			}
			System.out.println(count);
			scan.close();
		}
	
	}
