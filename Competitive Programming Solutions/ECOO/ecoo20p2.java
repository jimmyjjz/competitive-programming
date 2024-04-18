import java.util.*;
import java.io.*;
public class ShoppingOnline {
	static class item{
		String name;
		int cost, stock;
		public item(String name, int cost, int stock) {
        	this.name = name;
        	this.cost = cost;
        	this.stock = stock;
        }
	}
	static class SortbyCost implements Comparator<item> {
        public int compare(item a, item b) { 
                return Integer.compare(a.cost, b.cost);           
        }
    }
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
	int T = readInt();
	for(int i = 0; i<T; i++) {
		Map<String,Integer> want = new HashMap<String,Integer>();
		List<item> catalog = new ArrayList<item>();
		int N = readInt();
		for(int j = 0; j<N; j++) {
			int M = readInt();
			for(int k = 0; k<M; k++) {
				catalog.add(new item(next(), readInt(), readInt()));
			}
		}
		int K = readInt();
		for(int j = 0; j<K; j++) {
			want.put(next(),readInt());
		}
		Collections.sort(catalog, new SortbyCost());
		int total = 0;
		for(int j = 0; j<catalog.size(); j++) {
			if(want.get(catalog.get(j).name) != null) {
			if(want.get(catalog.get(j).name) != 0){
				if(want.get(catalog.get(j).name) > catalog.get(j).stock) {
					total+=catalog.get(j).cost*catalog.get(j).stock;
					want.put(catalog.get(j).name, want.get(catalog.get(j).name)-catalog.get(j).stock);
				}
				else if(want.get(catalog.get(j).name) <= catalog.get(j).stock) {
					total+=want.get(catalog.get(j).name)*catalog.get(j).cost;
					want.put(catalog.get(j).name, 0);
				}
			}
			}
		}
		System.out.println(total);
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