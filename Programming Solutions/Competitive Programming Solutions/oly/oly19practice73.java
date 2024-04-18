import java.util.*;
import java.io.*;
public class ChristmasGifts {
	static class cost{
		int item,ship;
		public cost(int item, int ship) {
			this.item=item;
			this.ship=ship;
		}
	}
	static class Sortbyprice implements Comparator<cost>{
		public int compare(cost a, cost b) {
			return Integer.compare((a.item+a.ship),(b.item+b.ship));
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
	List<cost> pack = new ArrayList<cost>();
	int N = readInt(), budget = readInt();
	for(int i = 0; i<N; i++) {
		pack.add(new cost(readInt(),readInt()));
	}
	Collections.sort(pack, new Sortbyprice());
	//System.out.println(pack.get(0).item+" "+pack.get(0).ship+" - "+pack.get(1).item+" "+pack.get(1).ship);
	int dex = 0,max = 0;
	while(true) {
		if(dex!=pack.size() && budget-(pack.get(dex).item+pack.get(dex).ship) >= 0) {
			max = Math.max(max, pack.get(dex).item);
			budget-=(pack.get(dex).item+pack.get(dex).ship);
			dex++;
		}
		else {
			break;
		}
	}
	if(dex!=pack.size()){
	if((pack.get(dex).item/2)+pack.get(dex).ship <= budget || pack.get(dex).item+pack.get(dex).ship <= budget+(max/2)) {
		System.out.println(dex+1);
		return;
	}
	}
	System.out.println(dex);
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