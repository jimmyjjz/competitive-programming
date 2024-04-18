import java.util.*;
import java.io.*;
public class Firehose {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static List<Integer> addresses = new ArrayList<Integer>();
	static int hydrants, N;
	static boolean works(int hose) {
		int min = Integer.MAX_VALUE;
		for(int i = 0; i<N; i++) {
			int cur = addresses.get(i)+hose, cnt = 1;
			for(int j = i+1; j<i+N; j++) {
				if(Math.abs(cur-addresses.get(j))>hose) {
					cur=addresses.get(j)+hose;
					cnt++;
				}
			}
			min=Math.min(min,cnt);
		}
		return min<=hydrants;
	}
	public static void main(String[] args) throws IOException{
		N = readInt();
		for(int i = 0; i<N; i++)addresses.add(readInt());
		for(int i = 0; i<N; i++)addresses.add(addresses.get(i)+1000000);
		Collections.sort(addresses);
		hydrants = readInt();
		int l = 0, h = 1000000;
		while(l<=h) {
			int m=(l+h)/2;
			if(works(m))h=m-1;
			else l=m+1;
		}
		System.out.println(h+1);
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