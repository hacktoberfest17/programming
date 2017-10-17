import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Keyboard input functions. Doesn't validate user's input.
 * Adapted code from university assignments. 
 * @author  Professor Delamaro
 */
public class Input {
static InputStreamReader isr = new InputStreamReader(System.in);
static BufferedReader br = new BufferedReader(isr);
	
	/**
	 * Read a string typed by the user until \n
	 * @return string typed by the user
	 * @throws IOException
	 */
	public static String readString() throws IOException {
		String x;
		x = br.readLine();
		return x;
	}

	/**
	 * Read a string and convert it to int. Doesn't validate user's input.
	 * @return  value typed by the user
	 * @throws IOException
	 */
	public static int readInt() throws IOException {
		String x = readString();
		return Integer.parseInt(x);
	}

	/**
	 * Read a string and convert it to double. Doesn't validate user's input.
	 * @return  value typed by the user
	 * @throws IOException
	 */

	public static double readDouble() throws IOException {
		String x = readString();
		return Double.parseDouble(x);

	}
}