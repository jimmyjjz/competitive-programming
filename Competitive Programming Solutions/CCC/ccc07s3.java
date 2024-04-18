import java.util.*;
import java.io.*;
public class Friend {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
	int N = readInt();
	Map<Integer,List<Integer>> tree = new HashMap<Integer,List<Integer>>();
	for(int i = 0; i<N; i++) {
		int a = readInt(), b = readInt();
		if(tree.get(a)==null)tree.put(a, new ArrayList<Integer>());
		List<Integer> insert = new ArrayList<Integer>(tree.get(a));
		insert.add(b);
		tree.put(a, insert);
	}
	int a = readInt(), b = readInt();
	while(a!=0||b!=0) {
		int moves = 0;
		boolean found = true;
		Set<Integer> insert = new HashSet<Integer>();
		List<Integer> valid = new ArrayList<Integer>();
		insert.add(a);
		out:{
		while(found) {
		List<Integer> current = new ArrayList<Integer>(insert);
		insert.clear();
		found = false;
		int fixed = current.size();
		for(int i = 0; i<fixed; i++) {
			if(!valid.contains(current.get(i))) {
			found = true;
			valid.add(current.get(i));
			List<Integer> in = new ArrayList<Integer>(tree.get(current.get(i)));
			int size = in.size();
			for(int j = 0; j<size; j++) {
				if(in.get(j)==b) {
					System.out.println("Yes "+moves);
					break out;
				}
				insert.add(in.get(j));
				
			}
			}
		}
		moves++;
		}
		System.out.println("No");
		}
		a = readInt();
		b = readInt();
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