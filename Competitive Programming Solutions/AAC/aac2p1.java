import java.util.*;
import java.io.*;
public class Koala {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		Map<Character,Integer> num = new HashMap<Character,Integer>();
		List<Character> letters = new ArrayList<Character>();
		int count = 0;
		int in = readInt();
		String s = readLine();
		for(int i = 0; i<in; i++) {
			if(num.get(s.charAt(i)) == null) {
				num.put(s.charAt(i),0);
				letters.add(s.charAt(i));
			}
			num.put(s.charAt(i),num.get(s.charAt(i))+1);
		}
		for(int i = 0; i<letters.size(); i++){
			if(num.get(letters.get(i))%2!=0) {
				count++;
			}
		}
		if(count<1) {
			count = 1;
		}
		System.out.println(count);
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