public class is_anagram {

	public static boolean isAnagram(String str1, String str2) {

		if (str1.length() != str2.length())
			return false;

		int[] count1 = new int[256];
		int[] count2 = new int[256];

		for (int i = 0; i < str1.length(); i++) {
			++count1[str1.charAt(i)];
			++count2[str2.charAt(i)];
		}

		for (int i = 0; i < 256; i++)
			if (count1[i] != count2[i])
				return false;

		return true;
	}

	public static void main(String[] args) {
		
		boolean anagram = isAnagram("LISTEN", "SILENT");

		if (anagram)
			System.out.println("The strings are Anagram of each other");
		else
			System.out.println("The strings are not Anagram of each other");
	}
}
