import java.util.*;
import java.io.*;
public class AFK {
	static class pos{
		int x,y;
		public pos(int x, int y) {
			this.x=x;
			this.y=y;
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int t = readInt();
		int sx = 0,sy = 0,ex = 0,ey = 0;
		for(int i = 0; i<t; i++) {
			out:{
			int l = readInt(), w = readInt(), steps = 0;
			boolean[][] encountered = new boolean[w][l];
			for(int j = 0; j<w; j++) {
				String save = readLine();
				for(int k = 0; k<l; k++) {
					if(save.charAt(k) == 'C') {
						sx = j;
						sy = k;
					}
					else if(save.charAt(k) == 'W') {
						ex = j;
						ey = k;
					}
					else if(save.charAt(k) == 'X') {
						encountered[j][k]=true;
					}
				}
			}
			Set<pos> next = new HashSet<pos>();
			next.add(new pos(sx,sy));
			while(true) {
				if(steps >= 60) {
					System.out.println("#notworth");
					break out;
				}
			List<pos> current = new ArrayList<pos>(next);
			next.clear();
			int size = current.size();
			for(int j = 0; j<size; j++) {
				try {
				if(!encountered[current.get(j).x][current.get(j).y]) {
					//System.out.println(current.get(j).x+" "+ex+" - "+current.get(j).y+" "+ey);
					if(current.get(j).x == ex && current.get(j).y == ey) {
						System.out.println(steps);
						break out;
					}
					encountered[current.get(j).x][current.get(j).y]=true;
					next.add(new pos(current.get(j).x-1,current.get(j).y));
					next.add(new pos(current.get(j).x,current.get(j).y-1));
					next.add(new pos(current.get(j).x+1,current.get(j).y));
					next.add(new pos(current.get(j).x,current.get(j).y+1));
				}
				}
				catch(Exception e) {
					//System.out.println("exception");
					}
			}
			steps++;
			}
		}
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