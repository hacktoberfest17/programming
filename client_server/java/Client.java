import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

	public static void main(String args[]) throws IOException {
		final String host = "localhost";
		final int portNumber = 12408;
		System.out.println("Creating socket to '" + host + "' on port " + portNumber);

		boolean isClientStarted = true;
		while (isClientStarted) {
			Socket socket = new Socket(host, portNumber);
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

			System.out.println("server says:" + br.readLine());
			BufferedReader userInputBR = new BufferedReader(new InputStreamReader(System.in));
			String userInput = userInputBR.readLine();

			if (userInput.endsWith("end")) {
				userInput = "shut down";
			}
			out.println(userInput);
			String serverMessage = br.readLine();
			
			if (serverMessage.equalsIgnoreCase("shut down")) {
				isClientStarted = false;
			}
			
			System.out.println("server says:" + serverMessage);

			if ("exit".equalsIgnoreCase(userInput)) {
				socket.close();
				break;
			}
		}
	}
}