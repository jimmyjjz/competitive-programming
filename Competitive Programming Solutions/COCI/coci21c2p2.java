import java.util.*;
import java.io.*;
public class Kutije{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int disjoint[][];
	static int findrep(int x) {return x==disjoint[x][0]?x:findrep(disjoint[x][0]);}
	public static void main(String[] args) throws IOException{
		int N = readInt(), M = readInt(), Q = readInt();
		disjoint = new int[N+1][2];
		for(int i = 0; i<=N; i++)disjoint[i][0]=i;
		for(int i = 0; i<M; i++) {
			for(int j = 1; j<=N; j++) {
				int a = findrep(readInt()), b = findrep(j);
				if(a!=b) {
					if(disjoint[a][1]>=disjoint[b][1]) {
						disjoint[a][1]++;
						disjoint[b][0]=a;
					}
					else {
						disjoint[b][1]++;
						disjoint[a][0]=b;
					}
				}
			}
		}
		for(int i = 0; i<Q; i++)System.out.println(findrep(readInt())==findrep(readInt())?"DA":"NE");
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