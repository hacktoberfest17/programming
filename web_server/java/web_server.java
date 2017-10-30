import java.net.ServerSocket;
import java.net.Socket;

public class web_server {
    public static void main(String args[]) throws Exception {
        final ServerSocket server = new ServerSocket(8080);
        System.out.println("Listening for connection on port 8080 ....");
        while (true) {
            try (Socket socket = server.accept()) {
                String response = "HTTP/1.1 200 OK\n\nHello World";
                socket.getOutputStream().write(response.getBytes("UTF-8"));
                socket.close();
            }
        }
    }
}
