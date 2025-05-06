import java.util.*;
import java.io.*;
public class CourseRequirements{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static boolean[] took;
	static List<Integer>[] preq;
	public static void r(int course) {
		if(took[course])return;
		for(int c : preq[course])r(c);
		System.out.print(course+" ");
		took[course]=true;
	}
	public static void main(String[] args) throws IOException{
		int N = readInt();
		took = new boolean[N+1];
		preq = new ArrayList[N+1];
		for(int i = 1; i<=N; i++)preq[i]=new ArrayList<Integer>();
		for(int i = 1; i<=N; i++) {
			int size = readInt();
			for(int j = 0; j<size; j++)preq[i].add(readInt());
		}
		for(int i = 1; i<=N; i++)r(i);
		System.out.println();
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