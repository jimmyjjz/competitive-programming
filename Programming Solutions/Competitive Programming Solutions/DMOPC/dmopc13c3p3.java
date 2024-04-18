import java.util.*;
import java.io.*;
public class CrossingField {
	static class pos{
		int x,y;
		public pos(int x, int y) {
			this.x=x;
			this.y=y;
		}
	}
	public static void printlist(List<pos> in) {
		System.out.println();
		for(int i = 0; i<in.size(); i++) {
			System.out.print(in.get(i).x+","+in.get(i).y+" - ");
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), H = readInt();
		int[][] field = new int[N][N];
		boolean[][] valid = new boolean[N][N];
		for(int i = 0; i<N; i++){
			for(int j = 0; j<N; j++) {
				field[i][j] = readInt();
			}
		}
		List<pos> current = new ArrayList<pos>();
		current.add(new pos(1,1));
			for(int i = 0; i<current.size(); i++) {
				//printlist(current);
				if(current.get(i).x<1 || current.get(i).y<1 || current.get(i).x>N || current.get(i).y>N) {
					continue;
				}
				if(!valid[current.get(i).x-1][current.get(i).y-1]) {
					int x = current.get(i).x-1, y = current.get(i).y-1;
					if(x == N-1 && y == N-1) {
						System.out.println("yes");
						return;
					}
					valid[x][y]=true;
					try {
					if(Math.abs(field[x][y]-field[x-1][y])<=H) current.add(new pos(x,y+1));
					} catch(ArrayIndexOutOfBoundsException e) {} try {
					if(Math.abs(field[x][y]-field[x+1][y])<=H) current.add(new pos(x+2,y+1));
					} catch(ArrayIndexOutOfBoundsException e) {} try {
					if(Math.abs(field[x][y]-field[x][y-1])<=H) current.add(new pos(x+1,y));
					} catch(ArrayIndexOutOfBoundsException e) {} try {
					if(Math.abs(field[x][y]-field[x][y+1])<=H) current.add(new pos(x+1,y+2));
					} catch(ArrayIndexOutOfBoundsException e) {}
				}
		}
		System.out.println("no");
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