import java.util.*;
import java.io.*;
public class Visits{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt();
		int backing[] = new int[N+1], connection[][] = new int[N+1][2];
		for(int i = 1; i<=N; i++) {
			int in = readInt();
			backing[in]++;
			connection[i][0]=in;
			connection[i][1]=readInt();
		}
		boolean[] went = new boolean[N+1];
		long moo = 0;
		for(int i = 1; i<=N; i++) {
			if(backing[i]==0&&!went[i]) {
				int cur = i;
				while(backing[cur]==0) {
					moo+=connection[cur][1];
					went[cur]=true;
					cur=connection[cur][0];
					backing[cur]--;
				}
			}
		}
		for(int i = 1; i<=N; i++) {
			if(!went[i]) {
				long total = 0, min = Long.MAX_VALUE;
				int cur = i;
				while(!went[cur]) {
					total+=connection[cur][1];
					min=Math.min(connection[cur][1], min);
					went[cur]=true;
					cur=connection[cur][0];
					backing[cur]--;
				}
				moo+=total-min;
			}
		}
		System.out.println(moo);
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