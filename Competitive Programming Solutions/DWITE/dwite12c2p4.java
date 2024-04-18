import java.util.*;
import java.io.*;
public class trys {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		List<Integer> spots = new ArrayList<>();
		for(int k = 0; k<5; k++) {
			spots.clear();
			int p = 0;
			boolean flag = false;
				int N = readInt();
				int[] nums = new int[N];
				for (int i = 0; i < nums.length; i++)
					nums[i] = readInt();
				for (int i = nums.length - 1; i >= 0; i--) {
					if (nums[i] < 0 || nums[i] > spots.size()) {
						System.out.println("IMPOSSIBLE");
						flag = true;
						break;
					}
					spots.add(spots.size() - nums[i], i);
				}
				if(flag) {
					continue;
				}
				int[] parts = new int[N];
				for (int i = 0; i < spots.size(); i++)
					parts[spots.get(i)] = i + 1;
				
				for (int x : parts) {
					switch(p) {
					case 1:
					System.out.print(" ");
					case 0:
						p = 1;
					}
					System.out.print(x);
	}
				System.out.println();
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