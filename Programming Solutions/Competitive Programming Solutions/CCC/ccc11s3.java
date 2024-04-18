import java.util.*;
import java.io.*;
public class AliceThroughtheLookingGlass{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static boolean crystal(int mag, int x, int y) {
		int orix = x, oriy = y, pow=(int)Math.pow(5, mag-1);
		x/=pow;y/=pow;
		if((x==1&&y==0)||(x==3&&y==0)||(x==2&&y==0)||(x==2&&y==1))return true;
		if(mag>1&&((x==2&&y==2)||(x==1&&y==1)||(x==3&&y==1)))return crystal(mag-1,orix%pow, oriy%pow);
		return false;
	}
	public static void main(String[] args) throws IOException{
		int T = readInt();
		for(int i = 0; i<T; i++)System.out.println(crystal(readInt(), readInt(), readInt())?"crystal":"empty");
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