import java.util.*;
import java.io.*;
public class Divisibilityby11{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int T = readInt();
		for(int i = 0; i<T; i++) {
			String line = readLine();
			int[] c = new int[line.length()];
			for(int j = 0; j<line.length(); j++) {
				c[j]=Integer.parseInt(line.charAt(j)+"");
			}
			int back = line.length()-1;
			int front = 0;
			System.out.println(line);
			while(back-front>=2) {
				if(c[back]<=c[back-1]) {
					c[back-1]-=c[back];
					back--;
				}
				else {
				c[back-1]=c[back-1]-c[back]+10;
				for(int j = back-2; j>=0; j--) {
					if(c[j]!=0) {
						c[j]--;
						break;
					}
					c[j]=9;
				}
				back--;
				}
				while(c[front]==0) {
					front++;
				}
				String cur = "";
				for(int j = front; j<=back; j++) {
					cur+=c[j];
				}
				System.out.println(cur);
			}
			String cur = "";
			for(int j = front; j<=back; j++) {
				cur+=c[j];
			}
			System.out.println((Integer.parseInt(cur)%11==0)?"The number "+line+" is divisible by 11.":"The number "+line+" is not divisible by 11.");
			if(i<T-1)System.out.println();
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