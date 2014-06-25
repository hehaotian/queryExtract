import java.io.*;
import java.util.*;

public class queryMerge {
	public static void main(String[] args) throws IOException {

    	String root = "q/";
    	File folder = new File(root);
    	File[] listOfFiles = folder.listFiles();
    	List<String> queryList = new ArrayList<String>();
        PrintStream ps = new PrintStream("q.test.utf8");
        int count = 0;

    	for (File file : listOfFiles) {
    		if (file.isFile()) {
    			String fileName = file.getName();
    			if (fileName.contains(".utf8")) {
    				BufferedReader br = new BufferedReader(new FileReader(root + fileName));
    				String line = "";
    				while ((line = br.readLine()) != null) {
                        if (!queryList.contains(line)) {
                            count ++;
                            queryList.add(line);
                            line = line.replaceAll("[\\s]+", "");
                            ps.println(line + "。");
                        }
    				}
    				br.close();
    			}
    		}
    	}
    }
}