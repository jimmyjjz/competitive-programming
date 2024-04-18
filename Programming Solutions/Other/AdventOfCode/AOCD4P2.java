import java.util.*;
import java.io.*;
public class AOCD4P2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int yeah = 192;
		int[] cards = new int[yeah];
		Arrays.fill(cards, 1);
		String[] sa = new String[yeah];
		for(int i = 0; i<yeah; i++)sa[i]=readLine();
		for(int i = 0; i<yeah; i++) {
			st = new StringTokenizer(sa[i],":");
			st.nextToken();
			st = new StringTokenizer(st.nextToken(),"|");
			StringTokenizer st2 = new StringTokenizer(st.nextToken()," ");
			List<String> w = new ArrayList<String>(), n = new ArrayList<String>();
			while(st2.hasMoreTokens())w.add(st2.nextToken());
			st2 = new StringTokenizer(st.nextToken()," ");
			while(st2.hasMoreTokens())n.add(st2.nextToken());
			//brute force check
			int v=0;
			for(String s1 : w) {
				for(String s2 : n)if(s1.equals(s2)) {
					cards[i+(++v)]+=cards[i];
					break;
				}
			}
		}
		int result=0;
		for(int i = 0; i<yeah; i++)result+=cards[i];
		System.out.println(result);
	}
	static String next() throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}

	static long readLong() throws IOException {
		return Long.parseLong(next());
	}

	static int readInt() throws IOException {
		return Integer.parseInt(next());
	}

	static double readDouble() throws IOException {
		return Double.parseDouble(next());
	}

	static char readCharacter() throws IOException {
		return next().charAt(0);
	}

	static String readLine() throws IOException {
		return br.readLine().trim();
	}
}
