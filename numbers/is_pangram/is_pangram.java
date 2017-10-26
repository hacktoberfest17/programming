public class is_pangram {

	public static boolean isPangram(String str) {

		boolean[] pangram = new boolean[26];
		
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z')
				pangram[str.charAt(i) - 'A'] = true;
			if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z')
				pangram[str.charAt(i) - 'a'] = true;
		}

		for (int i = 0; i < 26; i++)
			if (!pangram[i])
				return false;
		return true;
	}

	public static void main(String[] args) {
		
		boolean pangram = isPangram("The quick brown fox jumps over the lazy dog");

		if (pangram)
			System.out.println("Given string is a pangram");
		else
			System.out.println("Given string is not a pangram");
	}
}
