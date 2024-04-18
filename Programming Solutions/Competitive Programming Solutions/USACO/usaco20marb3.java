import java.util.*;
import java.io.*;
public class CowntactTracing{
	static class event{
		int t,a,b;
		event(int t, int a, int b){
			this.t=t;
			this.a=a;
			this.b=b;
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), T = readInt(), min = Integer.MAX_VALUE, max = -Integer.MAX_VALUE, cnt = 0;
		boolean[] infected = new boolean[N+1];
		String s = readLine();
		for(int i = 1; i<=N; i++)infected[i]=s.charAt(i-1)=='1'?true:false;
		List<event> events = new ArrayList<event>();
		for(int i = 0; i<T; i++)events.add(new event(readInt(), readInt(), readInt()));
		Collections.sort(events, (a,b)->Integer.compare(a.t,b.t));
		for(int i = 1; i<=N; i++) {
			boolean yes = false;
			for(int j = 0; j<=T; j++) {
				boolean[] curInfected = new boolean[N+1];
				curInfected[i]=true;
				int shake[] = new int[N+1];
				for(event e : events) {
					if(curInfected[e.a])shake[e.a]++;
					if(curInfected[e.b])shake[e.b]++;
					if(curInfected[e.a]&&shake[e.a]<=j)curInfected[e.b]=true;
					if(curInfected[e.b]&&shake[e.b]<=j)curInfected[e.a]=true;
				}
				if(Arrays.equals(infected, curInfected)) {
					min=Math.min(j, min);
					max=Math.max(j, max);
					yes=true;
				}
			}
			if(yes)cnt++;
		}
		System.out.println(cnt+" "+min+" "+(max==T?"Infinity":max));
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