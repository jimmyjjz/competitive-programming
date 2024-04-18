import java.util.*;
import java.io.*;
public class EscapeRoom {
	static class pair{
		int a,b;
		public pair(int a, int b) {
			this.a=a;
			this.b=b;
		}
	}
	public static List<pair> FactorGen(int N){ 
		List<pair> factors = new ArrayList<pair>();
		for(int i = 1; i*i<N; i++) {
			if(N % i == 0) {
				factors.add(new pair(i,N/i));
			}
		}
		if(Math.sqrt(N)%1==0) {
			factors.add(new pair((int)Math.sqrt(N),(int)Math.sqrt(N)));
		}
		return factors;
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int M = readInt(), N = readInt();
		int[][] board = new int[M+1][N+1];
		for(int i = 1; i<=M; i++) {
			for(int j = 1; j<=N; j++) {
				board[i][j] = readInt();
			}
		}
		boolean[] valid = new boolean[1000001];
		List<pair> current = new ArrayList<pair>();
		current.add(new pair(1,1));
		for(int i = 0; i<current.size(); i++) {
			try {
				int save = board[current.get(i).a][current.get(i).b];
			if(!valid[save]) {
				valid[save]=true;
				List<pair> insert = new ArrayList<pair>(FactorGen(save));
				int fixed = insert.size();
				for(int j = 0; j<fixed; j++) {
					pair p = insert.get(j);
					if(p.a==M&&p.b==N || p.b==M&&p.a==N) {
						System.out.println("yes");
						return;
					}
					current.add(new pair(p.a,p.b));
					current.add(new pair(p.b,p.a));
				}
			}
			} 
			catch(IndexOutOfBoundsException e) {}
		}
		System.out.println("no");
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