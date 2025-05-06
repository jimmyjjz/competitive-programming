import java.util.*;
import java.io.*;
public class NonTransitiveDice{
	public static boolean beat(int[] a, int[] b) {
		int Acnt = 0, Bcnt = 0;
		for(int i = 0; i<4; i++) {
			for(int j = 0; j<4; j++) {
				if(a[i]<b[j])Bcnt++;
				else if(a[i]>b[j])Acnt++;
			}
		}
		return Acnt>Bcnt;
	}
	public static int[] a = new int[4], b = new int[4];
	public static boolean yes = false;
	public static void r(int d, int[] cur) {
		if(d==4) {
			if(beat(a,b)&&beat(b,cur)&&beat(cur,a))yes=true;
			else if(beat(a,cur)&&beat(cur,b)&&beat(b,a))yes=true;
			return;
		}
		for(int i = 1; i<=10; i++) {
		cur[d]=i;
		r(d+1,cur);
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt();
		for(int i = 0; i<N; i++) {
		yes=false;
		for(int j = 0; j<4; j++)a[j]=readInt();
		for(int j = 0; j<4; j++)b[j]=readInt();
		r(0,new int[4]);
		if(yes)System.out.println("yes");
		else System.out.println("no");
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