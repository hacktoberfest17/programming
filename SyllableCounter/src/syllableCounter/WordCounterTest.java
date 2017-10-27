package syllableCounter;
import java.net.URL;
import java.util.*;
import java.io.*;

/**
 * Some words with known syllable count,
 * to check your countSyllables method.
 * It reads words from a file containing a string
 * and syllable count (one per line).  Lines beginning
 * with '#' and blank lines are ignored.
 */
public class WordCounterTest {
	
	/** 
	 * Read lines from a file containing "word syllable_count"
	 * and add them to map of words.
	 * @param in InputStream to read from
	 */
	private static Map<String,Integer> loadWords(InputStream in) throws IOException {
		Map<String,Integer> words = new HashMap<String,Integer>();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		String inline = null;
		int linecount = 0;
		while ( (inline=reader.readLine()) != null) {
			linecount++;
			inline = inline.trim();
			if (inline.startsWith("#")) continue; // skip lines starting with #
			if ( inline.isEmpty() ) continue;
			String[] args = inline.split("\\s+");
			if (args.length != 2) {
				System.out.printf("Invalid line %d: %s\n", linecount, inline);
				continue;
			}
			try {
				int count = Integer.parseInt(args[1]);
				words.put(args[0], count);
			} catch(NumberFormatException nfe) {
				System.out.printf("Invalid line %d: %s\n", linecount, inline);
			}
		}
		try { reader.close(); } catch(IOException ioe) { /* ignore */ }
		
		return words;
	}
	
	private static InputStream getInputStream(String urlname) throws IOException {
		if ( urlname.matches("\\w+:/.*") ) {
			// open it as a URL0
			URL url = new URL(urlname);
			return url.openStream();
		} 
		else {
			// treat it as a classpath resource
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			return loader.getResourceAsStream(urlname);
		}
	}
	
	
	/**
	 * Test the syllable counter using words from a file.
	 * @param args not used
	 * @throws IOException if file cannot be read
	 */
	public static void main(String[] args) {
		Map<String,Integer> words = null;
		try {
			InputStream in = getInputStream( URLNAME );
			if (in == null) throw new IOException("Resource does not exist: "+URLNAME);
			words = loadWords( in );
		} catch (Exception e) {
			System.out.println("Exception reading wordlist file "+URLNAME);
			System.out.println( e.getMessage() );
			System.exit(1);
		}
		
		SimpleSyllableCounter counter = new SimpleSyllableCounter();
		int correct = 0;
		int incorrect = 0;
		for( String word : words.keySet() ) {
			System.out.printf("%-24s",word);
			int expect = words.get(word);
			int actual = counter.countSyllables(word);
			System.out.print(actual);
			if (expect == actual) {
				correct++;
				System.out.println(" Correct");
			}
			else {
				incorrect++;
				System.out.printf(" Incorrect: should be %d\n", expect);
			}
		}
		System.out.printf("Correct: %d  Incorrect: %d\n", correct, incorrect);
	}
	
	// URL of the file containing sample words.
	// The test will be faster if you download the file and change this
	// to a local URL ("file:/path/testwords.txt") 
	// or file on this project's classpath ("testwords.txt").
//	static final String URLNAME = "testwords.txt";
	static final String URLNAME = "http://se.cpe.ku.ac.th/testwords.txt";
		
}
