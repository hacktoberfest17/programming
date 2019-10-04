import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	public static void main(String args[]) throws IOException {
		final int portNumber = 12408;
		System.out.println("Creating server socket on port " + portNumber);
		ServerSocket serverSocket = new ServerSocket(portNumber);
		
		boolean isServerStarted = true;
		while (isServerStarted) {
			Socket socket = serverSocket.accept();
			OutputStream os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(os, true);
			pw.println("What's you name?");

			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String clientMessage = br.readLine();

			if (clientMessage.equalsIgnoreCase("shut down")) {
				isServerStarted = false;
				pw.println(clientMessage );
			} else {
				pw.println("Hello, " + clientMessage );
			}
			pw.close();
			socket.close();

			System.out.println("Just said hello to:" + clientMessage );
		}
		serverSocket.close();
	}
}
