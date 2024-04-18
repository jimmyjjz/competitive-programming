import java.util.*;
import java.io.*;
public class villages{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt();
		double smallest=Integer.MAX_VALUE;
		List<Double> pos = new ArrayList<Double>();
		for(int i = 0; i<N; i++) {
			pos.add((double) readInt());
		}
		Collections.sort(pos);
		for(int i = 1; i<pos.size()-1; i++) {
			smallest=Math.min(smallest,((((pos.get(i+1)+pos.get(i))/2.0)-pos.get(i))+(pos.get(i)-((pos.get(i-1)+pos.get(i))/2.0))));
		}
		int out = (int)smallest;
		System.out.print(out);
		if(smallest%1==0) {
			System.out.print(".0");
		}
		else {
			System.out.print(".5");
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