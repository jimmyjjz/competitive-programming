import java.util.*;
import java.io.*;
public class ANoisyClass {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt()+1, M = readInt();
		List<Integer>[] tree = new ArrayList[N];
		List<Integer>[] req = new ArrayList[N];
		for(int i = 0; i<N; i++) {
			tree[i]=new ArrayList<Integer>();
			req[i]=new ArrayList<Integer>();
		}
		int[] pre = new int[N];
		for(int i = 0; i<M; i++) {
			int x = readInt(), y = readInt();
			if(x==0&&y==0)break;
			tree[x].add(y);
			req[y].add(x);
			pre[x]=Math.max(1, pre[x]);
			pre[y]=2;
		}
		boolean[] valid = new boolean[N];
		List<Integer> order = new ArrayList<Integer>();
		LinkedList<Integer> open = new LinkedList<Integer>();
		int c = 0;
		for(int i = 1; i<N; i++) {
			if(pre[i]!=0) c++;
			if(pre[i]==1) {
				open.add(i);
			}
		}
		while(!open.isEmpty()) {
		int poll = open.poll();
		order.add(poll);
		if(!valid[poll]) {
			valid[poll]=true;
			for(int n : tree[poll]) {
				if(req[n].size()==1) {
				if(!valid[n] && req[n].get(0)==poll) {
					open.add(n);
				}
				}
				else if(req[n].size()>1) req[n].remove(req[n].indexOf(poll));
			}
		}
		}
		if(order.size()==c) {
			System.out.print("Y");
		}
		else {
			System.out.println("N");
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