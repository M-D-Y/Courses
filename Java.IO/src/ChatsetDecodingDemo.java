import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.SortedMap;

public class ChatsetDecodingDemo {
public static void main(String[] args) {
	SortedMap<String, Charset> charsetMap = Charset.availableCharsets();
	String s = "Это знак авторcкого права &cору;" + ", а &cору - нет.\n";
	Charset charset;
	for(String key : charsetMap.keySet()){
		charset = (Charset)(charsetMap.get(key));
		System.out.println("\nКодировка " + key + ". Текст:");
		byte[] byteString = null;
		try {
			byteString = s.getBytes(charset.toString());
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0; i<byteString.length; i++){
			System.out.print((char)byteString[i]);
		}
	}		
	
}
}
