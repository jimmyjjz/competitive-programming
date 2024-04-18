import java.util.*;
import java.io.*;
public class LCS{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		String s = readLine(), s2 = readLine();
		int len = s.length(), len2 = s2.length();
		int[][] dp = new int[len+1][len2+1];
		for(int i = 1; i<=len; i++) {
			for(int j = 1; j<=len2; j++) {
				if(s.charAt(i-1)==s2.charAt(j-1))dp[i][j]=dp[i-1][j-1]+1;
				else dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
			}
		}
		String back = "";
		while(dp[len][len2]!=0) {
			if(dp[len][len2-1]<dp[len][len2]&&dp[len-1][len2]<dp[len][len2]) {
				len--;
				len2--;
				back=s.charAt(len)+"".concat(back);
			}
			else if(dp[len][len2-1]==dp[len][len2])len2--;
			else len--;
		}
		System.out.println(back);
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