
//Продемонстрировать обработку дейтаграмм
import java.net.*;

class DatagramSocketDemo {
	final static int BUFFER_SIZE = 1024;

	public static int serverPort = 998;
	public static int clientPort = 999;
	public static int buffersize = 1024;
	public static DatagramSocket ds;
	public static byte buffer[] = new byte[BUFFER_SIZE];

	public static void TheServer() throws Exception {
		int pos = 0;
		while (true) {
			int с = System.in.read();
			switch (с) {
			case -1:
				System.out.println("Cepвep завершает сеанс связи.");
				ds.close();
				return;
			case '\r':
				break;
			case '\n':
				ds.send(new DatagramPacket(buffer, pos, InetAddress.getLocalHost(), clientPort));
				pos = 0;
				break;
			default:
				buffer[pos++] = (byte) с;
			}
			;
		}
	}

	public static void TheClient() throws Exception {
		while (true) {
			DatagramPacket p = new DatagramPacket(buffer, buffer.length);
			ds.receive(p);
			System.out.println(new String(p.getData(), 0, p.getLength()));
		}
	}

	public static void main(String args[]) throws Exception {
		if (args.length == 1) {
			ds = new DatagramSocket(serverPort);
			TheServer();
		} else {
			ds = new DatagramSocket(clientPort);
			TheClient();
		}
	}
}