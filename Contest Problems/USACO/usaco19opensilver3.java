import java.util.*;
import java.io.*;
public class FencePlanning{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int findrep(int[][] dsu, int n) {return n==dsu[n][0]?n:findrep(dsu,dsu[n][0]);}
	public static void main(String[] args) throws IOException{
		int N = readInt(), M = readInt(), x[][] = new int[N+1][2], y[][] = new int[N+1][2], dsu[][] = new int[N+1][2];
		for(int i = 1; i<=N; i++) {
			int X = readInt(), Y = readInt();
			x[i][0]=X;
			x[i][1]=X;
			y[i][0]=Y;
			y[i][1]=Y;
			dsu[i][0]=i;
		}
		for(int i = 0; i<M; i++) {
			int a = findrep(dsu,readInt()), b = findrep(dsu,readInt());
			if(dsu[a][1]>dsu[b][1]) {
				dsu[b][0]=a;
				dsu[a][1]++;
				x[a][0]=Math.min(x[a][0], x[b][0]);
				x[a][1]=Math.max(x[a][1], x[b][1]);
				y[a][0]=Math.min(y[a][0], y[b][0]);
				y[a][1]=Math.max(y[a][1], y[b][1]);
			}
			else {
				dsu[a][0]=b;
				dsu[b][1]++;
				x[b][0]=Math.min(x[b][0], x[a][0]);
				x[b][1]=Math.max(x[b][1], x[a][1]);
				y[b][0]=Math.min(y[b][0], y[a][0]);
				y[b][1]=Math.max(y[b][1], y[a][1]);
			}
		}
		int min = Integer.MAX_VALUE;
		for(int i = 1; i<=N; i++) {
			int rep = findrep(dsu,i);
			min=Math.min(min,(x[rep][1]-x[rep][0])*2+(y[rep][1]-y[rep][0])*2);
		}
		System.out.println(min);
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