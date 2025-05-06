import java.util.*;
import java.io.*;
public class JoeyandBiology{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int len1 = readInt(), len2 = readInt();
		String s1 = readLine(), s2 = readLine();
		int[][] dp = new int[len1+1][len2+1];
		for(int i = 1; i<=len1; i++)dp[i][0]=(i-1)/3+1;
		for(int i = 1; i<=len2; i++)dp[0][i]=(i-1)/3+1;
		for(int i = 1; i<=len1; i++) {
			for(int j = 1; j<=len2; j++) {
				if(s1.charAt(i-1)==s2.charAt(j-1))dp[i][j]=dp[i-1][j-1];
				else{
					int min = Integer.MAX_VALUE;
					try {min=Math.min(min, dp[i-1][j]+1);}catch(Exception e) {}
					try {min=Math.min(min, dp[i-2][j]+1);}catch(Exception e) {}
					try {min=Math.min(min, dp[i-3][j]+1);}catch(Exception e) {}
					try {min=Math.min(min, dp[i][j-1]+1);}catch(Exception e) {}
					try {min=Math.min(min, dp[i][j-2]+1);}catch(Exception e) {}
					try {min=Math.min(min, dp[i][j-3]+1);}catch(Exception e) {}
					try {min=Math.min(min, dp[i-1][j-1]+1);}catch(Exception e) {}
					dp[i][j]=min;
				}
			}
		}
//		for(int i = 0; i<=len1; i++) {
//			for(int j = 0; j<=len2; j++)System.out.print(dp[i][j]);
//			System.out.println();
//		}
		System.out.println(dp[len1][len2]);
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