import java.util.*;
import java.io.*;
public class playdough {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		Map<Long,Long> dough = new HashMap<Long,Long>();
		int N = readInt();
		int Q = readInt();
		long save = 0;
		for(int i = 0; i<N; i++) {
			save = readLong();
			if(dough.get(save) == null) {
				dough.put(save, (long) 0);
			}
			dough.put(save, dough.get(save)+1);
		}
		for(int i = 0; i<Q; i++) {
			if(readInt() == 1) {
				save = readLong();
				if(save%2==0 && dough.get(save) != null) {
					if(dough.get(save/2) == null) {
						dough.put(save/2, (long) 0);
					}
					dough.put(save/2, dough.get(save/2)+dough.get(save)*2);
					dough.put(save, (long) 0);
				}
				else if(dough.get(save) != null){
					if(dough.get((long)Math.floor((double)save/2)) == null) {
						dough.put((long)Math.floor((double)save/2), (long) 0);
					}
					dough.put((long)Math.floor((double)save/2), dough.get((long)Math.floor((double)save/2))+dough.get(save));
					if(dough.get((long)Math.ceil((double)save/2)) == null) {
						dough.put((long)Math.ceil((double)save/2), (long) 0);
					}
					dough.put((long)Math.ceil((double)save/2), dough.get((long)Math.ceil((double)save/2))+dough.get(save));
					dough.put(save, (long) 0);
				}
			}
			else {
				save = readLong();
				if(dough.get(save) == null) {
					dough.put(save,(long)0);
				}
				System.out.println(dough.get(save));
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