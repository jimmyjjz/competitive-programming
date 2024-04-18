import java.util.*;
import java.io.*;
public class Shuffle {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		Deque<String> playlist = new LinkedList<String>();
		playlist.add("A");
		playlist.add("B");
		playlist.add("C");
		playlist.add("D");
		playlist.add("E");
		int input = 0, times = 0;
		String saveA = "";
		String saveB = "";
		while(input != 4){
			input = readInt();
			times = readInt();
			for(int i = 0; i<times; i++) {
			switch(input) {
			case 1:
				playlist.addLast(playlist.removeFirst());
				break;
			case 2 :
				playlist.addFirst(playlist.removeLast());
				break;
			case 3 :
				saveA = playlist.removeFirst();
				saveB = playlist.removeFirst();
				playlist.addFirst(saveA);
				playlist.addFirst(saveB);
				break;
			}
			}
			
		}
		System.out.print(playlist.removeFirst());
		for(int i = 1; i<5; i++) {
			System.out.print(" "+playlist.removeFirst());
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