import java.util.*;
import java.io.*;
public class SocialNetwork{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static int findrep(int n, int[][] disjoint) {
		while(disjoint[n][0]!=n)n=disjoint[n][0];
		return n;
	}
	public static void main(String[] args) throws IOException{
		int N = readInt();
		int[][] disjoint = new int[1000000][2];
		Map<String,Integer> translate = new HashMap<String,Integer>();
		int unique = 0;
		for(int i = 0; i<1000000; i++) {
			disjoint[i][0]=i;
			disjoint[i][1]=1;
		}
		for(int i = 0; i<N; i++) {
			String a = next(), b = next();
			if(translate.get(a)==null)translate.put(a,unique++);
			if(translate.get(b)==null)translate.put(b,unique++);
			int x = findrep(translate.get(a),disjoint), y = findrep(translate.get(b),disjoint);
			if(x==y) {
				System.out.println(disjoint[x][1]);
				continue;
			}
			if(disjoint[x][1]>=disjoint[y][1]) {
				disjoint[y][0]=x;
				disjoint[x][1]+=disjoint[y][1];
				System.out.println(disjoint[x][1]);
			}
			else {
				disjoint[x][0]=y;
				disjoint[y][1]+=disjoint[x][1];
				System.out.println(disjoint[y][1]);
			}
		}
		//for(int i = 0; i<10; i++)System.out.println(disjoint[i][0]);
		//System.out.println(translate);
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