import java.util.*;
import java.io.*;
public class GachaLuck{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), K = readInt(), total = 0;
		String s = readLine();
		Stack<Integer> counts = new Stack<Integer>();
		int cnt = 0;
		for(int i = 0; i<N; i++) {
			if(s.charAt(i)=='0')cnt++;
			else {
				counts.add(cnt);
				cnt=0;
			}
		}
		if(s.charAt(N-1)=='0')counts.add(cnt);
		Collections.sort(counts);
		K=Math.min(K, counts.size());
		while(K--!=0)total+=counts.pop();
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