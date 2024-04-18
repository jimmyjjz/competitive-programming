import java.util.*;
import java.io.*;
public class LC {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt();
		int space = 1000000010;
		int young = 1000001;
		long[] le = new long[young];
		long[] ri = new long[young];
		boolean mode = true;
		Map<Integer,Integer> left = new HashMap<Integer,Integer>();
		Map<Integer,Integer> right = new HashMap<Integer,Integer>();
		List<Integer> Ljump = new ArrayList<Integer>();
		Stack<Integer> jump = new Stack<Integer>();
		for(int i = 0; i<N; i++) {
			int P = readInt(), W = readInt(), D = readInt();
			try {
			if(mode) {
			if(P-D>0)le[P-D-1]+=W;
			if(P+D<(young-1))ri[P+D+1]+=W;
			}
			}
			catch(Exception e) {mode = false;}
			if(left.get(P-D-1)==null) {
				left.put(P-D-1,0);
				if(P-D-1>=0) {
					Ljump.add(P-D-1);
					jump.push(P-D-1);
				}
			}
			left.put(P-D-1,left.get(P-D-1)+W);
			if(right.get(P+D+1)==null) {
				right.put(P+D+1,0);
				if(P+D+1<space)jump.push(P+D+1);
			}
			right.put(P+D+1,right.get(P+D+1)+W);
		}
		if(!mode) {
		Collections.sort(Ljump);
		Collections.reverse(Ljump);
		if(!Ljump.contains(0))Ljump.add(0);
		long min = Long.MAX_VALUE;
		long increl = 0, l = 0, cur = space;
		for(int d : Ljump) {
			l+=increl*(cur-d);
			cur = d;
			if(left.get(d)!=null) {
				increl+=left.get(d);
				l+=left.get(d);
			}
		}
		long increr = 0, r = 0;
		min = Math.min(min, l+r);
		Collections.sort(jump);
		Collections.reverse(jump);
		int i = 0;
		//System.out.println(jump);
		while(true) {
			for(int j =i; j<=i+3; j++) {
			if(right.get(j)!=null)increr+=right.get(j);
			r+=increr;
			min = Math.min(min, l+r);
			//System.out.println(j+" "+l+" "+r);
			l-=increl;
			if(left.get(j)!=null)increl-=left.get(j);
			}
			i+=3;
			while(!jump.isEmpty()&&i>=jump.peek()) {
				jump.pop();
			}
			if(jump.isEmpty()) {
				break;
			}
			//System.out.println(">>>>>>> "+i+" "+jump.peek()+" "+(jump.peek()-i-1));
			//System.out.println(">>>>>>> "+increl+" "+increr);
			l-=(increl*(jump.peek()-i-2));
			r+=(increr*(jump.peek()-i-2));
			i=jump.peek()-1;
			//System.out.println(jump);
			
		}
		System.out.println(min);
		}
		else {
			long min = Long.MAX_VALUE;
			long increl = 0, l = le[young-1];
			for(int i = young-2; i>=0; i--) {
				if(le[i]!=0)increl+=le[i];
				l+=increl;
			}
			long increr = 0, r = ri[0];
			//System.out.println(l+" "+r);
			min = Math.min(min, l+r);
			for(int i = 0; i<young-1; i++) {
				if(ri[i]!=0)increr+=ri[i];
				r+=increr;
				min = Math.min(min, l+r);
				//System.out.println(i+" "+l+" "+r);
				l-=increl;
				if(le[i]!=0)increl-=le[i];
			}
			System.out.println(min);
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