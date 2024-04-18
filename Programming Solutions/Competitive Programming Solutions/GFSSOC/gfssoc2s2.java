import java.util.*;
import java.io.*;
public class Hearth {
	static class card{
		String name;
		int mana;
		public card(String name, int mana) {
			this.name=name;
			this.mana=mana;
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
	List<card> deck = new ArrayList<card>();
	Set<String> dupe = new HashSet<String>();
	int N = readInt(), T = readInt();
	for(int i = 0; i<N; i++) {
		deck.add(new card(next(), readInt()));
	}
	for(int i = 0; i<N; i++) {
		for(int j = 0; j<N; j++) {
			if(j == i) {
				continue;
			}
			
			for(int k = 0; k<N; k++) {
				if(k == i || k == j) {
					continue;
				}
				if(deck.get(i).mana+deck.get(j).mana+deck.get(k).mana <= T){
					List<String> sort = new ArrayList<String>();
					sort.add(deck.get(i).name);
					sort.add(deck.get(j).name);
					sort.add(deck.get(k).name);
					Collections.sort(sort);
					dupe.add(sort.get(0)+" "+sort.get(1)+" "+sort.get(2));
				}
			}
		}
	}
	List<String> out = new ArrayList<String>(dupe);
	Collections.sort(out);
	for(int i = 0; i<out.size(); i++) {
		System.out.println(out.get(i));
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