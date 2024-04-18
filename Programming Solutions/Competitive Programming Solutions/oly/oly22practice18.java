import java.util.*;
import java.io.*;
public class FenceforFlowers{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), M = readInt();
		List<Integer> flowers = new ArrayList<Integer>();
		int[] fences = new int[M+1];
		for(int i = 0; i<N; i++)flowers.add(readInt());
		for(int i = 1; i<=M; i++)fences[i]=readInt();
		for(int i = M-1; i>=0; i--)fences[i]=Math.min(fences[i+1], fences[i]);
		Collections.sort(flowers);
		//System.out.println(flowers);
		//System.out.println(Arrays.toString(fences));
		int[] dp = new int[N];
		Arrays.fill(dp, Integer.MAX_VALUE);
		for(int i = 0; i<N; i++) {
			for(int j = i; j<N; j++) {
				try{dp[j]=Math.min(dp[j], dp[i-1]+fences[flowers.get(j)-flowers.get(i)+1]);}
				catch(Exception e) {dp[j]=Math.min(dp[j], fences[flowers.get(j)-flowers.get(i)+1]);}
			}
		}
		//System.out.println(Arrays.toString(dp));
		System.out.println(dp[N-1]);
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