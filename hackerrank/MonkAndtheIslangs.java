package cc;

import java.util.HashMap;

public class MonkAndtheIslangs {
	static HashMap<String, Boolean> processed = new HashMap<>();

	public static void bfs(String start, String end) {
		if (start.equals(end)) {
			return;
		}
		if (processed.containsKey(start)) {
			return;
		}
		

	}

	public static void main(String[] args) {

	}

}
