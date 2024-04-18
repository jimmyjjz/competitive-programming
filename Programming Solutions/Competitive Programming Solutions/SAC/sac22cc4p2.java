import java.util.*;
import java.io.*;
public class ObligatoryStringProblem{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static String ori;
	public static Set<String> uni = new HashSet<String>();
	public static void r(int usage, int dex, String cur) {
		if(dex==4) {
			uni.add(cur);
			return;
		}
		for(int i = 0; usage-i>=0&&i<=13; i++)r(usage-i,dex+1,cur+(char)((int)(ori.charAt(dex)+i)>122?(int)(ori.charAt(dex)+i)-26:(int)(ori.charAt(dex)+i)));
		for(int i = 0; usage-i>=0&&i<=13; i++)r(usage-i,dex+1,cur+(char)((int)(ori.charAt(dex)-i)<97?(int)(ori.charAt(dex)-i)+26:(int)(ori.charAt(dex)-i)));
	}
	public static void main(String[] args) throws IOException{
		int N = readInt();
		ori = readLine();
		r(N,0,"");
		List<String> lexio = new ArrayList<String>(uni);
		Collections.sort(lexio);
		for(String s : lexio)System.out.println(s);
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