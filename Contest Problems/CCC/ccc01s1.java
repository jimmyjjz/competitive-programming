import java.util.*;
import java.io.*;
public class Score {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
	String in = readLine();
	String suits = "CDHS";
	String s = "";
	int now = 0;
	int total = 0;
	boolean flag = false;
	System.out.print("Cards Dealt              Points");
	for(int j = 0; j<4; j++) {
		flag = false;
	for(int i = 0; i<in.length(); i++) {
		if(flag) {
			if(in.charAt(i) == 'C' || in.charAt(i) == 'D' || in.charAt(i) == 'H' || in.charAt(i) == 'S') {
				break;
			}
			s = s+in.charAt(i);
			if(in.charAt(i) == 'A') {
				now = now + 4;
			}
			else if(in.charAt(i) == 'K') {
				now = now + 3;
			}
			else if(in.charAt(i) == 'Q') {
				now = now + 2;
			}
			else if(in.charAt(i) == 'J') {
				now = now + 1;
			}
		}
		if(in.charAt(i) == suits.charAt(j)) {
			flag = true;
		}
	}
	if(s.length() == 0) {
		now = now+3;
	}
	else if(s.length() == 1) {
		now = now+2;
	}
	else if(s.length() == 2) {
		now = now+1;
	}
	System.out.println();
	if(j == 0) {
	System.out.print("Clubs ");
	}
	else if(j == 1) {
		System.out.print("Diamonds ");
		}
	else if(j == 2) {
		System.out.print("Hearts ");
		}
	else if(j == 3) {
		System.out.print("Spades ");
		}
	for(int k = 0; k<s.length(); k++) {
		System.out.print(s.charAt(k)+" ");
	}
	System.out.print(now);
	total = total+now;
	now = 0;
	s = "";
	}
	System.out.println();
	System.out.println("                       Total "+total);
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