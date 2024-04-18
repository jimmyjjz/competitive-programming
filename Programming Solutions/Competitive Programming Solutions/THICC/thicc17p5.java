import java.util.*;
import java.io.*;
public class Smarties{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), K = readInt(), fre[] = new int[1000001], size = 0;
		long total = (((long)N*(long)N)+(long)N)/2L;
		Queue<Integer> pile = new LinkedList<Integer>();
		for(int i = 0; i<N; i++) {
			int in = readInt();
			pile.add(in);
			if(fre[in]==0)size++;
			fre[in]++;
			while(size==K) {
				int poll = pile.poll();
				fre[poll]--;
				if(fre[poll]==0)size--;
			}
			total-=pile.size();
		}
		System.out.println(total);
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