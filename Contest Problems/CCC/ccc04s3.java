import java.util.*;
import java.io.*;
public class Spreadsheets {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		String[][] ori = new String[10][9];
		int[][] value = new int[10][9];
		for(int i = 0; i<10; i++) {
			for(int j = 0; j<9; j++)ori[i][j]=next();
		}
		for(int i = 0; i<10; i++) {
			for(int j = 0; j<9; j++)value[i][j]=-1;
		}
		for(int i = 0; i<10; i++) {
			for(int j = 0; j<9; j++) {
				try{value[i][j]=Integer.parseInt(ori[i][j]);}
				catch(Exception e) {};
			}
		}
		boolean moving = true;
		while(moving) {
			moving = false;
			for(int i = 0; i<10; i++) {
				for(int j = 0; j<9; j++) {
					if(value[i][j]==-1) {
						StringTokenizer split = new StringTokenizer(ori[i][j],"+");
						int tot = 0;
						out:{
						while(split.hasMoreTokens()) {
							String token = split.nextToken();
							if(value[token.charAt(0)-65][Integer.parseInt(token.charAt(1)+"")-1]!=-1) {
								tot+=value[token.charAt(0)-65][Integer.parseInt(token.charAt(1)+"")-1];
							}
							else{
								break out;
							}
						}
						moving = true;
						value[i][j]=tot;
						}
					}
				}
			}
		}
		for(int i = 0; i<10; i++) {
			for(int j = 0; j<9; j++) {
				System.out.print((value[i][j]==-1)?"* ":value[i][j]+" ");
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