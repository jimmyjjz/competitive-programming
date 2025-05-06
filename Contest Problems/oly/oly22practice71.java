import java.util.*;
import java.io.*;
public class Diversity{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), K = readInt(), max = 0;
		Queue<Integer> q  = new LinkedList<Integer>();
		Map<Integer,Integer> fre = new HashMap<Integer,Integer>();
		for(int i = 0; i<N; i++) {
			if(i-K>=0) {
				int poll = q.poll();
				if(fre.get(poll)==1)fre.remove(poll);
				else fre.put(poll, fre.get(poll)-1);
			}
			int add = readInt();
			q.add(add);
			if(fre.containsKey(add))fre.put(add, fre.get(add)+1);
			else fre.put(add, 1);
			max=Math.max(max,fre.size());
		}
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