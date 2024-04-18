import java.util.*;
import java.io.*;
public class CountingLiars{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt();
		LinkedList<Integer> down = new LinkedList<Integer>(), up = new LinkedList<Integer>();
		for(int i = 0; i<N; i++) {
			if(next().equals("G"))up.add(readInt());
			else down.add(readInt());
		}
		Collections.sort(up);
		Collections.sort(down);
		int max = 0;
		int size = down.size(), cur = size;
		for(int i = 0; i<size; i++){
			int back = down.removeFirst();
			while(!up.isEmpty()&&up.peek()<=back){
			up.pop();
			cur++;
		}
		max=Math.max(cur-i,max);
		}
		System.out.println(N-max);
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