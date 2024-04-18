import java.util.*;
import java.io.*;
public class SupriseTeleport {
	public static class pos{
		int x,y;
		public pos(int x, int y) {
			this.x=x;
			this.y=y;
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int tes=Integer.MAX_VALUE,des=Integer.MAX_VALUE;
		int R = readInt(), C = readInt();
		boolean[][]board = new boolean[R][C];
		boolean[][] tele =new boolean[R][C];
		int sx = readInt(), sy = readInt();
		int ex = readInt(), ey = readInt();
		for(int i = 0; i<R; i++) {
			String s = readLine();
			for(int j = 0; j<C; j++) {
				if(s.charAt(j)=='X') {
				board[i][j]=true;
				}
			}
		}
		int N = readInt();
		for(int i = 0; i<N; i++) {
			tele[readInt()][readInt()]=true;
		}
		Set<pos> next = new HashSet<pos>();
		next.add(new pos(sx,sy));
		int moves = 0;
		out:{
		while(true) {
			List<pos> current = new ArrayList<pos>(next);
			next.clear();
			for(pos num : current) {
				try {if(board[num.x][num.y]) continue;}
				catch(Exception e) {continue;}
				if(tele[num.x][num.y]) {
					tes = Math.min(tes,moves);
				}
				if(num.x==ex&&num.y==ey) {
					des = moves;
					break out;
				}
				board[num.x][num.y]=true;
				next.add(new pos(num.x+1,num.y));
				next.add(new pos(num.x,num.y+1));
				next.add(new pos(num.x-1,num.y));
				next.add(new pos(num.x,num.y-1));
			}
			moves++;
		}
		}
		System.out.println((tes>=des)?"0":des-tes);
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