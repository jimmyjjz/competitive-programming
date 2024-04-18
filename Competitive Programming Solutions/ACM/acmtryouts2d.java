import java.util.*;
import java.io.*;
public class Diablo {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt();
		for(int i = 0; i<N; i++) {
			String[] item = (readLine().toLowerCase()).split(" ");
			if(item[0].equals("damaged")) {
				System.out.println("Normal");
				continue;
			}
			if(item[0].length()>1&&(item[0].charAt(item[0].length()-2)+""+(item[0].charAt(item[0].length()-1))).equals("'s")) {
				System.out.println("Set");
				continue;
			}
			if(item.length==2&&item[0].equals("of")) {
				System.out.println("Rare");
				continue;
			}
			if(item.length==2) {
				System.out.println("Not sure, take anyways");
				continue;
			}
			if((item.length==3||item.length==4)&&item[item.length-2].equals("of")) {
				System.out.println("Magic");
				continue;
			}
			System.out.println("Normal");
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