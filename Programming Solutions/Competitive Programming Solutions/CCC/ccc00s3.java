import java.util.*;
import java.util.regex.*;
import java.io.*;
public class Surfing {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt();
		Map<String,List<String>> connections = new HashMap<String,List<String>>();
		for(int i = 0; i<N; i++) {
			String link = readLine();
			connections.put(link, new ArrayList<String>());
			String line = readLine();
			while(!line.equals("</HTML>")) {
				Matcher m = Pattern.compile("<A HREF=\"(.*?)\">").matcher(line);
				while(m.find()) {
					connections.get(link).add(m.group().substring(9,m.group().length()-2));
					System.out.println("Link from "+link+" to "+m.group().substring(9,m.group().length()-2));
				}
				line = readLine();
			}
		}
		String a = readLine();
		while(!a.equals("The End")) {
			String b = readLine();
			List<String> valid = new ArrayList<String>();
			Set<String> con = new HashSet<String>();
			con.add(a);
			out:{
			while(!con.isEmpty()) {
				List<String> current = new ArrayList<String>(con);
				con.clear();
				for(String s : current) {
					if(!valid.contains(s)) {
						if(s.equals(b)) {
							System.out.println("Can surf from "+a+" to "+b+".");
							break out;
						}
						if(connections.get(s)==null) continue;
						valid.add(s);
						for(String str : connections.get(s)) {
							con.add(str);
						}
					}
				}
			}
			System.out.println("Can't surf from "+a+" to "+b+".");
			}
			a = readLine();
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