import java.util.*;
import java.io.*;
public class FloorPlan {
	public static class stats{
		int x,y,s;
		public stats(int x, int y, int s) {
			this.x=x;
			this.y=y;
			this.s=s;
		}
	}
	static class Sortbysize implements Comparator<stats>{
		public int compare(stats a, stats b) {
			return -Integer.compare(a.s,b.s);
		}
	}
	public static boolean[][] plan;
	public static int size;
	public static void spread(int x, int y) {
		try{if(plan[x][y]) return;}
		catch(Exception e) {return;}
		plan[x][y]=true;
		size++;
		spread(x+1,y);
		spread(x,y+1);
		spread(x-1,y);
		spread(x,y-1);
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int wood = readInt(), R = readInt(), C = readInt();
		plan = new boolean[R][C];
		for(int i = 0; i<R; i++) {
			String s = readLine();
			for(int j = 0; j<C; j++) {
				if(s.charAt(j)=='I') {
				plan[i][j]=true;
				}
			}
		}
		List<stats> plots = new ArrayList<stats>();
		for(int i = 0; i<R; i++) {
			for(int j = 0; j<C; j++) {
				if(!plan[i][j]) {
					size=0;
					spread(i,j);
					plots.add(new stats(i,j,size));
				}
			}
		}
		int room = 0;
		Collections.sort(plots, new Sortbysize());
		for(stats out : plots) {
			if(wood-out.s<0) break;
			wood-=out.s;
			room++;
		}
		if(room==1) {
			System.out.println(room+" room, "+wood+" square metre(s) left over");
		}
		else {
		System.out.println(room+" rooms, "+wood+" square metre(s) left over");
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