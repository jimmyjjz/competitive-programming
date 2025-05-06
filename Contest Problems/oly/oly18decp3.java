import java.util.*;
import java.io.*;
public class maxsumbelow {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), M = readInt(), max = 0;
		int[] nums = new int[N];
		for(int i = 0; i<N; i++) {
			nums[i]=readInt();
		}
		if(N>=5000) {
		Arrays.sort(nums);
		for(int i = 0; i<N; i++) {
			if(nums[i]>=M) {
				System.out.println(max);
				return;
			}
			if(Arrays.binarySearch(nums,M-nums[i])>=0){
				if(M-nums[i]==nums[i]&&nums[i]!=nums[i+1]) {
					continue;
				}
				System.out.println(M);
				return;
			}
				if(i==Math.abs(Arrays.binarySearch(nums,M-nums[i])+2)&&nums[i+1]!=nums[i]) {
					continue;
				}
				//System.out.println(nums[i]+" "+nums[Math.abs(Arrays.binarySearch(nums,M-nums[i])+2)]);
				max = Math.max(nums[i]+nums[Math.abs(Arrays.binarySearch(nums,M-nums[i])+2)], max);
		}
		}
		else {
			for(int i = 0; i<N; i++) {
				for(int j = i+1; j<N; j++) {
					if(nums[i]+nums[j]<=M) {
						max = Math.max(nums[i]+nums[j], max);
					}
				}
			}
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