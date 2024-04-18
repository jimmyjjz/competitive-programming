import java.util.*;
import java.io.*;
public class COWOperations{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		String s = readLine();
		int len = s.length();
		int presum[][] = new int[len+1][3];
		for(int i = 0; i<len; i++) {
			if(s.charAt(i)=='C')presum[i+1][0]=1;
			else if(s.charAt(i)=='O')presum[i+1][1]=1;
			else presum[i+1][2]=1;
		}
		for(int i = 1; i<=len; i++) {
			presum[i][0]+=presum[i-1][0];
			presum[i][1]+=presum[i-1][1];
			presum[i][2]+=presum[i-1][2];
		}
		int Q = readInt();
		for(int i = 0; i<Q; i++) {
			int a=readInt(),b=readInt(),c=presum[b][0]-presum[a-1][0],o=presum[b][1]-presum[a-1][1],w=presum[b][2]-presum[a-1][2];
			//System.out.println(c+" "+o+" "+w);
			if((c%2==0&&o%2==1&&w%2==1)||(c%2==1&&o%2==0&&w%2==0))System.out.print("Y");
			else System.out.print("N");
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