import java.util.*;
import java.io.*;
public class ColourfulMarbles{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), K = readInt();
		Map<Integer,Integer> UniCnt = new HashMap<Integer,Integer>();
		for(int i = 0; i<N; i++) {
			int in = readInt();
			if(UniCnt.get(in)==null)UniCnt.put(in,0);
			UniCnt.put(in,UniCnt.get(in)+1);
		}
		List<Integer> sorted = new ArrayList<Integer>(UniCnt.values());
		Collections.sort(sorted);
		Collections.reverse(sorted);
		//System.out.println(sorted);
		int cnt = 0;
		for(int i = sorted.size()-1; i>=K; i--)cnt+=sorted.get(i);
		System.out.println(cnt);
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