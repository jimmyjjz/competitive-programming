import java.util.*;
import java.io.*;
public class FriendsofFriends {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static int findrep(int[][] disjoint, int n) {
		while(disjoint[n][0]!=n)n=disjoint[n][0];
		return n;
	}
	public static void main(String[] args) throws IOException{
		int N = readInt(), Q = readInt();
		int[][] disjoint = new int[N+1][3];
		for(int i = 1; i<=N; i++) {
			disjoint[i][0]=i;
			disjoint[i][2]=1;
		}
		for(int i = 0; i<Q; i++) {
			int op = readInt();
			if(op==1) {
				int a = findrep(disjoint, readInt()), b = findrep(disjoint, readInt());
				if(a==b)continue;
				if(disjoint[a][1]>=disjoint[b][1]) {
					disjoint[a][1]++;
					disjoint[b][0]=a;
					disjoint[a][2]+=disjoint[b][2];
				}
				else{
					disjoint[b][1]++;
					disjoint[a][0]=b;
					disjoint[b][2]+=disjoint[a][2];
				}
			}
			else System.out.println(disjoint[findrep(disjoint,readInt())][2]);
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