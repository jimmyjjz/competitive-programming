import java.util.*;
import java.io.*;
public class Jerseys{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int J = readInt(), A = readInt(), jer[] = new int[J],cnt = 0;
		for(int i = 0; i<J; i++) {
			String s = next();
			jer[i]=s.equals("L")?3:s.equals("M")?2:1;
		}
		for(int i = 0; i<A; i++) {
			String s = next();
			int size = s.equals("L")?3:s.equals("M")?2:1,in = readInt()-1;
			if(jer[in]>=size) {
				cnt++;
				jer[in]=0;
			}
		}
		System.out.println(cnt);
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