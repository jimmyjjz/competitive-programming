import java.util.*;
import java.io.*;
public class DivideandConnor{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int arr[];
	static void swap(int l1, int r1, int l2, int r2, int l3, int r3) {
		int[] temp = new int[r1-l1+1], temp2 = new int[r1-l1+1];
		for(int i = l1; i<=r1; i++)temp[i-l1]=arr[i];
		for(int i = l2; i<=r2; i++)temp2[i-l2]=arr[i];
		for(int i = l1; i<=r1; i++)arr[i]=arr[i-l1+l3];
		for(int i = l2; i<=r2; i++)arr[i]=temp[i-l2];
		for(int i = l3; i<=r3; i++)arr[i]=temp2[i-l3];
	}
	static boolean technique(int l, int r) {
		if(r-l==0)return true;
		if(technique(l, l+(r-l+1)/3-1)&&technique(l+(r-l+1)/3, l+(r-l+1)/3*2-1)&&technique(l+(r-l+1)/3*2, l+(r-l+1)-1)) {
			swap(l, l+(r-l+1)/3-1,l+(r-l+1)/3, l+(r-l+1)/3*2-1,l+(r-l+1)/3*2, l+(r-l+1)-1);
		}
		return true;
	}
	public static void main(String[] args) throws IOException{
		int N = readInt();
		arr = new int[N+1];
		for(int i = 1; i<=N; i++)arr[i]=readInt();
		technique(1,N);
		for(int i = 1; i<=N; i++)System.out.print(arr[i]+" ");
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