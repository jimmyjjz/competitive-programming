import java.util.*;
import java.io.*;
public class AOSD2P1 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int sum=0;
		for(int i = 1; i<=100; i++) {
			String s=readLine();
			int r=0,g=0,b=0;
			s=s.replaceAll(" ","");
			s=s.replaceAll("red","r");
			s=s.replaceAll("blue","b");
			s=s.replaceAll("green","g");
			st=new StringTokenizer(s,":");
			st.nextToken();
			st=new StringTokenizer(st.nextToken(),";");
			while(st.hasMoreTokens()) {
				StringTokenizer st2 = new StringTokenizer(st.nextToken(),",");
				while(st2.hasMoreTokens()) {
					String str=st2.nextToken();
					switch(str.charAt(str.length()-1)) {
						case 'r':r=Math.max(r,Integer.parseInt(str.substring(0,str.length()-1)));break;
						case 'g':g=Math.max(g,Integer.parseInt(str.substring(0,str.length()-1)));break;
						case 'b':b=Math.max(b,Integer.parseInt(str.substring(0,str.length()-1)));break;
					}
			}
			}
			sum+=(r*g*b);
		}
		System.out.println(sum);
	}
	static String next() throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}

	static long readLong() throws IOException {
		return Long.parseLong(next());
	}

	static int readInt() throws IOException {
		return Integer.parseInt(next());
	}

	static double readDouble() throws IOException {
		return Double.parseDouble(next());
	}

	static char readCharacter() throws IOException {
		return next().charAt(0);
	}

	static String readLine() throws IOException {
		return br.readLine().trim();
	}
}