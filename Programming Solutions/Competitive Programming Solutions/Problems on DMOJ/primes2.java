import java.io.*;
import java.util.*;
public class Primes2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
    public static void main(String args[])  throws IOException{
        int bot = readInt(), top = readInt();
        if(bot < 2) {
        	bot = 2;
        }
        Vector<Integer> prime = new Vector<Integer>();
        int bound = (int)Math.sqrt(top);
        boolean[] mark = new boolean[bound + 1];
        for(int i = 0; i <= bound; i++)
            mark[i] = true;
 
        for (int i = 2; i * i <= bound; i++) {
            if(mark[i] == true) {
                for (int j = i * i; j <= bound; j += i)
                    mark[j] = false;
            }
        }
        for (int i = 2; i <= bound; i++) {
            if (mark[i] == true)
                prime.add(i);
        }
        boolean[] mark1 = new boolean[top - bot + 1];
        for(int i = 0; i < mark1.length; i++) {
        	mark1[i] = true;
        }
        for(int i = 0; i < prime.size(); i++) {
            int dip = (bot / prime.get(i)) * prime.get(i);
            if(dip < bot){
                dip += prime.get(i);
            }
            if(dip == prime.get(i)){
                dip += prime.get(i);
            }
            for(int j = dip; j <= top; j += prime.get(i)) {
                 mark1[j - bot] = false;
            }
        }
        for (int i = bot; i <= top; i++) {
            if (mark1[i - bot] == true)
                System.out.println(i);
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