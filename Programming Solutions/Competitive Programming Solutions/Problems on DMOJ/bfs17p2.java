import java.util.*;
import java.io.*;
public class CrayolaLightsaber{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt();
		int[] colours = new int[6];
		for(int i = 0; i<N; i++) {
			String c = next();
			if(c.equals("red"))colours[0]++;
			else if(c.equals("orange"))colours[1]++;
			else if(c.equals("yellow"))colours[2]++;
			else if(c.equals("green"))colours[3]++;
			else if(c.equals("blue"))colours[4]++;
			else colours[5]++;
		}
		Arrays.sort(colours);
		int total = 0;
		while(colours[4]!=0) {
			total+=colours[4]*2;
			colours[5]-=colours[4];
			colours[4]=0;
			Arrays.sort(colours);
		}
		System.out.println((colours[5]>0)?total+1:total);
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