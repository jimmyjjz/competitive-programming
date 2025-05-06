import java.util.*;
import java.io.*;
public class IsItATree {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		Map<Integer,List<Integer>> connect = new HashMap<Integer,List<Integer>>();
		List<Integer> roots = new ArrayList<Integer>();
		int[][] grid = new int[4][4];
		for(int i = 0; i<4; i++) {
			for(int j = 0; j<4; j++) {
				grid[i][j] = readInt();
				if(grid[i][j] == 1) {
					if(connect.get(i) == null) {
						List<Integer> save = new ArrayList<Integer>();
						roots.add(i);
						connect.put(i,save);
					}
					List<Integer> save = new ArrayList<Integer>(connect.get(i));
					save.add(j);
					connect.put(i,save);
				}
			}
		}
		int sum = 0;
		for(int i = 0; i<roots.size(); i++) {
			sum+=connect.get(roots.get(i)).size();
		}
		if(sum/2 == roots.size()-1) {
			System.out.println("Yes");
		}
		else {
			System.out.println("No");
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