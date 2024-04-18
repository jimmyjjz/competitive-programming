import java.util.*;
import java.io.*;
public class StudiesTree {
	public static List<Integer>[] tree;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt();
		tree = new ArrayList[N+1];
		for(int i = 1; i<=N; i++) {
			tree[i]=new ArrayList<Integer>();
		}
		for(int i = 0; i<N-1; i++) {
			int a = readInt(), b = readInt();
			tree[a].add(b);
			tree[b].add(a);
		}	
		int pa = 0, pb = 0;
			Stack<Integer> route = new Stack<Integer>();
			boolean[] valid = new boolean[N+1];
			List<List<Integer>> track = new ArrayList<List<Integer>>();
			int[] position = new int[N+1];
			route.push(1);
			while(true) {
				if(route.size()-1>pa) {
				pa=Math.max(pa, route.size()-1);
				track.clear();
				track.add(new ArrayList<Integer>(route));
				}
				else if(route.size()-1==pa) {
					track.add(new ArrayList<Integer>(route));
				}
				int save = route.peek();
				if(!valid[save]) {
					valid[save]=true;
					while(position[save]<tree[save].size()) {
						if(!valid[tree[save].get(position[save])]) {
						route.push(tree[save].get(position[save]));
						break;
						}
						position[save]++;
					}
					if(position[save]==tree[save].size()) {
						route.pop();
						if(route.isEmpty())break;
						valid[route.peek()]=false;
					}
				}
				else {
					route.pop();
					if(route.isEmpty())break;
					valid[route.peek()]=false;
				}
			}
			int fixed = track.size();
			for(int i = 0; i<fixed; i++) {
				route = new Stack<Integer>();
				valid = new boolean[N+1];
				position = new int[N+1];
				List<Integer> part = new ArrayList<Integer>(track.get(i));
				for(int num : part) {
					valid[num]=true;
				}
				valid[1]=false;
				route.push(1);
				while(true) {
					pb=Math.max(pb, route.size()-1);
					int save = route.peek();
					if(!valid[save]) {
						valid[save]=true;
						while(position[save]<tree[save].size()) {
							if(!valid[tree[save].get(position[save])]) {
							route.push(tree[save].get(position[save]));
							break;
							}
							position[save]++;
						}
						if(position[save]==tree[save].size()) {
							route.pop();
							if(route.isEmpty())break;
							valid[route.peek()]=false;
						}
					}
					else {
						route.pop();
						if(route.isEmpty())break;
						valid[route.peek()]=false;
					}
				}
			}
			System.out.println(pa+pb);
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