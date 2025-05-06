import java.util.*;
import java.io.*;
public class WorldOfStarCraft {
	public static int findrep(int[][] rep,int n) {
		while(rep[n][0]!=n)n=rep[n][0];
		return n;
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), M = readInt(), K = readInt();
		String r = readLine();
		int[][] rep = new int[N+1][2];
		for(int i = 0; i<=N; i++) {
			rep[i][0]=i;
			rep[i][1]=1;
		}
		for(int i = 0; i<M; i++) {
			int a = findrep(rep,readInt()), b = findrep(rep,readInt());
			if(r.charAt(a-1)==r.charAt(b-1)) {
				if(rep[a][1]>=rep[b][1]) {
					rep[b][0]=a;
					rep[a][1]++;
				}
				else {
					rep[a][0]=b;
					rep[b][1]++;
				}
			}
		}
		int cnt = 0;
		for(int i = 0; i<K; i++) {
			if(findrep(rep,readInt())==findrep(rep,readInt())) {
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