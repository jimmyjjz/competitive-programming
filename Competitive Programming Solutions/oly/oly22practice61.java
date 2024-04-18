import java.util.*;
import java.io.*;
public class GiftBox{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), cnt = 0;
		Stack<Integer> gift = new Stack<Integer>(), boxes = new Stack<Integer>();
		for(int i = 0; i<N; i++)gift.add(readInt());
		for(int i = 0; i<N; i++)boxes.add(readInt());
		Collections.sort(gift);
		Collections.sort(boxes);
		while(!gift.isEmpty()&&!boxes.isEmpty()) {
			if(boxes.peek()>=gift.peek()) {
				boxes.pop();
				gift.pop();
				cnt++;
			}
			else gift.pop();
		}
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