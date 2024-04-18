import java.util.*;
import java.io.*;
public class Email{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		for(int i = 0; i<10; i++) {
			List<String> addresses = new ArrayList<String>();
			int N = readInt();
			for(int j = 0; j<N; j++) {
				String s = readLine(), filter = "";
				boolean at = false;
				for(int k = 0; k<s.length(); k++) {
					if(s.charAt(k) == '.' && !at) {
						continue;
					}
					else if(s.charAt(k) == '+') {
						while(s.charAt(k) != '@') {
							k++;
						}
						filter+=s.charAt(k);
						at = true;
					}
					else if(s.charAt(k) == '@') {
						filter+=s.charAt(k);
						at = true;
					}
					else {
						filter+=s.charAt(k);
					}
				}
				addresses.add(filter.toLowerCase());
			}
			Set<String> removedupe = new HashSet<String>(addresses);
			List<String> result  = new ArrayList<String>(removedupe);
			//System.out.println(result);
			System.out.println(result.size());
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