import java.util.*;
import java.io.*;
public class RogerSolvesAClassicRageTreeProblem{
	static int bitdex(int n) {return(int)(Math.log(n)/Math.log(2));}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), Q = readInt(), highbit = bitdex(N)+1, min[][] = new int[N][highbit], max[][] =  new int[N][highbit];
		for(int i = 0; i<N; i++) {
			int in = readInt();
			min[i][0]=in;
			max[i][0]=in;
		}
		for(int i = 1; i<=highbit; i++) {
			for(int j = 0; j+(1<<i)-1<N; j++) {
				min[j][i]=Math.min(min[j][i-1],min[j+(1<<(i-1))][i-1]);
				max[j][i]=Math.max(max[j][i-1],max[j+(1<<(i-1))][i-1]);
			}
		}
		for(int i = 0; i<Q; i++) {
			int l = readInt()-1, r = readInt()-1, dex = bitdex(r-l+1);
			System.out.println(Math.max(max[l][dex],max[r-(1<<dex)+1][dex])-Math.min(min[l][dex],min[r-(1<<dex)+1][dex]));
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