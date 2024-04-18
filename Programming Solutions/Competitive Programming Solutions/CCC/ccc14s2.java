import java.util.*;
import java.io.*;
public class AssigningPartners{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt();
		String[] names = new String[N];
		for(int i = 0; i<N; i++)names[i]=next();
		Map<String,String> pairing = new HashMap<String,String>();
		for(int i = 0; i<N; i++) {
			String s = next();
			if((pairing.get(names[i])!=null&&!pairing.get(names[i]).equals(s))||(pairing.get(s)!=null&&!pairing.get(s).equals(names[i]))||names[i].equals(s)) {
				System.out.println("bad");
				return;
			}
			pairing.put(names[i],s);
			pairing.put(s,names[i]);
		}
		System.out.println("good");
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