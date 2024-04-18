import java.util.*;
import java.io.*;
public class SawmillScheme{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), M = readInt();
		double chances[] = new double[N+1];
		List<Integer>[] flow = new ArrayList[N+1];
		for(int i = 1; i<=N; i++)flow[i]=new ArrayList<Integer>();
		for(int i = 0; i<M; i++)flow[readInt()].add(readInt());
		chances[1]=1;
		for(int n = 1; n<=N; n++) {
			for(int i : flow[n])chances[i]+=chances[n]/(double)(flow[n].size());
		}
		for(int i = 1; i<=N; i++)if(flow[i].isEmpty())System.out.println(chances[i]);
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