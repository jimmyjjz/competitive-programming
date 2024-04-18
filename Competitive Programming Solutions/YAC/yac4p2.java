import java.util.*;
import java.io.*;
public class Alchemy2{
	static class stat{
		int e,v;
		public stat(int e, int v) {
			this.e=e;
			this.v=v;
		}
	}
	static class SortbyV implements Comparator<stat>{
		public int compare(stat a, stat b) {
			return Integer.compare(a.v,b.v);
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), target[] = new int[N+1],link[] = new int[N+1], fre[] = new int[N+1];
		LinkedList<stat> elements = new LinkedList<stat>();
		for(int i = 1; i<=N; i++) {
			int in = readInt();
			fre[in]++;
			elements.add(new stat(i,in));
		}
		Collections.sort(elements, new SortbyV());
		while(!elements.isEmpty()) {
			if(target[elements.peek().v-1]!=0) {
				target[elements.peek().v]=elements.peek().e;
				link[elements.peek().e]=target[elements.poll().v-1];
			}
			else {
				int min = elements.peek().v;
				if(fre[min]%min!=0) {
					System.out.println(-1);
					return;
				}
				for(int i = 0; i<fre[min]/min; i++) {
					int temp = elements.poll().e, pre = temp;
					for(int j = 1; j<min; j++) {
						int cur = elements.poll().e;
						link[pre]=cur;
						pre=cur;
					}
					link[pre]=temp;
					target[min]=temp;
				}
			}
		}
		for(int i = 1; i<=N; i++)System.out.print(link[i]+" ");
		System.out.println();
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