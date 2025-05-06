import java.util.*;
import java.io.*;
public class Railway {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		 for(int i = 0; i<10; i++) {
	            int N = readInt();
	            LinkedList<Integer> road = new LinkedList<Integer>();
	            for(int j = 0; j<N; j++) {
	            	road.add(readInt());
	            }
	            int total = 0;
	            for(int j = N; j>1; j--) {//ascending order
	                if(road.indexOf(j-1) > road.indexOf(j)){
	                	total +=road.indexOf(j-1); 
	                	road.remove(road.indexOf(j-1));
	                    road.add(0, j-1);
	                }
	            }
	            System.out.println(total);
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