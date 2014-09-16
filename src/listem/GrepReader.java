package listem;


import java.io.File;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GrepReader extends FileReader implements Grep {

	private Map<File,List<String>> result;
	private String searchPattern;
	@Override
	public Map<File, List<String>> grep(File directory, String fileSelectionPattern,
			String substringSelectionPattern, boolean recursive){
		searchPattern = substringSelectionPattern;
		result = new HashMap<File,List<String>>();
		readFile(directory,fileSelectionPattern,recursive);
		return result;
	};

	void stuf(File file, Scanner in){
        List<String> matches = new ArrayList<String>();
        Pattern p = Pattern.compile(searchPattern);
        while(in.hasNextLine()){
            String input = in.nextLine();
            Matcher m = p.matcher(input);
			if(m.find()){
				matches.add(input);
			}
		}

		result.put(file,matches);
	};
}