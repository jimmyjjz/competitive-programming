import java.util.*;
import java.io.*;
public class TheGreatSpamwayStrike {
	static class des{
		int n,v;
		public des(int n, int v) {
			this.n=n;
			this.v=v;
		}
	}
	static class SortbyV implements Comparator<des>{
		public int compare(des a, des b) {
			return Integer.compare(a.v,b.v);
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		List<des>[] adj = new ArrayList[N+1];
		for(int i = 0; i<=N; i++)adj[i] = new ArrayList<des>();
		for(int i = 0; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int w = Integer.parseInt(st.nextToken()), n = Integer.parseInt(st.nextToken());
			for(int j = 0; j<n; j++)adj[i].add(new des(Integer.parseInt(st.nextToken()),w+10));
		}
		PriorityQueue<des> pq = new PriorityQueue<des>(new SortbyV());
		pq.add(new des(0,0));
		int[] v = new int[N+1];
		Arrays.fill(v, -1);
		while(!pq.isEmpty()) {
			des d = pq.poll();
			if(v[d.n]==-1) {
				v[d.n]=d.v;
				for(des node : adj[d.n])pq.add(new des(node.n,node.v+d.v));
			}
		}
		int max = 0;
		for(int i = 1; i<=N; i++) {
			pq = new PriorityQueue<des>(new SortbyV());
			pq.add(new des(i,v[i]));
			int[] v2 = new int[N+1];
			Arrays.fill(v2, -1);
			while(!pq.isEmpty()) {
				des d = pq.poll();
				if(v2[d.n]==-1) {
					v2[d.n]=d.v;
					if(d.n==0)break;
					for(des node : adj[d.n])pq.add(new des(node.n,node.v+d.v));
				}
			}
			max=Math.max(max,v2[0]);
		}
		System.out.println(max);
	}
}