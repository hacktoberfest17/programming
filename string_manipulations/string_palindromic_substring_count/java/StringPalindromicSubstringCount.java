import java.util.*;

public class StringPalindromicSubstringCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter String");
		String str = scn.next();
		System.out.println(countPalindromes(str));
	}

	public static int countPalindromes(String str){
		// odd length palindromes
		int axis = 0;
		int orbit = 0;
		int count = 0;

		while(axis < str.length()){
			if(axis - orbit >= 0 && axis + orbit < str.length() && str.charAt(axis+orbit) == str.charAt(axis-orbit)){
				orbit += 1;
				count += 1;
			} else {
				axis += 1;
				orbit = 0;
			}
		}

		// even length palindromes
		axis = 0;
		orbit = 1;

		while(axis < str.length()){
			if(axis - orbit >= 0 && axis + orbit - 1 < str.length() && str.charAt(axis+orbit -1) == str.charAt(axis-orbit)){
				orbit += 1;
				count += 1;
			} else {
				axis += 1;
				orbit = 1;
			}
		}

		return count;
	}

}
