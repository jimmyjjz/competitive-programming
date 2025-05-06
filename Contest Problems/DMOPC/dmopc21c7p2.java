import java.util.*;
import java.io.*;
public class KnittingScarves{
	public static class spot{
		int n,p;
		public spot(int n, int p) {
			this.n=n;
			this.p=p;
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), Q = readInt();
		spot[] nums = new spot[N+2];
		for(int i = 1; i<=N; i++)nums[i]=new spot(i+1,i-1);
		nums[0]=new spot(1,0);
		nums[N+1]=new spot(N+1,N);
		for(int i = 0; i<Q; i++) {
			int L = readInt(), R = readInt(), K = readInt();
			nums[nums[L].p].n=nums[R].n;
			nums[nums[R].n].p=nums[L].p;
			nums[nums[K].n].p=R;
			nums[R].n=nums[K].n;
			nums[L].p=K;
			nums[K].n=L;

		}
		int cur = nums[0].n;
		for(int i = 0; i<N; i++) {
			System.out.print(cur+" ");
			cur=nums[cur].n;
		}
		System.out.println();
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