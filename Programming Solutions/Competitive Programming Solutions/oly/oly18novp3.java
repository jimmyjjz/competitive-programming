import java.util.*;
import java.io.*;
public class SplittingASequence {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(),M = readInt(),s = 1, e = 0, out = 0;
		int[] arr = new int[N];
		for(int i = 0; i<N; i++) {
			arr[i]=readInt();
			e += arr[i];
			if(arr[i] > s) {
				s = arr[i];
			}
		}
		while(s <= e) {
			int m =(s+e)/2;
			out:{
				int cnt = 0, save = 0;
				for(int i = 0; i<N; i++) {
					if(arr[i] > m) {
						s = m+1;
						break out;
					}
					save += arr[i];
					if(save > m) {
						cnt++;
						save = arr[i];
					}
				}
				cnt++;
				if(cnt <= M) {
					out = m;
					e = m-1;
				}
				else s = m+1;
			}
		}
		System.out.println(out);
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