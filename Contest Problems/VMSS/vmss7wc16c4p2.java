import java.util.*;
import java.io.*;
public class TestCases {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static int cap;
	public static int num;
	public static List<String> result = new ArrayList<String>();
	public static String convertcs(List<Character> in) {
		String convert = in.toString();
		convert = convert.replaceAll("\\[", "");
		convert = convert.replaceAll("\\]", "");
		convert = convert.replaceAll(",", "");
		convert = convert.replaceAll(" ", "");
		return convert;
	}
	public static void comb(List<Character> spin, int current, List<List<Character>> in) {
		if(current == num || spin.size() == cap) {
			return;
		}
		for(int i = 0; i<in.get(current).size(); i++) {
			spin.add(in.get(current).get(i));
			result.add(convertcs(spin));
			comb(spin,current+1,in);
			spin.remove(spin.size()-1);
		}
		comb(spin,current+1,in);
	}
	public static void main(String[] args) throws IOException{
		num = readInt();
		cap = readInt();
		List<Character> spin = new ArrayList<Character>();
		List<List<Character>> in = new ArrayList<List<Character>>();
		for(int j = 0; j<num; j++) {
		List<Character> input = new ArrayList<Character>();
		int a = readInt();
		for(int i = 0; i<a; i++) {
		input.add(readCharacter());
		}
		in.add(input);
		}
		for(int i = 0; i<in.get(0).size(); i++) {
			spin.add(in.get(0).get(i));
			result.add(convertcs(spin));
			comb(spin,1,in);
			spin.remove(spin.size()-1);
		}
		Collections.sort(result);
		for(int i = 0; i<result.size(); i++) {
			System.out.println(result.get(i));
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