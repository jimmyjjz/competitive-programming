import java.util.*;
import java.io.*;
public class AOSD1P2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static String s;
	static int i,cur;
	public static void ye(String a, String b) {
		if(s.indexOf(a)!=-1&&i>s.indexOf(a)) {
			i=s.indexOf(a);
			cur=Integer.parseInt(b);
		}
		if(s.indexOf(b)!=-1&&i>s.indexOf(b)) {
			i=s.indexOf(b);
			cur=Integer.parseInt(b);
		}
	}
	public static void main(String[] args) throws IOException {
		int total = 0;
		while(true) {
			s=readLine();
			if(s=="")break;
			int f;
			i=Integer.MAX_VALUE;
			ye("one","1");
			ye("two","2");
			ye("three","3");
			ye("four","4");
			ye("five","5");
			ye("six","6");
			ye("seven","7");
			ye("eight","8");
			ye("nine","9");
			f=cur;
			i=Integer.MAX_VALUE;
			s=new StringBuilder(s).reverse().toString();
			ye("eno","1");
			ye("owt","2");
			ye("eerht","3");
			ye("ruof","4");
			ye("evif","5");
			ye("xis","6");
			ye("neves","7");
			ye("thgie","8");
			ye("enin","9");
			total+=Integer.parseInt(f+""+cur);
		}
		System.out.println(total);
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