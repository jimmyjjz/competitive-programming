import java.util.*;
import java.io.*;
public class BobsStringCut{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int len = readInt(), cur[] = new int[26], all[] = new int[26], max = 0;
		String s = readLine();
		for(int i = 0; i<len; i++)all[s.charAt(i)-'a']++;
		for(int i = 0; i<len; i++) {
			cur[s.charAt(i)-'a']++;
			all[s.charAt(i)-'a']--;
			int cnt = 0;
			for(int j = 0; j<26; j++)if(cur[j]>0&&all[j]>0)cnt++;
			max=Math.max(max, cnt);
		}
		System.out.println(max);
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