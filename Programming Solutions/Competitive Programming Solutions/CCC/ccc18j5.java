import java.util.*;
import java.io.*;
public class ChooseYourOwnPath {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		Map<Integer,List<Integer>> adj = new HashMap<Integer,List<Integer>>();
		int N = readInt();
		boolean[] valid = new boolean[N+1];
		valid[0] = true;
		for(int i = 1; i<=N; i++) {
			int M = readInt();
			List<Integer> insert = new ArrayList<Integer>();
			for(int j = 0; j<M; j++) {
				insert.add(readInt());
			}
			if(M == 0) {
				insert.add(0);
			}
			adj.put(i,insert);
		}
		Set<Integer> store = new HashSet<Integer>(adj.get(1));
		int cnt = 1, shortest = 0;
		boolean flag = false, tin = true;
		while(tin) {
			cnt++;
			tin = false;
			List<Integer> current = new ArrayList<Integer>(store);
			store.clear();
			for(int i = 0; i<current.size(); i++) {
				if(!valid[current.get(i)]) {
					tin = true;
					valid[current.get(i)] = true;
					List<Integer> insert = new ArrayList<Integer>(adj.get(current.get(i)));
					for(int j = 0; j<insert.size(); j++) {
						if(insert.get(j) == 0 && !flag) {
							shortest = cnt;
							flag = true;
						}
						store.add(insert.get(j));
					}
				}
			}
		}
		valid[1]=true;
		for(int i = 0; i<=N; i++) {
			if(!valid[i]) {
				System.out.println("N");
				System.out.println(shortest);
				return;
			}
		}
		System.out.println("Y");
		System.out.println(shortest);
		return;
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