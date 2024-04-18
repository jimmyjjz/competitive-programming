import java.util.*;
import java.io.*;
public class MathHomework{
	static class q{
		int a,b,v;
		public q(int a, int b, int v) {
			this.a=a;
			this.b=b;
			this.v=v;
		}
	}
	static int gcd(int a, int b) {
		return b==0?a:gcd(b,a%b);
	}
	static int bitdex(int n) {return(int)(Math.log(n)/Math.log(2));}
	static int query(int L, int R){
		int j = bitdex(R-L+1);
		return gcd(sparse[j][L],sparse[j][R-(1<<j)+1]);
	}
	static int sparse[][];
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{	
		int N = readInt(), M = readInt(), req[][] = new int[17][N+2];
		sparse = new int[bitdex(N)+1][N+1];
		q valids[] = new q[M+1];
		for(int i = 1; i<=M; i++) {
			int a = readInt(), b = readInt(), v = readInt();
			req[v][a]++; 
			req[v][b+1]--;
			valids[i]=new q(a,b,v);
		}
		for(int i = 1; i<=N; i++) {
			sparse[0][i]=1;
			for(int j = 1; j<=16; j++) {
				req[j][i]+=req[j][i-1];
				if(req[j][i]!=0)sparse[0][i]=sparse[0][i]*j/gcd(sparse[0][i],j);
			}
		}
		for(int i = 1; i<sparse.length; i++) {
			for(int j=1; j+(1<<i)-1<=N; j++)sparse[i][j]=gcd(sparse[i-1][j],sparse[i-1][j+(1<<i-1)]);
		}
		for(int i = 1; i<=M; i++) {
			if(query(valids[i].a,valids[i].b)!=valids[i].v) { 
				System.out.println("Impossible");
				return;
			}
		}
		for(int i = 1; i<=N; i++)System.out.print(sparse[0][i]+" ");
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