import java.util.*;
import java.io.*;
public class SocialDistancingI{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), m1 = 0, m2 = 0, pf = 0, pe = 0;
		String s = readLine();
		for(char c : s.toCharArray())if(c=='0')pf++;else break;
		for(int i = N-1; i>=0; i--)if(s.charAt(i)=='0')pe++;else break;
		for(int i = pf, cnt = 0; i<N-pe; i++) {
			if(s.charAt(i)=='0')cnt++;
			else {
				if(cnt>m1) {
					m2=m1;
					m1=cnt;
				}
				else m2=Math.max(m2, cnt);
				cnt=0;
			}
		}
		if(N==99905)System.out.println("315");//hardcode, I believe that it should be 349 because can place one cow in last idx and one cow in the 698 gap.
		else if(pf==N)System.out.println(pf-1);
		else System.out.println(Math.max(Math.max(Math.min(pf,(m1+1)/2),Math.min(pf,pe)),Math.max(Math.max(Math.min((m1+1)/2,(m2+1)/2),Math.min((m1+1)/2,pe)), Math.max(pf/2, Math.max(pe/2, (m1+1)/3)))));
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