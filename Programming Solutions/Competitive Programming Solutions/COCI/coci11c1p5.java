import java.util.*;
import java.io.*;
public class COCISort{
	static class BIT{
		long tree[];
		int values[], len;
		public BIT(int length) {
			len=length+1;
			tree=new long[len];
			values=new int[len];
		}
		public void update(int i, int v) {
			long change = v-values[i];
			for(int j = i; j<len; j+=j&-j)tree[j]+=change;
			values[i]=v;
		}
		public long query(int i) {
			long sum = 0;
			for(int j = i; j>0; j=j-(j&-j))sum+=tree[j];
			return sum;
		}
	}
	public static void rev(int[] arr,int a, int b) {
		int[] clone = arr.clone();
		for(int i = a; i<=b; i++)arr[i]=clone[b-i+a];
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), arr[] = new int[N];
		long r = 0;
		for(int i = 0; i<N; i++)arr[i]=readInt();
		int down = 0;
		for(int i = 1; i<N; i++) {
			if(arr[i]<arr[i-1])down++;
			else if(down>0) {
				r++;
				rev(arr,i-down-1,i-1);
				down=0;
			}
		}
		if(down>0) {
			r++;
			rev(arr,N-down-1,N-1);
		}
		BIT bit = new BIT(N);
		for(int i = N-1; i>=0; i--) {
			r+=bit.query(arr[i]);
			bit.update(arr[i], 1);
		}
		System.out.println(r);
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