import java.util.*;
import java.io.*;
public class YearOfCow {
	static class info{
		String name,direction,year,from;
		public info(String name, String direction, String year, String from) {
			this.name=name;
			this.direction=direction;
			this.year=year;
			this.from=from;
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
	List<info> board = new ArrayList<info>();
	Map<String,Integer> animals = new HashMap<String,Integer>();
	Map<String,Integer> apart = new HashMap<String,Integer>();
	Map<String,String> born = new HashMap<String,String>();
	StringTokenizer cut = new StringTokenizer("Ox Tiger Rabbit Dragon Snake Horse Goat Monkey Rooster Dog Pig Rat");
	for(int i = 0; i<12; i++) {
		animals.put(cut.nextToken(),i);
	}
	int N = readInt();
	String a,b,c;
	for(int i = 0; i<N; i++) {
		StringTokenizer split = new StringTokenizer(readLine());
		a = split.nextToken();
		split.nextToken();
		split.nextToken();
		b = split.nextToken();
		c = split.nextToken();
		split.nextToken();
		split.nextToken();
		board.add(new info(a,b,c,split.nextToken()));
	}
	//System.out.println(animals);
	born.put("Bessie", "Ox");
	apart.put("Bessie", 0);
	for(int i = 0; i<N; i++) {
		info save = board.get(i);
		born.put(save.name, save.year);
		if(save.direction.equals("previous")) {
			if(animals.get(save.year)<animals.get(born.get(save.from))){
				apart.put(save.name,apart.get(save.from)+animals.get(born.get(save.from))-animals.get(save.year));
			}
			else if(animals.get(save.year)>animals.get(born.get(save.from))){
				apart.put(save.name,apart.get(save.from)+(12-animals.get(save.year))+animals.get(born.get(save.from)));
			}
			else{
				apart.put(save.name,apart.get(save.from)+12);
			}
		}
		else {
			if(animals.get(save.year)<animals.get(born.get(save.from))){
				apart.put(save.name,apart.get(save.from)-(12-animals.get(born.get(save.from))+animals.get(save.year)));
			}
			else if(animals.get(save.year)>animals.get(born.get(save.from))){
				apart.put(save.name,apart.get(save.from)-(animals.get(save.year)-animals.get(born.get(save.from))));
			}
			else{
				apart.put(save.name,apart.get(save.from)-12);
			}
		}
	}
	//System.out.println(apart);
	System.out.println(Math.abs(apart.get("Elsie")));
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