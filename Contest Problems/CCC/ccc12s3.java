import java.util.*;
import java.io.*;
public class AbsolutelyAcidic {
	static class popular{
		int num,amount;
		public popular(int num, int amount) {
			this.num=num;
			this.amount=amount;
		}
	}
	static class SortbyAmountAndValue implements Comparator<popular>{
		public int compare(popular a, popular b) {
			return -Integer.compare(a.amount,b.amount);
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int[] r = new int[1001];
		int N = readInt();
		for(int i = 0; i<N; i++) {
			int n = readInt();
			r[n]++;
			//System.out.print(n+" ");
		}
		List<popular> fre = new ArrayList<popular>();
		for(int i = 0; i<1000; i++) {
			fre.add(new popular(i,r[i]));
		}
		Collections.sort(fre, new SortbyAmountAndValue());
		int bar = fre.get(0).amount;
		List<Integer> compare = new ArrayList<Integer>();
		for(int i = 0; i<1000; i++) {
			if(fre.get(i).amount==bar) {
				compare.add(fre.get(i).num);
			}
			else break;
		}
		if(compare.size()>1) {
			Collections.sort(compare);
			//System.out.println(compare);
			System.out.println(compare.get(compare.size()-1)-compare.get(0));
		}
		else {
			int max = 0;
			bar = fre.get(1).amount;
			for(int i = 1; i<1000; i++) {
				if(fre.get(i).amount==bar) {
					max = Math.max(max, Math.abs(compare.get(0)-fre.get(i).num));
				}
				else break;
			}
			System.out.println(max);
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