import java.util.*;
import java.io.*;
public class Luggage {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		List<Integer> find = new ArrayList<Integer>();
		Map<Integer,Integer> board = new HashMap<Integer,Integer>();
		int items = readInt(), range = readInt();
		for(int i = 0; i<items; i++){
			int keep = readInt();
			if(board.get(keep) == null) {
				find.add(keep);
				board.put(keep,1);
			}
			else {
				board.put(keep,board.get(keep)+1);
			}
		}
		Collections.sort(find);
		int max = find.get(0)+range, index = 0, total = 0, minus = 0, biggest = 0;
		while(true) {
			try {
				if(total > biggest) {
					biggest = total;
				}
			if(find.get(index)<=max) {
			total+=board.get(find.get(index));
			index++;
			}
			else{
				total-=board.get(find.get(minus));
				minus++;
				max = find.get(minus)+range;
			}
		}
		catch(IndexOutOfBoundsException e) {
			break;
		}
		}
		System.out.println(biggest);
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