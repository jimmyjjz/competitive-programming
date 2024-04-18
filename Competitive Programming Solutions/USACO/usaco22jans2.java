import java.util.*;
import java.io.*;
public class CowFrisbee {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt();
		long cnt = 0;
	    int[] cows = new int[N];
	    for(int i = 0; i<N; i++)cows[i]=readInt();
	    Stack<Integer> cur = new Stack<Integer>();
	    for(int i = N-1; i>=0; i--){
	    	try{
	    	if(cows[i]==cows[cur.peek()])cur.pop();
	        while(cows[i]>cows[cur.peek()])cnt+=cur.pop()-i+1;
	        cnt+=cur.peek()-i+1;
	    	}
	    	catch(Exception e) {}
	    	cur.push(i);
	    }
	    System.out.println(cnt);
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