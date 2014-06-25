package queryExtract;
import java.io.*;

public class queryExtract {
	public static void main(String[] args) throws IOException {
				
		BufferedReader br = new BufferedReader(new FileReader("gen/CARD_WebSearch.csv"));
		PrintStream q = new PrintStream("WebSearch.utf8");
				
		String line = "";
		int lineNum = 0;
		int lottery = 0;
		int count = 0;
		while ((line = br.readLine()) != null) {
		    String[] tokens = line.split(",");
		    if (lineNum != 0) {
		    	String query = tokens[8].replaceAll("\"", "");
		    	lottery ++;
		    	if ((lottery % 10000 == 0) && count <= 200) {
		    		q.println(query);
		    		count ++;
		    	}
		    }
		    lineNum ++;      
		}
		br.close();
		q.close();
	}
}