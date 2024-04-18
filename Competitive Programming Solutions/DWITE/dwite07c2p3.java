import java.util.*;
import java.io.*;
public class FP {
	public static class stats{
		int x,y,s;
		public stats(int x, int y, int s) {
			this.x=x;
			this.y=y;
			this.s=s;
		}
	}
	public static short[][] plan;
	public static int cnt = 0,flag = 0;
	public static Map<Integer,Integer> nums = new HashMap<Integer,Integer>();
	public static void spread(int x, int y) {
		try{if(plan[x][y]==-1) return;}
		catch(Exception e) {return;}
		if(plan[x][y]>0)flag = plan[x][y];
		plan[x][y]=-1;
		cnt++;
		if(flag!=0)nums.put(flag, cnt);
		//System.out.println(flag+" "+cnt);
		spread(x+1,y);
		spread(x,y+1);
		spread(x-1,y);
		spread(x,y-1);
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int R = readInt(), C = readInt();
		plan = new short[R][C];
		for(int i = 0; i<R; i++) {
			String s = readLine();
			for(int j = 0; j<C; j++) {
				if(s.charAt(j)=='#') {
				plan[i][j]=-1;
				}
				else if(Character.isDigit(s.charAt(j))) {
					plan[i][j]=Short.parseShort(s.charAt(j)+"");
				}
			}
		}
		for(int i = 0; i<R; i++) {
			for(int j = 0; j<C; j++) {
				if(plan[i][j]!=-1) {
					cnt = 0;
					flag = 0;
					spread(i,j);
				}
			}
		}
		//System.out.println(nums);
		for(int n : nums.values()) {
			System.out.println(n);
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