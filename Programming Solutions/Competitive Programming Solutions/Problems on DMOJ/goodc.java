import java.util.*;
import java.io.*;
public class GoodStrategy{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), M = readInt(), weight[] = new int[N],solved = 0;
		TreeSet<Integer> Easy = new TreeSet<Integer>((a,b)->-Integer.compare(weight[a],weight[b])==0?Integer.compare(a,b):-Integer.compare(weight[a],weight[b]));
		TreeSet<Integer> Hard = new TreeSet<Integer>((a,b)->Integer.compare(weight[a],weight[b])==0?-Integer.compare(a,b):Integer.compare(weight[a],weight[b]));
		for(int i = 0; i<N; i++) {
			Easy.add(i);
			Hard.add(i);
		}
		for(int i = 0; i<M; i++) {
			int t = readInt(), p = readInt()-1;
			if(t==1) {
				solved++;
				Easy.remove(p);
				Hard.remove(p);
				weight[p]=-1;
			}
			if(solved==N) {
				System.out.println("Make noise");
				continue;
			}
			if(weight[p]!=-1) {
				Easy.remove(p);
				Hard.remove(p);
				weight[p]++;
				Easy.add(p);
				Hard.add(p);
			}
			System.out.println((Easy.first()+1)+" "+(Hard.first()+1));
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