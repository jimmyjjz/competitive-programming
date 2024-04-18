import java.util.*;
import java.io.*;
public class PursuitOfKnowledge {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), M = readInt(), T = readInt();
		List<Integer>[] tree = new ArrayList[N+1];
		int[][] store = new int[N+1][N+1];
		for(int i = 1; i<=N; i++) {
			tree[i]=new ArrayList<Integer>();
		}
		for(int i = 0; i<M; i++) {
			tree[readInt()].add(readInt());
		}
		for(int i = 1; i<=N; i++) {
			Set<Integer> next = new HashSet<Integer>();
			boolean[] valid = new boolean[N+1];
			int moves = 0;
			next.add(i);
			while(true) {
				boolean run = false;
				List<Integer> current = new ArrayList<Integer>(next);
				next.clear();
				for(int var : current) {
					if(!valid[var]) {
					run=true;
					valid[var]=true;
					List<Integer> add = new ArrayList<Integer>(tree[var]);
					for(int num : add) {
						next.add(num);
						if(store[i][num]==0) {
							store[i][num]=moves+1;
						}
						else {
						store[i][num]=Math.min(store[i][num],moves+1);
						}
					}
					}
				}
				moves++;
				if(!run) break;
			}
			}
		int Q = readInt();
		for(int i = 0; i<Q; i++) {
			int s = readInt(), e = readInt();
			System.out.println((store[s][e]==0)?"Not enough hallways!":store[s][e]*T);
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