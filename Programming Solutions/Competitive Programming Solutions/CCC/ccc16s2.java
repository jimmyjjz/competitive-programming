import java.util.*;
import java.io.*;
public class TandemBike{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int type = readInt(), N = readInt(), sum = 0;
		List<Integer> dmojistan = new ArrayList<Integer>(), pegland = new ArrayList<Integer>();
		for(int i = 0; i<N; i++)dmojistan.add(readInt());
		if(type==1)Collections.sort(dmojistan);
		else Collections.sort(dmojistan,(a,b)->-Integer.compare(a,b));
		for(int i = 0; i<N; i++)pegland.add(readInt());
		Collections.sort(pegland);
		for(int i = 0; i<N; i++)sum+=Math.max(dmojistan.get(i), pegland.get(i));
		System.out.println(sum);
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