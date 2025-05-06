//idea from bruce's code
import java.util.*;
import java.io.*;
public class TriangleTheDataStructure{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
	    int N = readInt(), K = readInt(), tri[][] = new int[N+1][N+1], pre = 1;
	    for(int i = 1; i<=N; i++) {
	    	for(int j = 1; j<=i; j++) {
	    		tri[i][j]=readInt();
	    	}
	    }
	    for(int cur = 2, adjust = cur-pre; cur<=K; pre=cur, cur=(int)(1.5*pre), adjust=cur-pre){
	        for(int i = 1; i<=N-cur+1; i++) {
	        	for(int j = 1; j<=i; j++) {
	        		tri[i][j]=Math.max(tri[i+adjust][j+adjust],Math.max(tri[i+adjust][j],tri[i][j]));
	        	}
	        }
	    } 
	    long ans = 0;
	    for(int i = 1, adjust = K-pre; i<=N-K+1; i++) {
	    	for(int j = 1; j<=i; j++) {
	    		ans+=Math.max(tri[i+adjust][j+adjust],Math.max(tri[i+adjust][j],tri[i][j]));
	    	}
	    }
	    System.out.println(ans);
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