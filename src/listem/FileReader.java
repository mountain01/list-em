package listem;

abstract public class FilerReader {

	public void ReadFile(File directory, String pattern, boolean recursive){
		File[] files = directory.listFiles();

		for(File file: files){
			if(file.isDirectory() && recursive){
				ReadFile(file,pattern,recursive);
			}
			else if(file.isFile() && file.getName().matches(pattern)){
				Scanner in = new Scanner(file);
				stuf(file,in);
				in.close();
			}
		}
	}

	abstract void stuf(File file, Scanner in);
}