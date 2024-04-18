import java.util.*;
import java.io.*;
public class primemean {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		List<Integer> search = new ArrayList<Integer>();
		  boolean primes[] = new boolean[10000002];
	        for (int i=0; i<10000002; i++) {
	            primes[i] = true;
	        }
	        for (int j = 2; j*j<10000002; j++){
	            if (primes[j] == true){
	                for (int i = j*j; i<10000002; i+=j) {
	                    primes[i] = false;
	                }
	            }
	        }
	            primes[0] = false;
	    		primes[1] = false;
		for(int i = 0; i<1000001; i++) {
			if(primes[i]) {
				search.add(i);
			}
		}
		int T = readInt();
		int in = 0;
		for(int i = 0; i<T; i++) {
			in = readInt()*2;
			for(int j = 0; j<search.size(); j++) {
				if(primes[in-search.get(j)]) {
					System.out.println(search.get(j)+" "+(in-search.get(j)));
					break;
				}
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