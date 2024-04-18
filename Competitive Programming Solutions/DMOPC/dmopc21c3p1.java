import java.util.*;
import java.io.*;
public class SumsAndDifferences {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt();
		long[] nums = new long[N+1];
		for(int i = 1; i<N; i+=2) {
			System.out.print("? "+i+" "+(i+1)+"\n");
			System.out.flush();
			long one = readLong();
			System.out.flush();
			System.out.print("? "+i+" "+(i+1)+"\n");
			System.out.flush();
			long two = readLong();
			System.out.flush();
			nums[i]=one+(two/2);
			nums[i+1]=two/2;
			//System.out.println(Arrays.toString(nums));
		}
		if(N%2!=0) {
			System.out.print("? "+(N-1)+" "+N+"\n");
			System.out.flush();
			long two = readLong();
			System.out.flush();
			nums[N]=(nums[N-1]*2)-two;
			//System.out.println(Arrays.toString(nums));
		}
		System.out.print("!");
		for(int i = 1; i<=N; i++) {
			System.out.print(" "+nums[i]);
		}
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