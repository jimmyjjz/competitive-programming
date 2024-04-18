import java.util.*;
import java.io.*;
public class AnArrayProblem{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt();
		long sum = 0;
		List<Integer> board = new ArrayList<Integer>();
		for(int i = 0; i<N; i++) {
			board.add(readInt());
			sum+=board.get(board.size()-1);
		}
		//System.out.println(sum);
		System.out.println(Math.min(sum/2,(-(Collections.max(board)*2)+(sum*2))/2));
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