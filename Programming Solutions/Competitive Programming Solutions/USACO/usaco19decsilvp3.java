import java.util.*;
import java.io.*;
public class MilkVisit {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), M = readInt();
		String milk = readLine();
		List<Integer>[] tree = new ArrayList[N+1];
		for(int i = 0; i<=N; i++) tree[i]=new ArrayList<Integer>();
		for(int i = 0; i<N-1; i++) {
			int a = readInt(), b = readInt();
			tree[a].add(b);
			tree[b].add(a);
		}
		boolean[] valid = new boolean[N+1];
		int[] value = new int[N+1];
		List<Integer> current = new ArrayList<Integer>();
		int cnt = 0;
		for(int i = 0; i<N; i++) {
			if(!valid[i]) {
				valid[i]=true;
				current.add(i);
				while(!current.isEmpty()) {
					int poll = current.remove(0);
					valid[poll]=true;
					value[poll]=cnt;
					for(int n : tree[poll+1]) {
						if(!valid[n-1]&&milk.charAt(n-1)==milk.charAt(i)) {
							current.add(n-1);
						}
					}
				}
				cnt++;
			}
		}
		for(int i = 0; i<M; i++) {
			int a = readInt()-1, b = readInt()-1;
			System.out.print(((milk.charAt(a)+"").equals(next())||milk.charAt(a)!=milk.charAt(b)||value[a]!=value[b])?"1":"0");
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