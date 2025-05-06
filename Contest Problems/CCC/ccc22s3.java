import java.util.*;
import java.io.*;
public class GoodSamples {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		long N = readLong(), M = readLong(),K = readLong(),cnt = M*(1+M)/2+((N-M)*M);
		if(K>cnt||K<N) {
			System.out.println("-1");
			return;
		}
		long d = K-N;
		int cur = 0, num = 0;
		List<Integer> save = new ArrayList<Integer>();
		for(int i = 0; i<N; i++) {
			if(d>=cur) {
				d-=cur;
				num++;
				if(cur<M-1)cur++;//<=
				if(num>M)num=1;
				System.out.print(num+" ");
				//System.out.println("-> "+d+" "+cur);
				save.add(num);
			}
			else {
				System.out.print(save.get(Math.max(0,save.size()-1-(int)(d)))+" ");
			}
		}
//		System.out.println("\n"+d);
//		System.out.println(save);
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