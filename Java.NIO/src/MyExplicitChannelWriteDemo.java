import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

class MyExplicitChannelWriteDemo {
	
public static void main(String[] args) {
	Path filePath = Paths.get("WriteDemo.txt");
	try {
		FileChannel fChan =	FileChannel.open(filePath, StandardOpenOption.WRITE, StandardOpenOption.CREATE);
		ByteBuffer buf = ByteBuffer.allocate(26);
		for (int i=0; i<26; ++i) buf.put((byte) ('A' + i));
		buf.rewind();
		fChan.write(buf);
		fChan.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}
}