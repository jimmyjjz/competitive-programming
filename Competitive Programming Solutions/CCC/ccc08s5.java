import java.util.*;
import java.io.*;
public class Nukit {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static class particles{
		int a,b,c,d;
		public particles(int a, int b, int c, int d) {
			this.a=a;
			this.b=b;
			this.c=c;
			this.d=d;
		}
	}
	public static void main(String[] args) throws IOException{
		int N = readInt();
		boolean[][][][] win = new boolean[31][31][31][31];
		for(int i = 0; i<31; i++) {
			for(int j = 0; j<31; j++) {
				for(int k = 0; k<31; k++) {
					for(int z = 0; z<31; z++) {
						if(!win[i][j][k][z]) {
							try{win[i+2][j+1][k+0][z+2]=true;}catch(Exception e) {}
							try{win[i+1][j+1][k+1][z+1]=true;}catch(Exception e) {}
							try{win[i][j][k+2][z+1]=true;}catch(Exception e) {}
							try{win[i][j+3][k][z]=true;}catch(Exception e) {}
							try{win[i+1][j][k][z+1]=true;}catch(Exception e) {}
						}
					}
				}
			}
		}
		for(int i = 0; i<N; i++)System.out.println((win[readInt()][readInt()][readInt()][readInt()])?"Patrick":"Roland");
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