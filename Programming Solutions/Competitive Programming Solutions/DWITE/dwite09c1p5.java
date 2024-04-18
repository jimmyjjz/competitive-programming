import java.util.*;
import java.io.*;
public class RunningInCircles {
	public static List<Integer> all = new ArrayList<Integer>();
	public static void allpath(List<Integer>[] tree,int[] valid, int cnt, int now) {
		if(valid[now] == 0) {
			valid[now]=cnt;
			int fixed = tree[now].size();
			for(int i = 0; i<fixed; i++) {
				allpath(tree,valid,cnt+1,tree[now].get(i));
			}
			valid[now]=0;
		}
		else {
			all.add(cnt-valid[now]);
			return;
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		for(int i = 0; i<5; i++) {
			all.clear();
			List<Integer>[] tree = new ArrayList[101];
			for(int j = 1; j<101; j++) {
				tree[j] = new ArrayList<Integer>();
			}
			int N = readInt();
			for(int j = 0; j<N; j++) {
				tree[readInt()].add(readInt());
			}
			allpath(tree,new int[101],0,1);
			System.out.println(Collections.max(all));
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