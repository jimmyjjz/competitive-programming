import java.util.*;
import java.io.*;
public class TravellingSalesman {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), M = readInt();
		List<Integer>[] tree = new ArrayList[N+1];
		for(int i = 1; i<=N; i++) {
			tree[i] = new ArrayList<Integer>();
		}
		for(int i = 0; i<M; i++) {
			int a = readInt(), b = readInt();
			tree[a].add(b);
			tree[b].add(a);
		}
		int K = readInt();
		Set<Integer> spread = new HashSet<Integer>();
		for(int i = 0; i<K; i++) {
			spread.add(readInt());
		}
		boolean[] valid = new boolean[N+1];
		int hour = 0;
		while(true) {
			List<Integer> current = new ArrayList<Integer>(spread);
			spread.clear();
			int fixed = current.size();
			for(int i = 0; i<fixed; i++) {
				int get = current.get(i);
				if(!valid[get]) {
					valid[get]=true;
					N--;
					if(N==0) {
						System.out.println(hour);
						return;
					}
					List<Integer> path = new ArrayList<Integer>(tree[get]);
					int size = path.size(); 
					for(int j = 0; j<size; j++) {
						spread.add(path.get(j));
					}
				}
			}
			hour++;
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