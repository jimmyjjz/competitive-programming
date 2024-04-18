import java.util.*;
import java.io.*;
public class PMS {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int L = readInt();
		for(int i = 0; i<L; i++) {
			int N = readInt();
			Map<String,List<String>> tree = new HashMap<String,List<String>>();
			List<String> unique = new ArrayList<String>();
			String old = readLine(),in = "";
			for(int j = 0; j<N-1; j++) {
				in = readLine();
				if(tree.get(old)==null){
					unique.add(old);
					tree.put(old, new ArrayList<String>());
				}
				List<String> insert = new ArrayList<String>(tree.get(old));
				if(!insert.contains(in)) {
				insert.add(in);
				tree.put(old, insert);
				}
				if(tree.get(in)==null){
					unique.add(in);
					tree.put(in, new ArrayList<String>());
				}
				insert = new ArrayList<String>(tree.get(in));
				if(!insert.contains(old)) {
				insert.add(old);
				tree.put(in, insert);
				}
				old=in;
			}
				//System.out.println(tree);
				Set<String> insert = new HashSet<String>();
				List<String> valid = new ArrayList<String>();
				int moves = 0;
				insert.add(in);
				space:{
				while(true) {
					List<String> current = new ArrayList<String>(insert);
					insert.clear();
					int fixed = current.size();
					for(int k = 0; k<fixed; k++) {
						if(!valid.contains(current.get(k))) {
							valid.add(current.get(k));
							if(valid.size()==unique.size()) {
								System.out.println((N*10)-(moves*20));
								break space;
							}
							List<String> out = new ArrayList<String>(tree.get(current.get(k)));
							int whole = out.size();
							for(int z = 0; z<whole; z++) {
								insert.add(out.get(z));
							}
						}
					}
					moves++;
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