import java.util.*;
import java.io.*;
public class teen {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int size = 11;
		List<Integer>[] tree = new ArrayList[size];
		List<Integer>[] req = new ArrayList[size];
		for(int i = 0; i<size; i++) {
			tree[i]=new ArrayList<Integer>();
			req[i]=new ArrayList<Integer>();
		}
		int[] pre = new int[size];
		StringTokenizer split = new StringTokenizer("1 7,1 4,2 1,3 4,3 5",",");
		int x=0,y=0;
		while(split.hasMoreTokens()) {
		StringTokenizer cut = new StringTokenizer(split.nextToken()," ");
		x=Integer.parseInt(cut.nextToken());
		y=Integer.parseInt(cut.nextToken());
		tree[x].add(y);
		req[y].add(x);
		pre[x]=Math.max(1, pre[x]);
		pre[y]=2;
		}
		pre[6]=1;
		while(true) {
			x = readInt();
			y = readInt();
			if(x==0&&y==0)break;
			tree[x].add(y);
			req[y].add(x);
			pre[x]=Math.max(1, pre[x]);
			pre[y]=2;
		}
		//System.out.println(Arrays.toString(pre));
		//System.out.println(Arrays.toString(tree));
		//System.out.println(Arrays.toString(req));
		boolean[] valid = new boolean[size];
		List<Integer> order = new ArrayList<Integer>();
		LinkedList<Integer> open = new LinkedList<Integer>();
		int N = 0;
		for(int i = 1; i<size; i++) {
			if(pre[i]!=0) N++;
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
		Collections.sort(open);
		}
		if(order.size()==N) {
		for(int n : order) {
			System.out.print(n+" ");
		}
		}
		else {
			System.out.println("Cannot complete these tasks. Going to bed.");
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