import java.util.*;
import java.io.*;
public class SleepinginClass{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		//div 
		int T = readInt();
		for(int i = 0; i<T; i++) {
			int N = readInt();
			int[] nums = new int[N];
			int tot = 0;
			for(int j = 0; j<N; j++) {
				nums[j]=readInt();
				tot+=nums[j];
			}
			for(int j = N; j>0; j--) {
				if(tot%j!=0)continue;
				int now = 0;
				out:{
				for(int k : nums) {
					now+=k;
					if(now==tot/j)now=0;
					else if(now>tot/j)break out;
				}
				System.out.println(N-j);
				break;
				}
			}
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