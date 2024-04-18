import java.util.*;
import java.io.*;
public class Swap {
	public static void rev(int[] arr, int a, int b) {
		int[] clone = arr.clone();
		for(int i = 0; i<=b-a; i++) {
			arr[a+i-1]=clone[b-i-1];
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
	int N = readInt();
	long K = readLong();
	int a = readInt(), b = readInt(), c = readInt(), d = readInt();
	int[] next = new int[N];
	for(int i = 1; i<=N; i++) {
		next[i-1]=i;
	}
	int[] ori = next.clone();
	int cnt = 0;
	while(true) {  
		rev(next,a,b);
		cnt++;
		if(Arrays.toString(next).equals(Arrays.toString(ori))) {
			break;
		}
		rev(next,c,d);
		cnt++;
		if(Arrays.toString(next).equals(Arrays.toString(ori))) {
			break;
		}
	}
	for(int j = 0; j<(K*2%cnt)/2; j++) {
		rev(ori,a,b);
		rev(ori,c,d);
	}
	for(int i = 0; i<N; i++) {
		System.out.println(ori[i]);
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