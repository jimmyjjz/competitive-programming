import java.util.*;
import java.io.*;
public class BoardGames {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{ 
		LinkedList<Integer> current = new LinkedList<Integer>();
		current.add(readInt());
		int M = readInt(),moves = 0;
		boolean[] valid = new boolean[10000001];
		if(current.get(0)==M) {
			System.out.println("0");
			return;
		}
		while(true) {
			moves++;
			int fixed = current.size();
			for(int i = 0; i<fixed; i++) {
				int get = current.remove(0);
				try {
				if(!valid[get]) {
				valid[get]=true;
				if(3*get == M || get-1 == M || get-3 == M) {
					System.out.println(moves);
					return;
				}
				current.add(3*get);
				current.add(get-1);
				current.add(get-3);
				if(get%2==0) {
					if(get/2 == M) {
						System.out.println(moves);
						return;
					}
					current.add(get/2);
				}
				}
			}
				catch(Exception e) {};
			}
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