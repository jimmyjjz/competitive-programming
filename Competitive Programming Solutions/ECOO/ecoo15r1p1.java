import java.util.*;
import java.io.*;
public class WhenYouEatYourSmarties{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		for(int i = 0; i<10; i++) {
			String s = readLine();
			int o=0,b=0,g=0,y=0,p=0,v=0,br=0,r=0;
			while(!s.equals("end of box")) {
				if(s.equals("orange"))o++;
				else if(s.equals("blue"))b++;
				else if(s.equals("green"))g++;
				else if(s.equals("yellow"))y++;
				else if(s.equals("pink"))p++;
				else if(s.equals("violet"))v++;
				else if(s.equals("brown"))br++;
				else r++;
				s = readLine();
			}
			System.out.println((o%7>0?o/7*13+13:o/7*13)+(b%7>0?b/7*13+13:b/7*13)+(g%7>0?g/7*13+13:g/7*13)+(y%7>0?y/7*13+13:y/7*13)+(p%7>0?p/7*13+13:p/7*13)+(v%7>0?v/7*13+13:v/7*13)+(br%7>0?br/7*13+13:br/7*13)+(r*16));
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