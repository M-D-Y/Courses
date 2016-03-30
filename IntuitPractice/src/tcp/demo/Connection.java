package tcp.demo;

import java.io.*;
import java.net.*;

class Connection extends Thread {
	DataInputStream in;
	DataOutputStream out;
	Socket clientSocket;
	TCPServer server;

	public Connection(Socket aClientSocket, TCPServer server) {
		try {
			clientSocket = aClientSocket;
			this.server = server;
			in = new DataInputStream(clientSocket.getInputStream());
			out = new DataOutputStream(clientSocket.getOutputStream());
			this.start();
		} catch (IOException e) {
			System.out.println("Server connection: " + e.getMessage());
		}
	}

	public void run() { // an echo server
		try {
			String data = in.readUTF(); // read a line of data from the stream
			
			out.writeUTF("Request " +  ++server.msgCount + ". The message is: " + data); // write a line to the stream
			clientSocket.close();
		} catch (EOFException e) {
			System.out.println("Server EOF: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Server readline: " + e.getMessage());
		}
	}
}
