import java.util.*;
import java.io.*;
public class phonenum {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int t = readInt();
		String input = "";
		String convert = "";
		for(int i = 0; i<t; i++) {
			convert = "";
			input = readLine();
			for(int j = 0; j<input.length(); j++) {
				if(Character.isAlphabetic(input.charAt(j))) {
					if(input.charAt(j) == 'A' || input.charAt(j) == 'B' || input.charAt(j) == 'C') {
						convert = convert + "2";
					}
					else if(input.charAt(j) == 'D' || input.charAt(j) == 'E' || input.charAt(j) == 'F') {
						convert = convert + "3";
					}
					else if(input.charAt(j) == 'G' || input.charAt(j) == 'H' || input.charAt(j) == 'I') {
						convert = convert + "4";
					}
					else if(input.charAt(j) == 'J' || input.charAt(j) == 'K' || input.charAt(j) == 'L') {
						convert = convert + "5";
					}
					else if(input.charAt(j) == 'M' || input.charAt(j) == 'N' || input.charAt(j) == 'O') {
						convert = convert + "6";
					}
					else if(input.charAt(j) == 'P' || input.charAt(j) == 'Q' || input.charAt(j) == 'R' || input.charAt(j) == 'S') {
						convert = convert + "7";
					}
					else if(input.charAt(j) == 'T' || input.charAt(j) == 'U' || input.charAt(j) == 'V') {
						convert = convert + "8";
					}
					else{
						convert = convert + "9";
					}
				}
				else if(input.charAt(j) != '-') {
					convert = convert + input.charAt(j);
				}
						if(convert.length() > 10) {
							break;
						}
			}
			System.out.println(convert.substring(0,3) + "-" + convert.substring(3,6) + "-" + convert.substring(6,10));
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