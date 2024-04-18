import java.util.*;
import java.io.*;
public class PhotoshootOpen{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt();
		String s = readLine();
		int[] paired = new int[N/2];
		for(int i = 0; i<N; i+=2) {
			if(s.charAt(i)==s.charAt(i+1))paired[i/2]=0;
			else if(s.charAt(i)=='G')paired[i/2]=1;
			else paired[i/2]=2;
		}
		boolean swap = false;
		int cnt = 0;
		for(int i = N/2-1; i>=0; i--) {
			if(paired[i]==0)continue;
			if(!swap&&paired[i]==1) {
				swap = true;
				cnt++;
			}
			else if(swap&&paired[i]==2) {
				swap = false;
				cnt++;
			}
		}
		System.out.println(cnt);
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