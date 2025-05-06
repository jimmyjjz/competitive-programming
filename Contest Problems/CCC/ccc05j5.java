import java.util.*;
import java.io.*;
public class monkey {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		   String in = "";
		   while(true){
			   in = readLine();
			   if(in.equals("X")) {
				   return;
			   }
		        boolean flag = true;
		        while (flag){
		        	flag = false;
		            if (in.indexOf("ANA") != -1) {
		            	in = in.replaceFirst("ANA", "A");
		            	flag = true;
		            }
		            if (in.indexOf("BAS") != -1) {
		            	in = in.replaceFirst("BAS", "A");
		            	flag = true;
		            }
		        }
		        if (in.equals("A")) {
		            System.out.println("YES");
		            continue;
		        }
		        	System.out.println("NO");
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