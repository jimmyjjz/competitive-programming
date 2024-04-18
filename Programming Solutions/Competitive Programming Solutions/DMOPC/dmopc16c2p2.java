import java.util.*;
import java.io.*;
public class EbolaOutbreak{
	public static int findrep(int[][] rep, int n) {
		while(rep[n][0]!=n)n=rep[n][0];
		return n;
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), M = readInt();
		int[][] rep = new int[N+1][2];
		for(int i = 1; i<=N; i++) {
			rep[i][0]=i;
			rep[i][1]=1;
		}
		for(int i = 0; i<M; i++) {
			int K = readInt(), king = 0, amount = 0;
			int[] keep = new int[K+1];
			boolean one = false;
			for(int j = 1; j<=K; j++) {
				keep[j]=findrep(rep,readInt());
				if(!one) {
				if(keep[j]==1) {
					one=true;
					king=1;
				}
				else if(rep[keep[j]][1]>amount) {
					amount=rep[keep[j]][1];
					king=keep[j];
				}
				}
			}
			for(int j = 1; j<=K; j++) {
				if(findrep(rep,keep[j])!=king) {
					rep[keep[j]][0]=king;
					rep[king][1]+=rep[keep[j]][1];
				}
			}
		}
		System.out.println(rep[1][1]);
		for(int i = 1; i<=N; i++) if(findrep(rep, i)==1)System.out.print(i+" ");
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