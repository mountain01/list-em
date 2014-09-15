package listem;


public class GrepReader extends FileReader implements Grep {

	private Map<File,List<String>> result;
	private String searchPattern;
	@Override
	public Map<File, List<String>> grep(File directory, String fileSelectionPattern, 
			String substringSelectionPattern, boolean recursive){
		searchPattern = substringSelectionPattern;
		result = new HasMap<File,List<String>>();
		readFile(directory,fileSelectionPattern,recursive);
		return result;
	};

	void stuf(File file, Scanner in){
		while(in.hasNextLine()){
			String input = in.nextLine();
			List<String> matches = new ArrayList<String>;
			if(input.matches("*"+searchPattern+"*")){
				matches.add(input);
			}
		}

		result.put(file,matches);
	};
}