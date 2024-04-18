import java.util.*;
import java.io.*;
public class MediaList{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), Q = readInt();
		Set<String>[] media = new HashSet[N+1];
		for(int i = 0; i<=N; i++)media[i]=new HashSet<String>();
		for(int i = 0; i<Q; i++) {
			if(readInt()==1)System.out.println(media[readInt()].contains(next())?"1":"0");
			else media[readInt()].add(next());
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