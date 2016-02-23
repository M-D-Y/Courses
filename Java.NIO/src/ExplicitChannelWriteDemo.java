import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

//Записать данные в файл средствами системы в вода-вывода NIO.
//Требуется установка комплекта JDK, начиная с версии 7

public class ExplicitChannelWriteDemo {

	public static void main(String[] strs) {
		//получить канал к файлу в блоке оператора try с ресурсами
		try (FileChannel fChan = (FileChannel) Files.newByteChannel(Paths.get("ChannelWriteDemo"), StandardOpenOption.WRITE, StandardOpenOption.CREATE)){
			//создать буфер
			ByteBuffer mBuf = ByteBuffer.allocate(28);
			//Выводим английский алфавит 3 раза
			for(int h=0; h<3; ++h){
				//Выводим английский алфавит
				for(int i = 0; i < 26; i++) mBuf.put((byte) ('A' + i));
				mBuf.put("\n".getBytes());
				//подготовить буфер к записи данных
				mBuf.rewind();
				//записать данные из буфера в выходной файл
				fChan.write(mBuf);
				//подготовить буфер к записи данных
				mBuf.rewind();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InvalidPathException e) {
			e.printStackTrace();
		}
	}
}
