import java.util.*;
import java.io.*;
public class Sand {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
	        long lowest = 1,highest = 2000000000;
	        while (true) {
	            long spot = (lowest+highest)/2;
	            System.out.println(spot);
	            String feedback = readLine();
	            if(feedback.equals("SINKS")) {
	            	lowest = spot + 1;
	            }
	            else if(feedback.equals("FLOATS")) {
	            	highest = spot - 1;
	            }
	            else if(feedback.equals("OK")) {
	                break;
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