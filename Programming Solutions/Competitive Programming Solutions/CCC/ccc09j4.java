import java.util.*;
import java.io.*;
public class Signage {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		StringTokenizer sentence = new StringTokenizer("WELCOME TO CCC GOOD LUCK TODAY"," ");
		Stack<String> words = new Stack<String>();
		while(sentence.hasMoreTokens()) words.add(sentence.nextToken());
		int w = readInt();
		Collections.reverse(words);
		while(!words.isEmpty()) {
			String line = "";
			int cnt = 0;
			line+=words.pop();
			while(!words.isEmpty()&&line.length()+1+words.peek().length()<=w) {
				line+="."+words.pop();
				cnt++;
			}
			int add = w-line.length();
			int individual = 0;
			if(cnt > 0)individual = add%cnt;
			String out = "";
			for(int j = 0; j<line.length(); j++) {
				out+=line.charAt(j);
				if(line.charAt(j)=='.') {
					for(int i = 0; i<add/cnt; i++)out+=".";
					if(individual>0) {
						individual--;
						out+=".";
					}
				}
			}
			while(out.length()<w)out+=".";
			System.out.println(out);
		}
	}
	static String next () throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}
	static long readLong () throws IOException {
		return Long.parseLong(next());
	}
	static int readInt () throws IOException {
		return Integer.parseInt(next());
	}
	static double readDouble () throws IOException {
		return Double.parseDouble(next());
	}
	static char readCharacter () throws IOException {
		return next().charAt(0);
	}
	static String readLine () throws IOException {
		return br.readLine().trim();
	}
}