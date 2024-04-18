import java.util.*;
import java.io.*;
public class CarnivalPhantasm{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static class stall{
		int i,d;
		public stall(int i, int d) {
			this.i=i;
			this.d=d;
		}
	}
	static class Sortbyd implements Comparator<stall>{
		public int compare(stall a, stall b) {
			return Integer.compare(a.d,b.d);
		}
	}
	public static void main(String[] args) throws IOException{
		int N = readInt(), S = readInt();
		TreeSet<stall>[] apples = new TreeSet[100];
		for(int i = 0; i<100; i++)apples[i]=new TreeSet<stall>(new Sortbyd());
		stall[] address = new stall[N+1];
		Set<Integer>[] link = new HashSet[N+1];
		for(int i = 1; i<=N; i++)link[i]=new HashSet<Integer>();
		for(int i = 1; i<=N; i++)address[i]=new stall(i,readInt());
		for(int i = 0; i<S; i++) {
			int a = readInt(), b = readInt();
			if(!link[a].contains(b))apples[b].add(address[a]);
			link[a].add(b);
		}
		int Q = readInt();
		for(int i = 0; i<Q; i++) {
			char c = readCharacter();
			if(c=='A') {
				int a = readInt(), b = readInt();
				if(!link[a].contains(b))apples[b].add(address[a]);
				link[a].add(b);
			}
			else if(c=='S') {
				int a = readInt(), b = readInt();
				if(link[a].contains(b))apples[b].remove(address[a]);
				link[a].remove(b);
			}
			else if(c=='E') {
				int a = readInt(), b = readInt();
				for(int v : new HashSet<Integer>(link[a])) {
					link[a].remove(v);
					apples[v].remove(address[a]);
				}
				address[a].d=b;
			}
			else {
				try {
				System.out.println(apples[readInt()].first().i);
				}catch(Exception e) {System.out.println("-1");}
			}
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