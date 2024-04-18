import java.util.*;
import java.io.*;
public class Checklist {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
	Set<String> items = new HashSet<String>();
	int N = readInt(), M = readInt();
	for(int i = 0; i<N; i++) {
		items.add(readLine());
	}
	List<String> list = new ArrayList<String>(items);
	int total = 0;
	for(int i = 0; i<M; i++) {
		int num = readInt();
		boolean flag = true;
		for(int j = 0; j<num; j++) {
		String check = readLine();
		if(flag) {
		if(!list.contains(check)) {
			flag = false;
		}
		}
		}
		if(flag) {
			total++;
		}
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