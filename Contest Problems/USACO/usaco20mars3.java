import java.util.*;
import java.io.*;
public class TheMooParticle{
	static class spin{
		int x,y;
		public spin(int x, int y) {
			this.x=x;
			this.y=y;
		}
	}
	static class Sort implements Comparator<spin>{
		public int compare(spin a, spin b) {
			if(a.x==b.x)return Integer.compare(a.y,b.y);
			return Integer.compare(a.x,b.x);
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), connect[][] = new int[N][2], cnt = 1;
		List<spin> particles = new ArrayList<spin>();
		for(int i = 0; i<N; i++)particles.add(new spin(readInt(),readInt()));
		Collections.sort(particles, new Sort());
		connect[0][0]=particles.get(0).y;
		for(int i = 1; i<N; i++)connect[i][0]=Math.min(connect[i-1][0],particles.get(i).y);
		connect[N-1][1]=particles.get(N-1).y;
		for(int i = N-2; i>=0; i--)connect[i][1]=Math.max(connect[i+1][1],particles.get(i).y);
		for(int i = 0; i<N-1; i++)if(connect[i][0]>connect[i+1][1])cnt++;
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