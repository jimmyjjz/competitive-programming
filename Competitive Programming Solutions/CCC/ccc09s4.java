import java.util.*;
import java.io.*;
public class ShopAndShip {
	public static int[] ship;
	static class SortbyShip implements Comparator<Integer>{
		public int compare(Integer a, Integer b) {
			return Integer.compare(ship[a],ship[b]);
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), T = readInt();
		ship = new int[N+1];
		Arrays.fill(ship, Integer.MAX_VALUE);
		int[][] matrix = new int[N+1][N+1];
		for(int i = 1; i<=N; i++) {
			for(int j = 1; j<=N; j++) {
				matrix[i][j]=-1;
			}
		}
		for(int i = 0; i<T; i++){
			int x = readInt(), y = readInt(), c = readInt();
			matrix[x][y]=c;
			matrix[y][x]=c;
		}
		Map<Integer, Integer> locations = new HashMap<Integer, Integer>();
		int K = readInt();
		for(int i = 0; i<K; i++)locations.put(readInt(), readInt());
		LinkedList<Integer> current = new LinkedList<Integer>();
		ship[readInt()]=0;
		for(int i = 1; i<=N; i++)current.add(i);
		while(!current.isEmpty()){
			Collections.sort(current, new SortbyShip());
			int front = current.poll();
			for(int i = 1; i<=N; i++) {
				if(matrix[front][i]!=-1)ship[i]=Math.min(ship[i],ship[front]+matrix[front][i]);
			}
		}
		int min = Integer.MAX_VALUE;
		for(int dex : locations.keySet())min = Math.min(min,ship[dex]+locations.get(dex));
		System.out.println(min);
		//System.out.println(Arrays.toString(ship));
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