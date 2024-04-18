import java.util.*;
import java.io.*;
public class AOCD4P1 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int sum = 0;//10,25
		//5,8
		for(int i = 0; i<192; i++) {//192
			String s = readLine();
			st = new StringTokenizer(s,":");
			st.nextToken();
			st = new StringTokenizer(st.nextToken(),"|");
			StringTokenizer st2 = new StringTokenizer(st.nextToken()," ");
			List<String> w = new ArrayList<String>(), n = new ArrayList<String>();
			while(st2.hasMoreTokens())w.add(st2.nextToken());
			st2 = new StringTokenizer(st.nextToken()," ");
			while(st2.hasMoreTokens())n.add(st2.nextToken());
			//brute force check
			int v=-1;
			for(String s1 : w) {
				for(String s2 : n)if(s1.equals(s2)) {
					v++;
					break;
				}
			}
			if(v!=-1)sum+=(1<<v);
		}
		System.out.println(sum);
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