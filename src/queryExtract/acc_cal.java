import java.io.*;
import java.util.*;

public class acc_cal {

    public static void main(String[] args) throws IOException {
		BufferedReader gold = new BufferedReader(new FileReader(args[1]));
		BufferedReader test = new BufferedReader(new FileReader(args[0]));
		Map<Integer, String[]> goldTokens = new HashMap<Integer, String[]>();

		int totalToks = 0;
		int match = 0;

		String goldLine = "";
		int lineNum = 0;
		while ((goldLine = gold.readLine()) != null) {
			String[] tokens = goldLine.split(" ");
			totalToks += tokens.length;
			goldTokens.put(lineNum, tokens);
			lineNum ++;
		}

		lineNum = 0;
		String testLine = "";
		while ((testLine = test.readLine()) != null) {
			String[] testTokens = testLine.split(" ");
			List<String> thisLineGoldTokens = Arrays.asList(goldTokens.get(lineNum));
			for (int i = 0; i < testTokens.length; i++) {
				if (thisLineGoldTokens.contains(testTokens[i])) {
					match ++;
				}
			}
			lineNum ++;
		}
		double accuracy = match * 1.0 / totalToks;
		System.out.println("Accuracy: " + match + "/" + totalToks + " = " + accuracy);
	}
}