import java.util.*;
import java.io.*;
public class WhoIsTaller {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), M = readInt();
		List<Integer>[] tree = new ArrayList[N+1];
		for(int i = 1; i<=N; i++) {
			tree[i]=new ArrayList<Integer>();
		}
		boolean[][] valid = new boolean[N+1][2];
		for(int i = 0; i<M; i++) {
			tree[readInt()].add(readInt());
		}
		//System.out.println(Arrays.toString(tree));
		int big = readInt(), small = readInt();
		List<Integer> current = new ArrayList<Integer>();
		current.add(big);
			for(int i = 0; i<current.size(); i++) {
				if(!valid[current.get(i)][0]){
					valid[current.get(i)][0] = true;
					List<Integer> insert = new ArrayList<Integer>(tree[current.get(i)]);
					if(insert.contains(small)) {
						System.out.println("yes");
						return;
					}
					for(int j : insert) current.add(j);
				}
			}
			current = new ArrayList<Integer>();
			current.add(small);
				for(int i = 0; i<current.size(); i++) {
					if(!valid[current.get(i)][1]){
						valid[current.get(i)][1] = true;
						List<Integer> insert = new ArrayList<Integer>(tree[current.get(i)]);
						if(insert.contains(big)) {
							System.out.println("no");
							return;
						}
						for(int j : insert) current.add(j);
					}
				}
		System.out.println("unknown");
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