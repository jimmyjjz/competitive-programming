import java.util.*;
import java.io.*;
public class ID {
	public static int sum(String s) {
		int total = 0;
		for(int i = 0; i<s.length(); i++) {
			total += Integer.parseInt(s.charAt(i)+"");
		}
		return total;
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		String save = "";
		String token = "";
		Boolean odd = false;
		for(int k = 0; k<5; k++) {
			StringTokenizer split = new StringTokenizer(readLine(), " ");
		for(int j = 0; j<5; j++) {
			save = "";
		token = split.nextToken();
		if(token.length() % 2!= 0) {
			odd = true;
		}
		for(int i = 0; i<token.length(); i++) {
			if(odd) {
				if(i % 2 == 0) {
					if(Integer.parseInt(token.charAt(i)+"")*2 > 9) {
						save = save + ((Integer.parseInt(token.charAt(i)+"")*2)-9);
					}
					else {
						save = save + Integer.parseInt(token.charAt(i)+"")*2;
					}
				}
				else {
					save = save + token.charAt(i);
				}
			}
			else {
			if(i % 2 != 0) {
				if(Integer.parseInt(token.charAt(i)+"")*2 > 9) {
					save = save + ((Integer.parseInt(token.charAt(i)+"")*2)-9);
				}
				else {
					save = save + Integer.parseInt(token.charAt(i)+"")*2;
				}
			}
			else {
				save = save + token.charAt(i);
			}
			}
		}
		save = sum(save)+"";
		if(Integer.parseInt(save.charAt(save.length()-1)+"") == 0) {
			System.out.print("0");
		}
		else {
		System.out.print(10-Integer.parseInt(save.charAt(save.length()-1)+""));
		}
		odd = false;
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