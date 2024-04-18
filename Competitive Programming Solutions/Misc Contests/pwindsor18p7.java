import java.util.*;
import java.io.*;
public class definitions{
	static class numbers{
	String s;
	public numbers(String s) {
		this.s=s;
	}
}
static class SortByFirst implements Comparator<numbers>{
	public int compare(numbers a, numbers b) {
		String one = a.s+b.s;
		String two = b.s+a.s;
		if(Long.parseLong(one) > Long.parseLong(two)) {
			return -1;
		}
		if(Long.parseLong(one) < Long.parseLong(two)) {
			return 1;
		}
		return 0;
	}
}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		List<numbers> board = new ArrayList<numbers>();
		int N = readInt();
		for(int i = 0; i<N; i++) {
			board.add(new numbers(readLine()+""));
		}
		Collections.sort(board, new SortByFirst());
		for(int i = 0; i<N; i++) {
			System.out.print(board.get(i).s);
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