import java.util.*;
import java.io.*;
public class Japaneasy{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int T = readInt();
		for(int i = 0; i<T; i++) {
			String s = readLine();
			boolean japanese = true, knmr = false, h = false, f = false;
			for(int c : s.toCharArray()) {
				if(c!='a'&&c!='e'&&c!='i'&&c!='o'&&c!='u'&&c!='k'&&c!='n'&&c!='h'&&c!='f'&&c!='m'&&c!='r'){
					japanese=false;
					break;
				}
				if(knmr) {
					if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u') {
						knmr=false;
						continue;
					}
					else{
						japanese=false;
						break;
				}
				}
				if(h) {
					if(c=='a'||c=='e'||c=='i'||c=='o') {
						h=false;
						continue;
					}
					else{
						japanese=false;
						break;
				}
				}
				if(f) {
					if(c=='u') {
						f=false;
						continue;
					}
					else{
						japanese=false;
						break;
				}
				}
				if(c=='k'||c=='n'||c=='m'||c=='r')knmr=true;
				else if(c=='h')h=true;
				else if(c=='f')f=true;
			}
			if(knmr||f||h)japanese=false;
			System.out.println(japanese?"YES":"NO");
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