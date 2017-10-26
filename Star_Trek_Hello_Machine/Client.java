/*
 * A simple Star Trek themed Hello World app
 * 
 * @author Lee Gainer, winterfive
 * @since October 2017
 * 
 */

import java.util.Scanner;

public class Client {
	
	public static void main(String []args) {
		
		System.out.println("Welcome to the Star Trek Hello World Machine!\n\n"
				+ "Please type in the language you would like to use to output\n"
				+ "'hello world'.  This translator features only a select few of\n"
				+ "the thousands of languages used found in the Star Trek universe.\n"
				+ "To quit, just type 'Q'");		
		
		String l;
		
		do {
			l = getLanguage();			
			
			Translation helloWorld = new Translation(l);
			
			Translation.getTranslation(helloWorld.selectedLang);
			
		} while(!l.equals("q") || l.equals("Q"));
	}

	/*
	 *  Scanner gets user input and validates it
	 *  Changes all chars to upper case
	 *  Returns String, selectedLang
	 *  String -> String
	 */
	private static String getLanguage() {
		
		// Scanner for operation input
		Scanner l = new Scanner(System.in);
		System.out.println("\nPlease enter one of the following languages: ");
		
		// Lists values from enum, languages
		for(languages lang : languages.values()) {
			System.out.println(lang);
		}
		
		// Change all chars in l to upper case		
		String selectedLang = (l.nextLine()).toUpperCase();
		
		// Check input for Q (quit)
		if(selectedLang.equals("Q")) {
			// getLanguage returns a String so a new method was needed here
			soLong();
		}
		
		// Check if input is in enum, languages		
		while(!contains(selectedLang)) {
			System.out.println("\nThat is not a valid input.\nSelect from the list above.");
			Scanner l2 = new Scanner(System.in);
			selectedLang = (l2.nextLine()).toUpperCase();
		}
		
		return selectedLang;
	}
	
	/*
	 *  Ends program when user inputs Q or q.
	 *  null -> void
	 */
	private static void soLong() {
		System.out.println("\nThanks for using the Hello World Machine.");
		System.exit(0);
	}

	/*
	 *  Checks String parameter for inclusion in enum languages
	 *  Returns Boolean
	 *  String -> Boolean
	 */
	public static boolean contains(String test) {
		
		for (languages l : languages.values()) {
	        if (l.name().equals(test)) {
	            return true;
	        }
	    }
      
	    return false;
	}
}
