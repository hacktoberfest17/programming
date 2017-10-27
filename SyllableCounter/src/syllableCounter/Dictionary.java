package syllableCounter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;

import org.omg.CORBA.portable.InputStream;

public class Dictionary {

	public static void main (String[] args){
		long syllables = 0;
		long words = 0;
		System.out.println("Reading words from dictionary.txt");
		FileInputStream reader;
		try {
			reader = new FileInputStream(new File("dictionary.txt"));
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		}
		BufferedReader buffer = new BufferedReader(new InputStreamReader(reader));

		while(true){
			String word;
			try {
				word = buffer.readLine();
			} catch (IOException e) {
				throw new RuntimeException(e.getMessage());
			}

			if(word != null){
				SimpleSyllableCounter counter = new SimpleSyllableCounter();
				syllables += counter.countSyllables(word);

				words ++;
			}
			if(word == null)
				break;
		}

		System.out.println("Counted " + syllables + " syllables in " + words + "words");

	}

}
