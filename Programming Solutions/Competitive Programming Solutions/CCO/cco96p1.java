import java.util.*;
import java.io.*;
public class Swap {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		List<Integer> in = new ArrayList<Integer>();
		int N = readInt();
		for(int i = 0; i<N; i++) {
			in.clear();
			int L = readInt(), total = 0, plus = 0;
			for(int j = 1; j<=L; j++) {
				in.add(readInt());
			}
			for(int j = 1; j<=L; j++){
				if(in.get(0) != j) {
				total+=in.indexOf(j);
				in.remove(in.indexOf(j));
				}
				else {
					in.remove(0);
				}
				plus++;
			}
			System.out.println("Optimal train swapping takes "+total+" swaps.");
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