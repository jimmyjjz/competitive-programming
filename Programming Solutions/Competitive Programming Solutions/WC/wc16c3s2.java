import java.util.*;
import java.io.*;
public class TrainingRegimen {
	static class route{
		int x,y,l;
		public route(int x, int y, int l) {
			this.x=x;
			this.y=y;
			this.l=l;
		}
	}
	static class SortByLevel implements Comparator<route>{
		public int compare(route a, route b) {
			return -Integer.compare(a.l,b.l);
		}
	}
	public static int findrep(int[][] disjoint, int n) {
		while(disjoint[n][0]!=n)n=disjoint[n][0];
		return n;
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), M = readInt();
		int[][] disjoint = new int[N+1][3];
		for(int i = 1; i<=N; i++) {
			disjoint[i][0]=i;
			disjoint[i][1]=1;
			disjoint[i][2]=readInt();
		}
		Stack<route> paths = new Stack<route>();
		for(int i = 0; i<M; i++)paths.add(new route(readInt(), readInt(), readInt()));
		Collections.sort(paths, new SortByLevel());
		int pre = 1;
		long time = 0, train = disjoint[1][2];
		while(!paths.isEmpty()) {
			route cur = paths.pop();
			if(pre!=cur.l) {
				train=disjoint[findrep(disjoint,1)][2];
				if(findrep(disjoint,1)==findrep(disjoint,N)) {
					System.out.println(time);
					return;
				}
				time+=(cur.l-pre)*train;
			}
			int x = findrep(disjoint,cur.x), y = findrep(disjoint,cur.y);
			if(x!=y) {
				if(disjoint[x][1]>=disjoint[y][1]) {
					disjoint[y][0]=x;
					disjoint[x][1]++;
					disjoint[x][2]=Math.min(disjoint[x][2], disjoint[y][2]);
				}
				else {
					disjoint[x][0]=y;
					disjoint[y][1]++;
					disjoint[y][2]=Math.min(disjoint[x][2], disjoint[y][2]);
				}
			}
			pre=cur.l;
		}
		if(findrep(disjoint,1)==findrep(disjoint,N)) {
			
		}
		System.out.println((findrep(disjoint,1)==findrep(disjoint,N))?time:"-1");
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