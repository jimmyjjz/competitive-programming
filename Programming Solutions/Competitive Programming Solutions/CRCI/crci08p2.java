import java.util.*;
import java.io.*;
public class Majstor{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int R = readInt();
		String ori = readLine();
		int N = readInt(), total = 0, friends[][] = new int[R][3], best = 0;
		for(int i = 0; i<N; i++) {
			String str = readLine();
			for(int j = 0; j<R; j++) {
				if(str.charAt(j)=='R') {
					if(ori.charAt(j)=='R')total++;
					else if(ori.charAt(j)=='P')total+=2;
					friends[j][0]++;
				}
				else if(str.charAt(j)=='P') {
					if(ori.charAt(j)=='P')total++;
					else if(ori.charAt(j)=='S')total+=2;
					friends[j][1]++;
				}
				else {
					if(ori.charAt(j)=='S')total++;
					else if(ori.charAt(j)=='R')total+=2;
					friends[j][2]++;
				}
			}
		}
		for(int i = 0; i<R; i++)best+=Math.max(Math.max(friends[i][0]*2+friends[i][1],friends[i][2]*2+friends[i][0]),friends[i][1]*2+friends[i][2]);
		System.out.println(total+"\n"+best);
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