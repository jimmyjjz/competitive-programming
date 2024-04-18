import java.util.*;
import java.io.*;
public class Switch{
	static class stat{
		int m,l;
		public stat(int m, int l) {
			this.m=m;
			this.l=l;
		}
	}
	static int consecRem(int l, int spot) {
		int remove = 0, cnt = 1;
		for(int i = spot+1; (l&(1<<i))!=0&&i<25; i++) {
			remove|=1<<i;
			cnt++;
		}
		for(int i = spot-1; (l&(1<<i))!=0&&i>=0; i--) {
			remove|=1<<i;
			cnt++;
		}
		if(cnt>=4)return l-remove;
		return l|(1<<spot);
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), start = 0;
		for(int i = 0; i<N; i++)if(readInt()!=0)start|=1<<i;
		Queue<stat> q = new LinkedList<stat>();
		q.add(new stat(0,start));
		boolean[] visited = new boolean[65000000];
		while(!q.isEmpty()) {
			stat poll = q.poll();
			if(!visited[poll.l]){
				visited[poll.l]=true;
				for(int i = 0; i<N; i++) {
					if(((1<<i)&poll.l)==0) {
						int checked = consecRem(poll.l,i);
						if(checked==0) {
							System.out.println(poll.m+1);
							return;
						}
						if(!visited[checked])q.add(new stat(poll.m+1,checked));
					}
				}
			}
		}
		System.out.println(0);
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