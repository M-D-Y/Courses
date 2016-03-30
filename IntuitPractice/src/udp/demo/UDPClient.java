package udp.demo;

import java.net.*;
import java.io.*;

public class UDPClient {
	public static void main(String args[]) {
		// args give message contents and destination hostname
		String hostname = (args.length > 0 && !args[0].isEmpty()) ? args[0] : "localhost";
		String msg = (args.length > 1 && !args[1].isEmpty()) ? args[1] : "My UDP message...";
		try {
			DatagramSocket aSocket = new DatagramSocket(); // create socket
			byte[] message = msg.getBytes();
			InetAddress aHost = InetAddress.getByName(hostname); // DNS lookup
			int serverPort = 6789;
			DatagramPacket request = new DatagramPacket(message, msg.length(), aHost, serverPort);
			aSocket.send(request); // send message
			byte[] buffer = new byte[1000];
			DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
			aSocket.receive(reply); // wait for reply
			System.out.println("Reply: " + new String(reply.getData()));
			aSocket.close();
		} catch (SocketException e) {
			System.out.println("Socket: " + e.getMessage());
			// socket creation failed
		} catch (IOException e) {
			System.out.println("IO: " + e.getMessage());
			// can be caused by send
		}
	}
}
