import java.util.*;
import java.io.*;
public class AliceShopping {
	static class store {
        int loc;
        public store(int loc) {
        	this.loc = loc;
        }
    }
	 static class OriginSort implements Comparator<store> {
	        public int compare(store a, store b) { 
	                return Integer.compare(Math.abs(a.loc), Math.abs(b.loc));
	            }            
	        }
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int T = readInt(), N = readInt();
		List<store> place = new ArrayList<store>();
		for(int i = 0; i<N; i++) {
			place.add(new store(readInt()));
			}
		Collections.sort(place, new OriginSort());
		int total = 0, old = 0;
		for(int i = 0; i<place.size(); i++) {
			int ne = place.get(i).loc;
			if(ne < 0 && old < 0 || ne >= 0 && old >= 0) {
				T-=Math.abs(Math.abs(ne)-Math.abs(old));
			}
			else if(ne >= 0 && old < 0 || ne < 0 && old >= 0) {
				T-=Math.abs(ne)+Math.abs(old);
			}
			if(T >= 0) {
				old = ne;
				total++;
			}
			else {
				break;
			}
		}
		System.out.println(total);
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