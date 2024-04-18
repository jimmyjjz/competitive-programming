import java.util.*;
import java.io.*;
public class bobmaze {
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
		int M = readInt(), N = readInt();
		int Sa = readInt()-1, Sb = readInt()-1;
		int Ea = readInt()-1, Eb = readInt()-1;
		boolean[][] maze = new boolean[M][N];
		for(int i = 0; i<M; i++) {
			String s = readLine();
			for(int j = 0; j<N; j++) {
				if(s.charAt(j)=='#') {
					maze[i][j]=true;		
				}
			}
		}
		List<pos> current = new ArrayList<pos>();
		current.add(new pos(Sa,Sb));
		int old = 0;
		int moves = 0;
		boolean moving = true;
		while(moving) {
			moving = false;
			int fixed = current.size();
			for(int i = old; i<fixed; i++) {
				try {
				int x = current.get(i).x, y = current.get(i).y;
				if(!maze[x][y]) {
					if(x==Ea&&y==Eb) {
						System.out.println(moves);
						return;
					}
					maze[x][y]=true;
					moving = true;
					//regular
					current.add(new pos(x+1,y));
					current.add(new pos(x,y+1));
					current.add(new pos(x-1,y));
					current.add(new pos(x,y-1));
					//knight
					current.add(new pos(x+1,y+2));
					current.add(new pos(x+2,y+1));
					current.add(new pos(x+2,y-1));
					current.add(new pos(x+1,y-2));
					current.add(new pos(x-1,y-2));
					current.add(new pos(x-2,y-1));
					current.add(new pos(x-2,y+1));
					current.add(new pos(x-1,y+2));
				}
				}
				catch(Exception e) {}
			}
			old = fixed;
			moves++;
		}
		System.out.println("-1");
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