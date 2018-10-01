package cc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class sgAndCrime {

	static HashMap<Integer, Boolean> roads;
	static ArticulationPair[] result;
	static HashMap<Integer, HashMap<Integer, Integer>> graph;
	static HashMap<Integer, Integer> vertices;

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();
		int m = scan.nextInt();
		int q = scan.nextInt();

		result = new ArticulationPair[n + 1];
		graph = new HashMap<Integer, HashMap<Integer, Integer>>();
		vertices = new HashMap<Integer, Integer>();
		roads = new HashMap<Integer, Boolean>();

		// initilize graph(districts)
		for (int i = 1; i <= n; ++i) {
			graph.put(i, new HashMap<Integer, Integer>());
		}

		int x, y, z;
		// number of roads
		for (int i = 0; i < m; ++i) {
			x = scan.nextInt();
			y = scan.nextInt();
			z = scan.nextInt();

			graph.get(x).put(y, z);
			graph.get(y).put(x, z);
		}

		// result
		for (int i = 0; i <= n; ++i) {
			result[i] = new ArticulationPair();
		}

		// bridge call
		for (int i = 1; i <= n; ++i) {
			if (result[i].isAp == true)
				continue;
			DFTBridge(0, i);
		}

		for (int i = 0; i < q; ++i) {
			int query= scan.nextInt();

			if (roads.containsKey(query)) {
				System.out.println("YES");

			} else {
				System.out.println("no");
			}
		}
		scan.close();
	}

	private static class ArticulationPair {
		int low;
		int disc;
		boolean isAp;
		int parent = -1;
		boolean processed;
	}

	private static void DFTBridge(int time, int currv) {
		if (result[currv].processed) {
			return;
		}

		result[currv].processed = true;
		result[currv].disc = result[currv].low = time;

		ArrayList<Integer> nbrs = new ArrayList<>(graph.get(currv).keySet());

		for (int nbr : nbrs) {
			// unprocessed neighbour
			if (result[nbr].processed == false) {
				result[nbr].parent = currv;
				DFTBridge(time + 1, nbr);
				result[currv].low = Math.min(result[currv].low, result[nbr].low);
				if (result[nbr].low > result[currv].disc) {
					roads.put(graph.get(currv).get(nbr), true);
					// System.out.println("bridge found!");
				}
			}

			// processed neighbour
			else if (result[currv].parent != nbr) {
				result[currv].low = Math.min(result[nbr].disc, result[currv].low);

			} else {
				// parent
				continue;
			}

		}

	}

}
