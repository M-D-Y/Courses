package tcp.demo;

import java.io.IOException;
import java.net.*;

public class TCPServerDemo {
	public static void main(String args[]) {
		TCPServer s = new TCPServer();
	}
}

class TCPServer {
	volatile int msgCount = -1;
	public TCPServer() {
		try {
			int serverPort = 7896; // the server port
			ServerSocket listenSocket = new ServerSocket(serverPort);
			// new server port generated
			while (true) {
				Socket clientSocket = listenSocket.accept();
				// listen for new connection
				Connection c = new Connection(clientSocket, this);
				// launch new thread
			}
		} catch (IOException e) {
			System.out.println("Server listen socket: " + e.getMessage());
		}
	}

}