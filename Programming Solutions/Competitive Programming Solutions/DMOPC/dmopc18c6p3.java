import java.util.*;
import java.io.*;
public class WishUponAStar {
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
		boolean[] valid = new boolean[N+1];
		int parts = 0;
		for(int i = 1; i<=N; i++) {
		if(valid[i])continue;
		parts++;
		Stack<Integer> current = new Stack<Integer>();
		current.push(i);
		while(true) {
			int peek = current.peek();
			if(!valid[peek]) {
				valid[peek]=true;
				boolean found = false;
				for(int n : tree[peek]) {
					if(!valid[n]) {
						found = true;
						current.push(n);
						break;
					}
				}
				if(!found) {
					current.pop();
					if(current.isEmpty())break;
					valid[current.peek()]=false;
				}
			}
			else {
				current.pop();
				if(current.isEmpty())break;
				valid[current.peek()]=false;
				break;
			}
		}
		}
		System.out.println((M==N-parts||M==N-parts+1)? "YES":"NO");
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