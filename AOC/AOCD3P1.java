import java.util.*;
import java.io.*;
public class AOCD3P1 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int sum=0, l=140;//140
		char board[][] = new char[l][l];
		for(int i = 0; i<l; i++) {
			String s = readLine();
			for(int j = 0; j<l; j++)board[i][j]=s.charAt(j);
		}
		for(int i = 0; i<l; i++) {
			String s="0";
			boolean ok=false;
			for(int j = 0; j<l; j++) {
				if(Character.isDigit(board[i][j])) {
					try {if(!Character.isDigit(board[i+1][j])&&board[i+1][j]!='.')ok=true;}catch(Exception e) {}
					try {if(!Character.isDigit(board[i][j+1])&&board[i][j+1]!='.')ok=true;}catch(Exception e) {}
					try {if(!Character.isDigit(board[i+1][j+1])&&board[i+1][j+1]!='.')ok=true;}catch(Exception e) {}
					try {if(!Character.isDigit(board[i-1][j])&&board[i-1][j]!='.')ok=true;}catch(Exception e) {}
					try {if(!Character.isDigit(board[i][j-1])&&board[i][j-1]!='.')ok=true;}catch(Exception e) {}
					try {if(!Character.isDigit(board[i-1][j-1])&&board[i-1][j-1]!='.')ok=true;}catch(Exception e) {}
					try {if(!Character.isDigit(board[i+1][j-1])&&board[i+1][j-1]!='.')ok=true;}catch(Exception e) {}
					try {if(!Character.isDigit(board[i-1][j+1])&&board[i-1][j+1]!='.')ok=true;}catch(Exception e) {}
					s+=board[i][j]+"";
				}
				else {
					if(ok)sum+=Integer.parseInt(s);
					//if(!s.equals("0"))System.out.println(ok+" "+s);
					ok=false;
					s="0";
				}
			}
			if(ok)sum+=Integer.parseInt(s);
			//if(!s.equals("0"))System.out.println(ok+" "+s);
		}
		System.out.println(sum);
	}
	static String next() throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}

	static long readLong() throws IOException {
		return Long.parseLong(next());
	}

	static int readInt() throws IOException {
		return Integer.parseInt(next());
	}

	static double readDouble() throws IOException {
		return Double.parseDouble(next());
	}

	static char readCharacter() throws IOException {
		return next().charAt(0);
	}

	static String readLine() throws IOException {
		return br.readLine().trim();
	}
}