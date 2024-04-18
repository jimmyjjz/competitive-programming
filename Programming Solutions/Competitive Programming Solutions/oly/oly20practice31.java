import java.util.*;
import java.io.*;
public class BobsMachine{
	static class stat{
		int s,e,v;
		stat(int s, int e, int v){
			this.s=s;
			this.e=e;
			this.v=v;
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), M = readInt(), R = readInt(), curMax[] = new int[N+1];
		Stack<stat> intervals = new Stack<stat>();
		for(int i = 0; i<M; i++)intervals.push(new stat(readInt(), readInt()+R, readInt()));
		Collections.sort(intervals, (a,b)->-Integer.compare(a.s,b.s));
		for(int i = 0; i<=N; i++) {
			if(i!=0)curMax[i]=Math.max(curMax[i], curMax[i-1]);
			while(!intervals.isEmpty()&&intervals.peek().s==i)curMax[Math.min(N,intervals.peek().e)]=Math.max(curMax[Math.min(N,intervals.peek().e)],curMax[i]+intervals.pop().v);
		}
		System.out.println(curMax[N]);
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