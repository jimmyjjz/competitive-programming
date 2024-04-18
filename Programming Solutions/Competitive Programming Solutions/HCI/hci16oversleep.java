import java.util.*;
import java.io.*;
public class Oversleep {
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
		pos s = new pos(0,0), e = new pos(0,0);
		int N = readInt(), M = readInt();
		boolean[][] valid = new boolean[N][M];
		for(int i = 0; i<N; i++) {
			String str = readLine();
			for(int j = 0; j<M; j++) {
			if(str.charAt(j)=='X')valid[i][j]=true;
			else if(str.charAt(j)=='s')s = new pos(i,j);
			else if(str.charAt(j)=='e')e = new pos(i,j);
			}
		}
		Set<pos> con = new HashSet<pos>();
		con.add(s);
		//System.out.println(s.x+" "+s.y+" - "+e.x+" "+e.y);
		//printarr(N,M,valid);
		int moves = 0;
		while(!con.isEmpty()) {
			List<pos> current = new ArrayList<pos>(con);
			con.clear();
			for(pos p : current) {
				try {
				if(!valid[p.x][p.y]) {
					if(p.x==e.x&&p.y==e.y) {
						System.out.println(moves-1);
						return;
					}
					valid[p.x][p.y]=true;
					con.add(new pos(p.x+1,p.y));
					con.add(new pos(p.x,p.y+1));
					con.add(new pos(p.x-1,p.y));
					con.add(new pos(p.x,p.y-1));
				}
				}
				catch(Exception ex) {}
			}
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