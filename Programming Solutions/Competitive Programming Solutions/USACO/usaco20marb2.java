import java.util.*;
import java.io.*;
public class SocialDistancingII{
	static class stat{
		int i;
		boolean infected;
		stat(int i, boolean infected){
			this.i=i;
			this.infected=infected;
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), R = Integer.MAX_VALUE;
		List<stat> cows = new ArrayList<stat>();
		for(int i = 0; i<N; i++)cows.add(new stat(readInt(), readInt()==1));
		Collections.sort(cows, (a,b)->Integer.compare(a.i,b.i));
		for(int i = 1; i<N; i++) {
			if(!cows.get(i-1).infected&&cows.get(i).infected)R=Math.min(R, cows.get(i).i-cows.get(i-1).i-1);
			else if(cows.get(i-1).infected&&!cows.get(i).infected)R=Math.min(R, cows.get(i).i-cows.get(i-1).i-1);
		}
		boolean[] cowvid = new boolean[N];
		int cnt = 0;
		for(int i = 0; i<N; i++) {
			if(i>0&&cows.get(i).i-cows.get(i-1).i<=R)cowvid[i]=true;
			if(cows.get(i).infected&&!cowvid[i]) {
				cnt++;
				cowvid[i]=true;
			}
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