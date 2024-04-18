import java.util.*;
import java.io.*;
public class HopscotchII{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), K = readInt(), backtrack[] = new int[N+2];
		long min[] = new long[N+2], in;
		Deque<Integer> dq = new LinkedList<Integer>();
		dq.add(0);
		for(int i = 1; i<=N+1; i++) {
			if(!dq.isEmpty()&&dq.peekFirst()<i-K)dq.pollFirst();
			if(i!=N+1)in=readLong();
			else in = 0;
			backtrack[i]=dq.peekFirst();
			min[i]=in+min[dq.peekFirst()];
			while(!dq.isEmpty()&&min[dq.peekLast()]>=min[i])dq.pollLast();
			dq.add(i);
			
		}
		Stack<Integer> rev = new Stack<Integer>();
		int cur = backtrack[N+1];
		while(cur!=0) {
			rev.push(cur);
			cur=backtrack[cur];
		}
		System.out.println(min[N+1]);
		while(!rev.isEmpty())System.out.print(rev.pop()+" ");
		System.out.println();
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