import java.util.*;
import java.io.*;
public class WhereAmI {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt();
		String s = readLine();
		String temp = "";
		for(int i = 1; i<N; i++) {
			for(int j = 0; j<N; j++) {
				temp = s.substring(j,j+i);
				for(int k = j+1; (k+i)<=N; k++) {
					if(s.substring(k,k+i).equals(temp)) {
						i++;
						j=-1;
						break;
					}
				}
				if(j+i == N) {
					System.out.println(i);
					System.exit(0);
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