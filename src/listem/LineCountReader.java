package listem;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LineCountReader extends FileReader implements LineCounter{
	Map<File, Integer> result;

	public Map<File, Integer> countLines(File directory, String fileSelectionPattern,
			boolean recursive){
		result = new HashMap<File,Integer>();
		readFile(directory,fileSelectionPattern,recursive);
		return result;
	}

	void stuf(File file, Scanner in){
		int lineCount = 0;
		while(in.hasNextLine()){
            in.nextLine();
			lineCount++;
		}
		result.put(file,lineCount);
	}
}
