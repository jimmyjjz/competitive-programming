import java.util.*;
import java.io.*;
public class LazySort{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int T = readInt();
		for(int i = 1; i<=T; i++) {
			int N = readInt();
			boolean can = false;
			Set<Integer> able = new HashSet<Integer>();
			Deque<Integer> ori = new LinkedList<Integer>();
			for(int j = 0; j<N; j++)ori.add(readInt());
			Deque<Integer> pile = new LinkedList<Integer>(ori);
			able.add(pile.peekFirst()-1);
			able.add(pile.pollFirst()+1);
			out:{
			while(!pile.isEmpty()){
				if(able.contains(pile.peekFirst())) {
					able.add(pile.peekFirst()-1);
					able.add(pile.pollFirst()+1);
				}
				else if(able.contains(pile.peekLast())) {
					able.add(pile.peekLast()-1);
					able.add(pile.pollLast()+1);
				}
				else break out;
			}
			can = true;
			}
			pile = new LinkedList<Integer>(ori);
			able.clear();
			able.add(pile.peekLast()-1);
			able.add(pile.pollLast()+1);
			out:{
			while(!pile.isEmpty()){
				if(able.contains(pile.peekFirst())) {
					able.add(pile.peekFirst()-1);
					able.add(pile.pollFirst()+1);
				}
				else if(able.contains(pile.peekLast())) {
					able.add(pile.peekLast()-1);
					able.add(pile.pollLast()+1);
				}
				else break out;
			}
			can = true;
			}
			System.out.println(can?"Case #"+i+": "+"yes":"Case #"+i+": "+"no");
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