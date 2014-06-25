import java.io.*;
import java.util.*;

public class clean {

    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(args[0]));
		PrintStream ps = new PrintStream(args[1]);

		String line = "";
		while ((line = br.readLine()) != null) {
			line = line.replaceAll("/[a-z]+[0-9]*", "");
			ps.println(line);
		}
	}
}