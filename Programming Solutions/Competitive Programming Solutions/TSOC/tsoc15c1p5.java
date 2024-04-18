import java.util.*;
import java.io.*;
public class GiantAnts {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), M = readInt();
		List<Integer>[] tree = new ArrayList[N+1];
		for(int i = 1; i<=N; i++) {
			tree[i]=new ArrayList<Integer>();
		}
		for(int i = 0; i<M; i++) {
			int a = readInt(), b = readInt();
			tree[a].add(b);
			tree[b].add(a);
		}
		Set<Integer> spread = new HashSet<Integer>();
		boolean[] ants = new boolean[N+1];
		int W = readInt();
		for(int i = 0; i<W; i++) {
			int in = readInt();
			ants[in]=true;
			spread.add(in);
		}
		boolean[] valid = new boolean[N+1];
		int cnt = 0;
		Set<Integer> round = new HashSet<Integer>();
		round.add(1);
		boolean noend = true;
		while(noend){
			noend = false;
			cnt++;
			List<Integer> current = new ArrayList<Integer>(round);
			round.clear();
			int fixed = current.size();
			for(int i = 0; i<fixed; i++) {
				if(!valid[current.get(i)]&&!ants[current.get(i)]) {
					//System.out.println(current.get(i));
					noend = true;
					valid[current.get(i)]=true;
					List<Integer> insert = new ArrayList<Integer>(tree[current.get(i)]);
					int size = insert.size();
					for(int j = 0; j<size; j++) {
						if(insert.get(j) == N) {
							System.out.println(cnt);
							return;
						}
						round.add(insert.get(j));
					}
				}
			}
			if(cnt%4==0) {
				int size = spread.size();
				List<Integer> convert = new ArrayList<Integer>(spread);
				for(int j = 0; j<size; j++) {
					List<Integer> insert = new ArrayList<Integer>(tree[convert.get(j)]);
					fixed = insert.size();
					for(int k = 0; k<fixed; k++) {
						spread.add(insert.get(k));
						ants[insert.get(k)] = true;
					}
				}
			}
			if(ants[N]) {
				System.out.println("sacrifice bobhob314");
				return;
			}
		}
		System.out.println("sacrifice bobhob314");
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