import java.util.*;
import java.io.*;
public class NailedIt {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt();
		int[] pieces = new int[2001];
		for(int i = 0; i<N; i++)pieces[readInt()]++;
		int[] boards = new int[4001];
		for(int i = 1; i<=2000; i++) {
			for(int j = i; j<=2000; j++) {
				if(i==j)boards[i+j]+=pieces[i]/2;
				else boards[i+j]+=Math.min(pieces[i], pieces[j]);
			}
		}
		//System.out.println(board[1]);
		int len = 0, ways = 0;
		for(int i = 2; i<=4000; i++) {
			if(boards[i]>len) {
				ways = 1;
				len = boards[i];
				//System.out.println(i);
			}
			else if(boards[i]==len)ways++;
		}
		System.out.println(len+" "+ways);
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