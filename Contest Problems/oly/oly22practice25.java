import java.util.*;
import java.io.*;
public class MeetingDay{
	static class road{
		int d,w;
		public road(int d, int w) {
			this.d=d;
			this.w=w;
		}
	}
	static int[] dis1,dis2;
	static class SortbyDis1 implements Comparator<road>{
		public int compare(road a, road b) {
			return Integer.compare(dis1[a.d],dis1[b.d]);
		}
	}
	static class SortbyDis2 implements Comparator<road>{
		public int compare(road a, road b) {
			return Integer.compare(dis2[a.d],dis2[b.d]);
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), M = readInt(), X = readInt();
		List<road>[] ori = new ArrayList[N+1];
		List<road>[] opp = new ArrayList[N+1];
		for(int i = 1; i<=N; i++) {
			ori[i]=new ArrayList<road>();
			opp[i]=new ArrayList<road>();
		}
		for(int i = 0; i<M; i++) {
			int a=readInt(),b=readInt(),c=readInt();
			ori[a].add(new road(b,c));
			opp[b].add(new road(a,c));
		}
		boolean[] visited = new boolean[N+1];
		dis1 = new int[N+1];
		Arrays.fill(dis1, Integer.MAX_VALUE);
		LinkedList<road> cur = new LinkedList<road>();
		dis1[X]=0;
		cur.add(new road(X,0));
		while(!cur.isEmpty()) {
			road poll = cur.poll();
			if(!visited[poll.d]) {
				visited[poll.d]=true;
			for(road r : opp[poll.d]) {
				if(!visited[r.d]) {
					cur.add(r);
					dis1[r.d]=Math.min(dis1[r.d], dis1[poll.d]+r.w);
				}
			}
			Collections.sort(cur,new SortbyDis1());
			}
		}
		visited = new boolean[N+1];
		dis2 = new int[N+1];
		Arrays.fill(dis2, Integer.MAX_VALUE);
		dis2[X]=0;
		cur.add(new road(X,0));
		while(!cur.isEmpty()) {
			road poll = cur.poll();
			if(!visited[poll.d]) {
				visited[poll.d]=true;
			for(road r : ori[poll.d]) {
				if(!visited[r.d]) {
					cur.add(r);
					dis2[r.d]=Math.min(dis2[r.d], dis2[poll.d]+r.w);
				}
			}
			Collections.sort(cur,new SortbyDis2());
			}
		}
		int max = 0;
		for(int i = 1; i<=N; i++)max=Math.max(max,dis1[i]+dis2[i]);
//		System.out.println(Arrays.toString(dis1));
//		System.out.println(Arrays.toString(dis2));
		System.out.println(max);
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