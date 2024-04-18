import java.util.*;
import java.io.*;
public class DisjointSetTest {
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
		List<Integer> current = new ArrayList<Integer>();
		for(int i = 1; i<=M; i++) {
			int a = findrep(rep,readInt()), b = findrep(rep,readInt());
			if(a==b)continue;
			current.add(i);
			if(rep[a][1]>=rep[b][1]) {
				rep[a][1]++;
				rep[b][0]=a;
			}
			else {
				rep[b][1]++;
				rep[a][0]=b;
			}
		}
		boolean flag = false;
		for(int i = 1; i<=N; i++) {
			if(findrep(rep,i)==i) {
				if(!flag)flag = true;
				else {
					System.out.println("Disconnected Graph");
					return;
				}
			}
		}
		for(int n : current)System.out.println(n);
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