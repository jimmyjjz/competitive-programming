import java.util.*;
import java.io.*;
public class CheckerboardSummationH{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int MNmax = 3000;
	static class TwoDBIT{
		long board[][];
		int values[][];
		public TwoDBIT() {
			board = new long[MNmax+1][MNmax+1];
			values = new int[MNmax+1][MNmax+1];
		}
		public void update(int x, int y, int v) {
			long change = v-values[x][y];
			for(int i = x; i<=MNmax; i+=(i&-i)) {
				for(int j = y; j<=MNmax; j+=(j&-j))board[i][j]+=change;
			}
			values[x][y]=v;
		}
		public long query(int x, int y) {
			long sum = 0;
			for(int i = x; i>0; i-=(i&-i)) {
				for(int j = y; j>0; j-=(j&-j))sum+=board[i][j];
			}
			return sum;
		}
	}
	public static void main(String[] args) throws IOException{
		int M = readInt(), N = readInt(), action = readInt();
		TwoDBIT white = new TwoDBIT(), black = new TwoDBIT();
		while(action!=0) {
			if(action==1) {
				int x = readInt(), y = readInt(), v = readInt();
				if(x%2==y%2)white.update(x,y,v);
				else black.update(x,y,v);
			}
			else if(action==2) {
				int r1 = readInt(), c1 = readInt(), r2 = readInt(), c2 = readInt();
				long whitesum = white.query(r2,c2)-white.query(r1-1,c2)-white.query(r2,c1-1)+white.query(r1-1,c1-1);
				long blacksum = black.query(r2,c2)-black.query(r1-1,c2)-black.query(r2,c1-1)+black.query(r1-1,c1-1);
				if(r1%2==c1%2)System.out.println(whitesum-blacksum);
				else System.out.println(blacksum-whitesum);
			}
			action = readInt();
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