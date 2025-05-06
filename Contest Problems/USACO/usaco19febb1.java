import java.util.*;
import java.io.*;
public class SleepyCowHerding {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int[] cows = new int[3];
		for(int i = 0; i<3; i++)cows[i]=readInt();
		Arrays.sort(cows);
		int a = cows[1]-cows[0]-1, b = cows[2]-cows[1]-1;
		//System.out.println(a+" "+b);
		//System.out.println(Arrays.toString(cows));
		if(a==1||b==1) {
			System.out.println("1");
		}
		else if(a==0&&b==0){
			System.out.println("0");
		}
		else {
			System.out.println("2");
		}
		System.out.println(Math.max(a, b));
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