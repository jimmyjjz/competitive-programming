import java.util.*;
import java.io.*;
public class CanShahirEvenGetThere {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), M = readInt(), A = readInt(), B = readInt();
		Map<Integer,List<Integer>> bfs = new HashMap<Integer,List<Integer>>();
		for(int i = 1; i<=N; i++) {
			bfs.put(i, new ArrayList<Integer>());
		}
		for(int i = 0; i<M; i++) {
			int x = readInt(), y = readInt();
			if(bfs.get(x) == null) {
				bfs.put(x,new ArrayList<Integer>());
			}
			List<Integer> a = new ArrayList<Integer>(bfs.get(x));
				a.add(y);
				bfs.put(x,a);
			if(bfs.get(y) == null) {
				bfs.put(y,new ArrayList<Integer>());
			}
			List<Integer> b = new ArrayList<Integer>(bfs.get(y));
				b.add(x);
				bfs.put(y,b);
		}
		if(A==B) {
			System.out.println("GO SHAHIR!");
			return;
		}
		Set<Integer> encountered = new HashSet<Integer>();
		List<Integer> current = new ArrayList<Integer>();
		current.add(B);
		boolean end = true;
		while(end) {
			end = false;
			for(int j = 0; j<current.size(); j++) {
				if(!encountered.contains(current.get(j))) {
					encountered.add(current.get(j));
					Set<Integer> in = new HashSet<Integer>(current);
					List<Integer> send = new ArrayList<Integer>(bfs.get(current.get(j)));
					for(int k = 0; k<send.size(); k++) {
						if(send.get(k) == A) {
							System.out.println("GO SHAHIR!");
							return;
						}
						in.add(send.get(k));
					}
					current = new ArrayList<Integer>(in);
					j=-1;
					end = true;
				}
			}
		}
		System.out.println("NO SHAHIR!");
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