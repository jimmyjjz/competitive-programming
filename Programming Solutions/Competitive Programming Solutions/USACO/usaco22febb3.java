import java.util.*;
import java.io.*;
public class Block {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt();
		Set<Character> one = new HashSet<Character>(),two = new HashSet<Character>(),three = new HashSet<Character>(),four = new HashSet<Character>();
		String s = readLine();
		for(int i = 0; i<6; i++)one.add(s.charAt(i));
		s = readLine();
		for(int i = 0; i<6; i++)two.add(s.charAt(i));
		s = readLine();
		for(int i = 0; i<6; i++)three.add(s.charAt(i));
		s = readLine();
		for(int i = 0; i<6; i++)four.add(s.charAt(i));
		for(int i = 0; i<N; i++) {
			s = readLine();
			int len = s.length();
			int[] cnts = new int[26];
			for(int j = 0; j<len; j++)cnts[(int)(s.charAt(j))-65]++;
			nested:{
			for(char a : one) {
				for(char b : two) {
					for(char c : three) {
						for(char d : four) {
							int[] compare = new int[26];
							compare[(int)(a)-65]++;
							compare[(int)(b)-65]++;
							compare[(int)(c)-65]++;
							compare[(int)(d)-65]++;
							out:{
							for(int j = 0; j<26; j++)if(cnts[j]>compare[j])break out;
							System.out.println("YES");
							break nested;
							}
						}
					}
				}
			}
			System.out.println("NO");
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