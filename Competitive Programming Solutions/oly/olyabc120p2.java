import java.util.*;
import java.io.*;
public class KthGCD {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static List<Integer> save = new ArrayList<Integer>();
	public static int aso = 0, bso = 0;
	public static long GCD(long a, long b) {
		if(b <= 0) {
			return a;
		}
		else {
		return GCD(b,a%b);
		}
	}
	public static void main(String[] args) throws IOException{
		long gcd = GCD(readLong(), readLong());
		List<Long> a = new ArrayList<Long>();
		List<Long> b = new ArrayList<Long>();
		   for(Long i=(long) 1; i<=Math.sqrt(gcd)+1; i++) {
		        if(gcd%i==0) {
		            a.add(i);
		            b.add(gcd/i);
		        }
		    }
		   Set<Long> factors = new HashSet<Long>();
		    for(Long f: a) {
		        factors.add(f);
		    }
		    for(int i=b.size()-1; i>=0; i--) {
		        factors.add(b.get(i));
		    }
		    List<Long> get = new ArrayList<Long>(factors);
		    Collections.sort(get);
		    Collections.reverse(get);
		    try {
		    System.out.println(get.get(readInt()-1));
		    }
		    catch(IndexOutOfBoundsException e) {
		    	System.out.println("-1");
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