import java.io.File;
import java.io.IOException;

public class FileOperationsDemo {

	public static void main(String[] args) throws IOException {
		String filePath = "bin/Parent/Child";
		File fl = new File(filePath);
		fl.mkdirs();
		String newFileName;
		newFileName = filePath + "/test.txt";
		File newFile = new File(newFileName);
		File fileToDelete = new File(filePath + "/delete.txt"); 
		if (!newFile.exists()) {
			newFile.createNewFile();
			if (fileToDelete.exists()) fileToDelete.delete();
			newFile.renameTo(fileToDelete);
			
		}
	}
}