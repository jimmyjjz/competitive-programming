import java.util.*;
import java.io.*;
public class AllRoadsLeadWhere {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		Map<String,List<String>> tree = new HashMap<String,List<String>>();
		int N = readInt(), Q = readInt();
		for(int i = 0; i<N; i++) {
			String a = next(), b = next();
			if(tree.get(a)==null) tree.put(a, new ArrayList<String>());
			List<String> insert = new ArrayList<String>(tree.get(a));
			insert.add(b);
			tree.put(a, insert);
			if(tree.get(b)==null) tree.put(b, new ArrayList<String>());
			insert = new ArrayList<String>(tree.get(b));
			insert.add(a);
			tree.put(b, insert);
		}
		for(int i = 0; i<Q; i++) {
			String a = next(), b = next();
			Stack<String> current = new Stack<String>();
			List<String> valid = new ArrayList<String>();
			current.push(a);
			valid.add(a);
			out:{
			while(true) {
			for(int j = 0; j<tree.get(current.peek()).size(); j++) {
				if(!valid.contains(tree.get(current.peek()).get(j))) {
					valid.add(tree.get(current.peek()).get(j));
					current.push(tree.get(current.peek()).get(j));
				j=-1;
				if(current.peek().equals(b)) {
					Collections.reverse(current);
					int fixed = current.size();
					for(int k = 0; k<fixed; k++) {
						System.out.print(current.pop().charAt(0));
					}
					System.out.println();
					break out;
				}
				}
			}
			current.pop();
			}
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