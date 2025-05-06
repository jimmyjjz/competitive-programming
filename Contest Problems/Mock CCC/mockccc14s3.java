import java.util.*;
import java.io.*;
	public class SpreadSheet {
		static class column{
    List<Integer> data = new ArrayList<Integer>();
	}
	static int place;
	 static class SortByC implements Comparator<column> {
		public int compare(column a, column b) {
				if(a.data.get(place) < b.data.get(place)) {
					return -1;
				}
				if(a.data.get(place) == b.data.get(place)) {
					return 0;
				}
				if(a.data.get(place) > b.data.get(place)) {
					return 1;
				}
				return 0;
		}
	 }
	 public static void change(int in) {
		 	place = in;
	 }
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		List<column> board = new ArrayList<column>();
		int col = readInt(), row = readInt();
		for(int i = 0; i<col; i++) {
			board.add(new column());
		}
		for(int i = 0; i<col; i++) {
			for(int j = 0; j<row; j++) {
				board.get(i).data.add(readInt());
			}
		}
		int N = readInt();
		for(int i = 0; i<N; i++) {
			change(readInt()-1);
			Collections.sort(board, new SortByC());
		}
		for(int i = 0; i<col; i++) {
			for(int j = 0; j<row; j++) {
				System.out.print(board.get(i).data.get(j)+" ");
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