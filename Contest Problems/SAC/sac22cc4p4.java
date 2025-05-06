import java.util.*;
import java.io.*;
public class ObligatorySubarrayProblem{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static int[]nums;
	public static long LessOrEqual(int N, int value) {
		//System.out.println();
		long cnt = 0;
		int bot = 0, top = 0;
		Deque<Integer> big = new LinkedList<Integer>();
		Deque<Integer> small = new LinkedList<Integer>();
		while(top<N) {
			while(!big.isEmpty()&&nums[big.peekLast()]<=nums[top])big.pollLast();
			big.add(top);
			while(!small.isEmpty()&&nums[small.peekLast()]>=nums[top])small.pollLast();
			small.add(top);
			while(bot<=top&&nums[big.peekFirst()]-nums[small.peekFirst()]>value) {
				bot++;
				if(bot>small.peekFirst())small.poll();
				if(bot>big.peekFirst())big.poll();
			}
			//System.out.println(bot+" "+top+" "+(top-bot));
			cnt+=top-bot;
			top++;
		}
		return cnt;
	}
	public static void main(String[] args) throws IOException{
		int N = readInt(), B = readInt(), T = readInt();
		nums = new int[N];
		for(int i = 0; i<N; i++)nums[i]=readInt();
		System.out.println(LessOrEqual(N,T)-LessOrEqual(N,B-1));
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