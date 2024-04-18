import java.util.*;
import java.io.*;
public class Kparty {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		Map<Integer,Boolean> exist = new HashMap<Integer,Boolean>();
		int in = readInt();
		boolean trig = false;
		int[] board = new int[in];
		for(int i = 0; i<in; i++) {
			int save = readInt();
			exist.put(save, true);
			board[i] = save;
		}
		for(int i = 0; i<in; i++) {
			for(int j = 0; j<in; j++) {
				if(i == j) {
					continue;
				}
				if(board[i]%2==0 && board[j]%2==0 || board[i]%2!=0 && board[j]%2!=0) {
					if(exist.get((board[i]+board[j])/2) != null) {
						System.out.println("3");
						return;
					}
					trig = true;
				}
			}
		}
		if(trig) {
			System.out.println("2");
		}
		else {
			System.out.println("1");
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