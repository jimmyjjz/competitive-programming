import java.util.*;
import java.io.*;
public class AnimalRights {
	public static int[][] plan;
	public static int holes;
	public static boolean flag;
	public static void spread(int x, int y) {
		try{if(plan[x][y]==1) return;}
		catch(Exception e) {return;}
		if(plan[x][y]==2 && flag) {
			holes++;
			flag = false;
		}
		plan[x][y]=1;
		spread(x+1,y);
		spread(x,y+1);
		spread(x-1,y);
		spread(x,y-1);
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int R = readInt(), C = readInt();
		plan = new int[R][C];
		for(int i = 0; i<R; i++) {
			String s = readLine();
			for(int j = 0; j<C; j++) {
				if(s.charAt(j)=='#') {
				plan[i][j]=1;
				}
				else if(s.charAt(j)=='M') {
				plan[i][j]=2;
				}
			}
		}
		for(int i = 0; i<R; i++) {
			for(int j = 0; j<C; j++) {
				if(plan[i][j]!=1) {
					flag = true;
					spread(i,j);
				}
			}
		}
		System.out.println(holes);
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