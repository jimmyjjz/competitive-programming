import java.util.*;
import java.io.*;
public class primefactors {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int A = readInt(), B = readInt();
		for(int p = A; p<=B; p++) {
		List<Integer> dupe = new ArrayList<Integer>();
		int save = p;
		while (save % 2 == 0) {
            dupe.add(2);
            save/= 2;
        }
        for (int i = 3; i <= Math.sqrt(save); i += 2) {
            while (save % i == 0) {
            	  dupe.add(i);
                save /= i;
            }
        }
        if (save > 2) {
        	  dupe.add(save);
        }
        Set<Integer> removal = new HashSet<Integer>(dupe);
        List<Integer> filtered = new ArrayList<Integer>(removal);
        System.out.println(filtered.size());
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