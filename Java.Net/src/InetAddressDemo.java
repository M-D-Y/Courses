
//Продемонстрировать применение класса InetAddress
import java.net.*;

class InetAddressDemo {
	public static void main(String args[]) throws UnknownHostException {
		InetAddress address = InetAddress.getLocalHost();
		System.out.println(address);
		address = InetAddress.getByName("www.HerbSchildt.com");
		System.out.println(address);
		InetAddress sw[] = InetAddress.getAllByName("www.nba.com");
		for (int i = 0; i < sw.length; i++)
			System.out.println(sw[i]);
	}
}