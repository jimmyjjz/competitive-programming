import java.util.*;
import java.io.*;
public class BiggerBigInteger{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), pre = 0;
		String s = readLine();
		int[] nums = new int[N];
		for(int i = 0; i<N; i++)nums[i]=Integer.parseInt(s.charAt(i)+"");
		pre=nums[0];
		for(int i = 1; i<N; i++) {
			if(nums[i]>pre) {
				nums[i-1]=nums[i];
				nums[i]=pre;
				break;
			}
			pre=nums[i];
		}
		for(int i : nums)System.out.print(i);
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