import java.util.*;
import java.io.*;
public class MobilePhones{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static class TwoDBIT{
		int board[][],r,c;
		public TwoDBIT(int r, int c) {
			this.r=r;
			this.c=c;
			board = new int[r+1][c+1];
		}
		public void update(int x, int y, int v) {
			for(int i = x; i<=r; i+=i&-i) {
				for(int j = y; j<=c; j+=j&-j)board[i][j]+=v;
			}
		}
		public long query(int x, int y) {
			long sum = 0;
			for(int i = x; i>0; i-=i&-i) {
				for(int j = y; j>0; j-=j&-j)sum+=board[i][j];
			}
			return sum;
		}
	}
	public static void main(String[] args) throws IOException{
		int action = readInt(), S = readInt();
		TwoDBIT tdbit = new TwoDBIT(S,S);
		while(action!=3) {
			if(action==1)tdbit.update(readInt()+1,readInt()+1,readInt());
			else if(action==2){
				int r1 = readInt()+1, c1 = readInt()+1, r2 = readInt()+1, c2 = readInt()+1;
				System.out.println(tdbit.query(r2,c2)-tdbit.query(r1-1,c2)-tdbit.query(r2,c1-1)+tdbit.query(r1-1,c1-1));
			}
			action=readInt();
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