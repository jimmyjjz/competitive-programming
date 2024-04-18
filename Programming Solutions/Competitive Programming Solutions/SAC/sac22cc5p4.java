import java.util.*;
import java.io.*;
public class QueryingIntervals{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static class interval{
		int l,r;
		public interval(int l, int r) {
			this.l=l;
			this.r=r;
		}
	}
	static class Sortbyl implements Comparator<interval>{
		public int compare(interval a, interval b) {
			return -Integer.compare(a.l,b.l);
		}
	}
	public static int binarysearch(List<Integer> li, int n) {
		int low = 0, high = li.size()-1;
		while(high>=low) {
			int mid = (high+low)/2;
			if(li.get(mid)==n)return mid;
			else if(li.get(mid)>n)high=mid-1;
			else low=mid+1;
		}
		return high+1;
	}
	public static void main(String[] args) throws IOException{
		int N = readInt(), Q = readInt();
		Stack<interval> ranges = new Stack<interval>();
		for(int i = 0; i<N; i++)ranges.add(new interval(readInt(),readInt()));
		Collections.sort(ranges, new Sortbyl());
		List<Integer> deadzone = new ArrayList<Integer>();
		Set<Integer> deadindex = new HashSet<Integer>();
		int top = -1000000001;
		while(true) {
			while(!ranges.isEmpty()&&ranges.peek().l<=top+1)top=Math.max(top,ranges.pop().r);
			if(ranges.isEmpty())break;
			deadzone.add(top+1);
			deadindex.add(deadzone.size());
			deadzone.add(ranges.peek().l-1);
			top=ranges.pop().r;
		}
		deadzone.add(top+1);
		deadindex.add(deadzone.size());
		deadzone.add(1000000001);
		for(int i = 0; i<Q; i++) {
			int a = readInt(), b = readInt(), bsa = binarysearch(deadzone,a), bsb = binarysearch(deadzone,b);
			System.out.println(a!=deadzone.get(bsa)&&b!=deadzone.get(bsb)&&!deadindex.contains(bsa)&&bsa==bsb?"Y":"N");
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