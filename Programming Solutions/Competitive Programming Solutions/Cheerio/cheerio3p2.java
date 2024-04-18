import java.util.*;
import java.io.*;
public class DoubleOSeven{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), p = 0, ammo = 0, Eammo = 0;
		String s = readLine();
		//RFB, R->if ammo 0 R: else F, F->B, B->R
		for(char c : s.toCharArray()) {
			if(c=='R') {
				Eammo++;
				if(ammo!=0) {
					ammo--;
					p++;
				}
				else ammo++;
			}
			else if(c=='F') {
				if(Eammo!=0)Eammo--;
				else if(ammo!=0) {
					ammo--;
					p++;
				}
				else ammo++;
			}
			else ammo++;
		}
		System.out.println(p);
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