import java.util.*;
import java.io.*;
public class PizzaCOCI{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt();
		Set<Integer> dislike = new HashSet<Integer>();
		for(int i = 0; i<N; i++)dislike.add(readInt());
		int M = readInt(), cnt = 0;
		for(int i = 0; i<M; i++) {
			String[] line = readLine().split(" ");
			line[0]="-1";
			out:{
			for(String s : line)if(dislike.contains(Integer.parseInt(s)))break out;
			cnt++;
			}
		}
		System.out.println(cnt);
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