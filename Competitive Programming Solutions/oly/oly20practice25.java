import java.util.*;
import java.io.*;
public class hackathon {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		StringTokenizer split = new StringTokenizer(readLine(), " ");
		int q = Integer.parseInt(split.nextToken());
		int size = Integer.parseInt(split.nextToken());
		int a = 0;
		int b = 0;
		int c = 0;
		int save = 0;
		int count = 0;
		int index = 0;
		for(int i = 0; i<size; i++) {
			StringTokenizer cut = new StringTokenizer(readLine(), " ");
			a = Integer.parseInt(cut.nextToken());
			b = Integer.parseInt(cut.nextToken());
			c = Integer.parseInt(cut.nextToken());
			save = q;
			while(save > 0) {
				index++;
				save = save - a;
				count++;
				if(save <= 0) {
					break;
				}
				if(index % b == 0) {
					count = count + c;
				}
			}
			System.out.println(count);
			count = 0;
			index = 0;
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
	static char readCharacter () throws IOException {
		return next().charAt(0);
	}
	static String readLine () throws IOException {
		return br.readLine().trim();
	}
}