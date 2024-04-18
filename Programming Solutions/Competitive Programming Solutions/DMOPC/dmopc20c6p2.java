import java.util.*;
import java.io.*;
public class InterpretiveArt {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		List<String> brushes = new ArrayList<String>();
		List<Integer> stock = new ArrayList<Integer>();
		List<Integer> place = new ArrayList<Integer>();
		List<Integer> amount = new ArrayList<Integer>();
		int N = readInt();
		int save;
		int[] current = new int[N];
		int[] target = new int[N];
		for(int i = 0; i<N; i++) {
			save = readInt();
			if(save == 0) {
				stock.add(i);
			}
			current[i] = save;
		}
		int back = readInt(), num = 0;
		target[0] = back;
		for(int i = 1; i<N; i++) {
			save = readInt();
			target[i] = save;
			if(back == 0) {
				num++;
				if(save == 1) {
				place.add(i);
				amount.add(num);
				num = 0;
			}
			}
			back = save;
		}
	int zerocnt = 0;
	for(int i = 0; i<N; i++) {
		if(current[i] == 0) {
			zerocnt++;
		}
		if(target[i] == 0) {
			zerocnt--;
		}
		if(zerocnt > 0) {
			System.out.println("-1");
			return;
		}
	}
	if(zerocnt != 0) {
		System.out.println("-1");
		return;
	}
	/*
	System.out.println(place);
	System.out.println(amount);
	System.out.println(stock);
	*/
	int total = -1;
	for(int i = 0; i<place.size(); i++) {
		total += amount.get(i);
		/*
		System.out.println("_______________________");
		System.out.println(place.get(i));
		System.out.println(amount.get(i));
		System.out.println(stock.get(total));
		System.out.println(total);
		*/
		if(place.get(i)-1 == (stock.get(total))) {
			continue;
		}
		brushes.add((place.get(i)-amount.get(i)+1)+" "+(stock.get(total)+1));
	}
	//System.out.println("_______________________");
	System.out.println(brushes.size());
	for(int i = 0; i<brushes.size(); i++) {
	System.out.println(brushes.get(i));
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