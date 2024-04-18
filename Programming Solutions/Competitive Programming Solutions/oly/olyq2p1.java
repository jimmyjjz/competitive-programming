import java.util.*;
import java.io.*;
public class LargestMinimumDistance {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int N = readInt(), M = readInt();
		int[] tables = new int[N];
		for(int i = 0; i<N; i++)tables[i]=readInt();
		Arrays.sort(tables);
		int low = 0, high = tables[N-1], min = 0;
		while(high>=low){
			int mid=(low+high)/2, cnt = 1, temp = tables[0];
			out:{
			for(int i : tables) {
				//System.out.println(i);
				if(mid<=i-temp) {
					cnt++;
					temp=i;
					if(cnt==M) {
						low=mid+1;
						//System.out.println("-> "+low);
						min=Math.max(min,mid);
						break out;
					}
				}
			}
			high=mid-1;
			}
		}
		System.out.println(min);
	}
	static String next() throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}

	static long readLong() throws IOException {
		return Long.parseLong(next());
	}

	static int readInt() throws IOException {
		return Integer.parseInt(next());
	}

	static double readDouble() throws IOException {
		return Double.parseDouble(next());
	}

	static char readCharacter() throws IOException {
		return next().charAt(0);
	}

	static String readLine() throws IOException {
		return br.readLine().trim();
	}
}