package tcp.demo;

import java.net.*;

import java.io.*;

public class TCPClient {
	public static void main(String args[]) {
		// arguments supply message and hostname
		String hostname = (args.length > 0 && !args[0].isEmpty()) ? args[0] : "localhost";
		String msg = (args.length > 1 && !args[1].isEmpty()) ? args[1] : "Test connection to server....";

		Socket s = null;
		try {
			int serverPort = 7896;
			s = new Socket(hostname, serverPort);
			DataInputStream in = new DataInputStream(s.getInputStream());
			DataOutputStream out = new DataOutputStream(s.getOutputStream());
			out.writeUTF(msg); // UTF is a string encoding
			String data = in.readUTF(); // read a line of data from the stream
			System.out.println("Client received: " + data);
			data = in.readUTF(); // read a line of data from the stream
			System.out.println("Client received: " + data);
		} catch (UnknownHostException e) {
			System.out.println("Client socket: " + e.getMessage());
			// host cannot be resolved
		} catch (EOFException e) {
			System.out.println("Client EOF: " + e.getMessage());
			// end of stream reached
		} catch (IOException e) {
			System.out.println("Client readline: " + e.getMessage());
			// error in reading the stream
		} finally {
			if (s != null)
				try {
					s.close();
				} catch (IOException e) {
					System.out.println("close:" + e.getMessage());
				}
		}
	}
}
