import java.util.*;
import java.io.*;
public class Maze {
	static class pos{
		int x,y;
		public pos(int x, int y) {
			this.x=x;
			this.y=y;
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void printarr(int r, int c, char[][] arr) {
		for(int i = 0; i<r; i++) {
			System.out.println();
			for(int j = 0; j<c; j++) {
				System.out.print(arr[i][j]);
			}
		}
	}
	public static void main(String[] args) throws IOException{
		int t = readInt();
		for(int i = 0; i<t; i++) {
			out:{
			int r = readInt(), c = readInt();
			boolean[][] valid = new boolean[r][c];
			char[][] section = new char[r][c];
			for(int j = 0; j<r; j++) {
				String in = readLine();
				for(int k = 0; k<c; k++) {
					if(in.charAt(k) == '*') {
						valid[j][k]=true;
					}
					section[j][k]=in.charAt(k);
				}
			}
			Set<pos> round = new HashSet<pos>();
			round.add(new pos(0,0));
			int cnt = 0;
			boolean pass = true;
			while(pass) {
				pass = false;
				cnt++;
				List<pos> current = new ArrayList<pos>(round);
				round.clear();
				int fixed = current.size();
				for(int j = 0; j<fixed; j++) {
					try {
						pos now = current.get(j);
						if(!valid[now.x][now.y]) {
							if(now.x==r-1&&now.y==c-1) {
								System.out.println(cnt);
								break out;
							}
							valid[now.x][now.y]=true;
							pass = true;
							switch(section[now.x][now.y]) {
							case '+':
								round.add(new pos(now.x+1,now.y));
								round.add(new pos(now.x,now.y+1));
								round.add(new pos(now.x-1,now.y));
								round.add(new pos(now.x,now.y-1));
								break;
							case '|':
								round.add(new pos(now.x-1,now.y));
								round.add(new pos(now.x+1,now.y));
								break;
							case '-':
								round.add(new pos(now.x,now.y-1));
								round.add(new pos(now.x,now.y+1));
								break;
							}
						}
					}
					catch(Exception e) {}
				}
			}
			System.out.println("-1");
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