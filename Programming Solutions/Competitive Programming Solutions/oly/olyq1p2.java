import java.util.*;
import java.io.*;
public class LongestUpDownSubsequence{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), cnt = 2;
		LinkedList<Integer> sequence = new LinkedList<Integer>();
		sequence.add(readInt());
		for(int i = 1; i<N; i++) {
			int in = readInt();
			if(sequence.peekLast()!=in)sequence.add(in);
		}
		if(sequence.size()==1) {
			System.out.println(1);
			return;
		}
		//System.out.println(sequence);
		int a = sequence.poll(), b = sequence.poll(), pre = b;
		//System.out.print(a);
		boolean nextHigher;
		if(a>b)nextHigher = true;
		else nextHigher = false;
		while(!sequence.isEmpty()) {
			int now = sequence.poll();
			if(nextHigher) {
				if(now>pre) {
				cnt++;
				//System.out.print(" "+pre);
				pre=now;
				nextHigher=false;
				}
				pre=Math.min(pre, now);
			}
			else if(!nextHigher) {
				if(now<pre) {
				cnt++;
				//System.out.print(" "+pre);
				pre=now;
				nextHigher=true;
				}
				pre=Math.max(pre, now);
			}
		}
		//System.out.print(" "+pre);
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