import java.util.*;
import java.io.*;
public class LightsGoingOnandOff{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static int BiToTen(int[] bits) {
		int expo = 1, n = 0;
		for(int i = bits.length-1; i>=0; i--) {
			if(bits[i]==1)n+=expo;
			expo*=2;
		}
		return n;
	}
	public static void main(String[] args) throws IOException{
		int N = readInt(), M = readInt(), lights[] = new int[N];
		for(int i = 0; i<N; i++) {
			int[] bits = new int[M];
			for(int j = 0; j<M; j++)bits[j]=readInt();
			lights[i]=BiToTen(bits);
		}
		Set<Integer> cur =  new HashSet<Integer>();
		cur.add(lights[0]);
		for(int i = 1; i<N; i++) {
			Set<Integer> next = new HashSet<Integer>();
			for(int j : cur)next.add(j^lights[i]);
			next.add(lights[i]);
			cur=new HashSet<Integer>(next);
		}
		System.out.println(cur.size());
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