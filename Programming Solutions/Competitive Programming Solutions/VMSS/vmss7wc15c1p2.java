import java.util.*;
import java.io.*;
public class cards {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		List<Integer> all = new ArrayList<Integer>();
		int size = readInt();
		int amount = 0;
		int save = 0;
		int total = 0;
		for(int i = 0; i<size; i++) {
			total = 0;
			amount = readInt();
			StringTokenizer split = new StringTokenizer(readLine(), " ");
			for(int k = 0; k<amount; k++) {
				all.add(Integer.parseInt(split.nextToken()));
			}
			List<Integer> sort = new ArrayList<Integer>(all);
			Collections.sort(sort);
			for(int j = 0; j<amount; j++){
				save = sort.indexOf(all.remove(0));
				total = total + save;
				sort.remove(save);
			}
			System.out.println(total);
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