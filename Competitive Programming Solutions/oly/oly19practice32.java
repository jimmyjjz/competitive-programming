import java.util.*;
import java.io.*;
public class tourney {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		StringTokenizer split = new StringTokenizer(readLine(), " ");
		int people = Integer.parseInt(split.nextToken());
		int pass = Integer.parseInt(split.nextToken());
		String savea = "";
		String saveb = "";
		String biggest = "";
		int big = 0;
		String zero = "";
		List<String> all = new ArrayList<String>();
		String save = "";
		for(int i = 0; i<people; i++) {
			StringTokenizer cut = new StringTokenizer(readLine(), " ");
			savea = cut.nextToken();
			saveb = cut.nextToken();
			for(int j = 0; j<9-savea.length(); j++) {
				zero = zero + "0";
			}
			savea = zero + savea;
			zero = "";
			for(int k = 0; k<9-saveb.length(); k++) {
				zero = zero + "0";
			}
			saveb = zero + saveb;
			zero = "";
			all.add(savea+" "+saveb);
		}
		List<String> Ori= new ArrayList<String>(all);
		Collections.sort(all);
		for(int z = 0; z<people-pass; z++){
			all.remove(0);
		}
		for(int x = 0; x<all.size(); x++) {
			StringTokenizer slice = new StringTokenizer(all.get(x), " ");
			saveb = slice.nextToken();
			savea = slice.nextToken();
			if(Integer.parseInt(savea) > big) {
				biggest = savea;
				big = Integer.parseInt(savea);
				save = saveb;
			}
		}
		System.out.println(Ori.indexOf(save+" "+biggest)+1);
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