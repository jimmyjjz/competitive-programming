import java.util.*;
import java.io.*;
public class EnglishSummative{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), dp[] = new int[N], bestalpha[] = new int[26];
		for(int i = 0; i<N; i++) {
			String s = readLine();
			int len = s.length(), cnt = 0;
			for(int j = 0; j<len-1; j++)if(s.charAt(j)==s.charAt(j+1))cnt++;
			for(int j = 0; j<26; j++)dp[i]=Math.max(dp[i],bestalpha[j]+cnt+(s.charAt(0)-'a'==j?1:0));
			bestalpha[s.charAt(len-1)-'a']=Math.max(bestalpha[s.charAt(len-1)-'a'],dp[i]);
		}
		System.out.println(dp[N-1]-1);
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