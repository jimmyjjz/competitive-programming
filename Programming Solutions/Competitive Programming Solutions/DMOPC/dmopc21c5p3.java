import java.util.*;
import java.io.*;
public class PermutationsAndPrime3 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		List<Integer> primes = new ArrayList<Integer>();
		for(int i = 2; i<=100003; i++) {
			out:{
			for(int j = 2; j<=(int)Math.sqrt(i); j++) {
				if(i%j==0)break out;
			}
			primes.add(i);
		}
		}
		boolean[] win = new boolean[100001];
		for(int i = 1; i<=100000; i++) {
			out:{
			for(int j = 0; i-primes.get(j)>0; j++) {
				if(win[i-primes.get(j)]) {
					win[i]=false;
					break out;
				}
			}
			win[i]=true;
		}
		}
		int T = readInt();
		for(int i = 0; i<T; i++) {
			int N = readInt();
			if(N==1||N==2){
				System.out.println("-1");
				continue;
			}
			if(!win[N]) {
				for(int j = 1; j<N-2; j++)System.out.print(j+" ");
				System.out.println((N-2)+" "+(N-1)+" "+N);
			}
			else if(!win[N-1]) {
				for(int j = 1; j<N-2; j++)System.out.print(j+" ");
				System.out.println((N-2)+" "+N+" "+(N-1));
			}
			else{
				for(int j = 1; j<N-2; j++)System.out.print(j+" ");
				System.out.println(N+" "+(N-2)+" "+(N-1));
			}
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