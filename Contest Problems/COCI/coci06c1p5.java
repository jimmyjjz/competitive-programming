import java.util.*;
import java.io.*;
public class Bond{
	static class part{
		int x, b[];
		public part(int x, int[] b) {
			this.x=x;
			this.b=b;
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	public static int bittonum(int[] bit) {
		int expo = 1, sum = 0;
		for(int i : bit) {
			if(i==1)sum+=expo;
			expo*=2;
		}
		return sum;
	}
	public static void main(String[] args) throws IOException{
		N = readInt();
		int form[] = new int[N];
		Arrays.fill(form,1);
		int bitsize=bittonum(form);
		double pre[] = new double[bitsize+1];
		double[][] missions = new double[N][N];
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++)missions[i][j]=(double)(readInt())/100.0;
		}
		for(int i = 0; i<N; i++) {
			int[] b = new int[N];
			b[i]=1;
			pre[bittonum(b)]=missions[0][i];
		}
		for(int z = 1; z<N; z++){
			double cur[] = new double[bitsize+1];
			for(int i = 1; i<=bitsize; i++) {
				if(pre[i]==0)continue;
				int expo = 1;
				for(int j = 0; j<N; j++) {
					if((i&expo)==0)cur[i|expo]=Math.max(cur[i|expo],pre[i]*missions[z][j]);
					expo*=2;
				}
			}
			pre=cur;
		}
		System.out.println(pre[bitsize]*100);
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