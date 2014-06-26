package queryExtract;
import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class queryText {
	public static void main(String[] args) throws IOException {
		
		List<String> agentList = new ArrayList<String>();
		agentList.add("Alarm");
		agentList.add("Calendar");
		agentList.add("Clock");
		agentList.add("Contacts");
		agentList.add("HFD");
		agentList.add("Launch Apps");
		agentList.add("Memo");
		agentList.add("Music");
		agentList.add("Navigation");
		agentList.add("News");
		agentList.add("POI");
		agentList.add("Settings");
		agentList.add("System");
		agentList.add("Weather");
		agentList.add("WebSearch");
		
		for (int idx = 0; idx <= agentList.size(); idx ++) {
			String agentName = agentList.get(idx);
			String path = "";
			if (agentName.equals("Launch Apps")) {
				path = "CARDs/" + agentName + "/zh-CN/CARD_Expanded_Commands-zh-CN-Launch_Apps-zh-CN.csv";
			} else {
				path = "CARDs/" + agentName + "/zh-CN/CARD_Expanded_Commands-zh-CN-" + agentName + "-zh-CN.csv";
			}
			BufferedReader br = new BufferedReader(new FileReader(path));
			PrintStream q = new PrintStream("q/" + agentName + "-zh-CN.txt");
			
			List<String> queries = new ArrayList<String>();
			String line = "";
			int lineNum = 0;
			while ((line = br.readLine()) != null) {
			    String[] tokens = line.split(",");
			    String query = tokens[8].replaceAll("\"", "");
			    query = query.replaceAll("[\\s]+", "");
			    queries.add(query);
			    lineNum ++;
			    if (lineNum > 400000) {
			    	break;
			    }
			}
			br.close();
			
			System.out.println(agentName + " " + lineNum);
			if (lineNum > 4000) {
				int lotter = lineNum / 2000;
				for (int i = 0; i < queries.size(); i += lotter) {
					q.println(queries.get(i));
				}
			} else {
				if (queries.size() <= 2000) {
					for (int i = 0; i < queries.size(); i ++) {
						q.println(queries.get(i));
					}
				} else {
					for (int i = 0; i < 2001; i ++) {
						q.println(queries.get(i));
					}
				}
			}
			q.close();
			System.out.println(agentName + " finished!");
		}
	}
}