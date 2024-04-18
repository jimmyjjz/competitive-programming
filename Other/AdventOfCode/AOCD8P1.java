import java.util.*;
import java.io.*;
public class AOCD8P1 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static int hash(String s) {
		return (s.charAt(0)-'A')*31+(s.charAt(1)-'A')*31*31+(s.charAt(2)-'A')*31*31*31;
	}
	public static void main(String[] args) throws IOException {
		String d = readLine();
		int[][] network = new int[769576][2];
		readLine();
		for(int i = 0; i<714; i++) {
			st = new StringTokenizer(readLine().replaceAll("[=(),]","")," ");
			int temp=hash(st.nextToken());
			network[temp][0]=hash(st.nextToken());
			network[temp][1]=hash(st.nextToken());
		}
		int cur=0,cnt=0;
		while(cur!=769575) {
			if(d.charAt(cnt%d.length())=='R')cur=network[cur][1];
			else cur=network[cur][0];
			cnt++;
		}
		System.out.println(cnt);
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