import java.util.*;
import java.io.*;
public class KnightHop {
	static class pos{
		int x,y;
		public pos(int x, int y) {
			this.x=x;
			this.y=y;
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		List<String> encountered = new ArrayList<String>();
		Set<pos> insert = new HashSet<pos>();
		insert.add(new pos(readInt(),readInt()));
		int Ex = readInt(), Ey = readInt(), moves = -1;
		while(true) {
			moves++;
			List<pos> current = new ArrayList<pos>(insert);
			insert.clear();
			for(int i = 0; i<current.size(); i++) {
			if(current.get(i).x < 1 || current.get(i).y < 1 || current.get(i).x > 8 || current.get(i).y > 8 || encountered.contains(current.get(i).x+""+current.get(i).y)) {
				continue;
			}
			if(current.get(i).x == Ex && current.get(i).y == Ey) {
				System.out.println(moves);
				return;
			}
			encountered.add(current.get(i).x+""+current.get(i).y);
			insert.add(new pos(current.get(i).x-1,current.get(i).y+2));
			insert.add(new pos(current.get(i).x+1,current.get(i).y+2));
			insert.add(new pos(current.get(i).x-2,current.get(i).y+1));
			insert.add(new pos(current.get(i).x+2,current.get(i).y+1));
			insert.add(new pos(current.get(i).x-2,current.get(i).y-1));
			insert.add(new pos(current.get(i).x+2,current.get(i).y-1));
			insert.add(new pos(current.get(i).x-1,current.get(i).y-2));
			insert.add(new pos(current.get(i).x+1,current.get(i).y-2));
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