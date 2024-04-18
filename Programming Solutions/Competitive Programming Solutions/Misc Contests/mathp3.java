import java.util.*;
import java.io.*;
public class LISReconstruction{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), pre = readInt(), in = 1,cnt = 1,up = 0;
		StringBuilder sb = new StringBuilder();
		if(pre!=1) {
			System.out.println(-1);
			return;
		}
		for(int i = 1; i<N; i++) {
			in = readInt();
			if(in==pre)cnt++;
			else if(in==pre+1) {
				up+=cnt;
				for(int j = up; j>up-cnt; j--)sb.append(j+" ");
				cnt=1;
			}
			else{
				System.out.println(-1);
				return;
			}
			pre=in;
		}
		if(in==pre) {
			up+=cnt;
			for(int j = up; j>up-cnt; j--)sb.append(j+" ");
		}
		System.out.println(sb.toString().trim());
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