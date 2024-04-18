import java.util.*;
import java.io.*;
public class ExerciseDeadlines{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), day[] = new int[N+1], bit[] = new int[N+1];
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b)->-Integer.compare(a,b));
		List<Integer>[] work = new ArrayList[N+1];
		for(int i = 1; i<=N; i++)work[i]=new ArrayList<Integer>();
		for(int i = 1; i<=N; i++)work[readInt()].add(i);
		for(int i = N; i>0; i--) {
			for(int j : work[i])pq.add(j);
			try{day[i]=pq.poll();}catch(Exception e) {System.out.println(-1);return;}
		}
		long sum = 0;
		for(int i = 1; i<=N; i++) {
			long temp = 0;
			for(int j = day[i]; j>0; j-=j&-j)temp+=bit[j];
	        sum+=i-1-temp;
	        for(int j = day[i]; j<=N; j+=j&-j)bit[j]++;
		}
		System.out.println(sum);
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