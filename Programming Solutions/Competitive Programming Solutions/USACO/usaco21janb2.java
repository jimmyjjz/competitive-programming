import java.util.*;
import java.io.*;
public class Photos {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), even = 0, odd = 0;
		for(int i = 0; i<N; i++) {	
			if(readInt()%2==0) {
				even++;
			}
			else {
				odd++;
			}
		}
		if(even>odd) {
			System.out.println((odd*2)+1);
		}
		else if(even==odd) {
			System.out.println(odd+even);
		}
		else if(even<odd) {
			while(even<odd) {
				even++;
				odd-=2;
			}
			if(even==odd) {
				System.out.println(odd+even);
			}
			else if(even>odd) {
				System.out.println((odd*2)+1);
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