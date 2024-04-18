import java.util.*;
import java.io.*;
public class AFamiliarProblem {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt();
		long M = readLong();
		int[] nums = new int[N];
		for(int i = 0; i<N; i++)nums[i]=readInt();
		int bot = 0, top = 0, size = 1, max = 0;
		long sum = nums[0];
		while(bot<N) {
			try {
			if(sum<M) {
				max = Math.max(max, size);
				top++;
				size++;
				sum+=nums[top];
			}
			else{
				size--;
				sum-=nums[bot];
				bot++;
			}
			if(bot>top) {
				size=1;
				top=bot;
				sum=nums[top];
				if(sum<M)max = Math.max(max, size);
			}
			}
			catch(Exception e) {break;}
		}
		System.out.println(max);
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