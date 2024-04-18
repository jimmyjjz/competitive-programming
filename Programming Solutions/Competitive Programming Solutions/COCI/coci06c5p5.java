import java.util.*;
import java.io.*;
public class Ivana{
	static class stat{
		int a,b;
		public stat(int a,int b) {
			this.a=a;
			this.b=b;
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), cnt = 0;
		int[] ori = new int[N];
		for(int i = 0; i<N; i++)ori[i]=readInt()%2;
		for(int k = 0; k<N; k++) {
		int[] nums = new int[N-1];
		int n = 0;
		for(int i = k-1; i>=0; i--)nums[n++]=ori[i];
		for(int i = N-1; i>k; i--)nums[n++]=ori[i];
		Queue<stat> current = new LinkedList<stat>();
		//System.out.println(Arrays.toString(nums)+" "+ori[k]);
		for(int i = 0; i<N-1; i++)current.add(new stat(nums[i],0));
		for(int i = 1; i<N-1; i++) {
			stat front = current.poll();
			for(int j = 0; j+i<N-1; j++) {
				stat now = current.poll();
				if(now.a<front.a)current.add(new stat(now.b+nums[j],now.a));
				else current.add(new stat(front.b+nums[j+i],front.a));
				front=now;
		}
		}
		if(current.peek().b+ori[k]>current.peek().a)cnt++;
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