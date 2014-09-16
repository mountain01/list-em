package listem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

abstract public class FileReader {

	public void readFile(File directory, String pattern, boolean recursive){
		File[] files = directory.listFiles();

		if(files != null){
            for(File file: files){
                if(file.isDirectory() && recursive){
                    readFile(file,pattern,recursive);
                }
                else if(file.isFile() && file.getName().matches(pattern)){
                    Scanner in = null;
                    try {
                        in = new Scanner(file);
                        stuf(file,in);
                        in.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
	}

	abstract void stuf(File file, Scanner in);
}