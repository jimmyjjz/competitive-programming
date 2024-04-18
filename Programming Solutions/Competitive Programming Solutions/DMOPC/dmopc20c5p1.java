import java.util.*;
import java.io.*;
public class type {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		String a = readLine();
		String b = readLine();
		int count = 0;
		boolean contact = false;
		try {
		for(int i = 0; i<b.length(); i++) {
			if(a.charAt(i) != b.charAt(i)) {
				count+=(a.length()-i);
				count+=(b.length()-i);
				contact = true;
				break;
			}
		}
		}
		catch(StringIndexOutOfBoundsException e) {
			count+=b.length()-a.length();
			System.out.println(count);
			return;
		}
		if(!contact) {
			count+=a.length()-b.length();
		}
		System.out.println(count);
		
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