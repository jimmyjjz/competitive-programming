import java.util.*;
import java.io.*;
public class BabblingBrooks {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		LinkedList<Double> streams = new LinkedList<Double>();
		int N = readInt(), in = 0, index;
		double percent, save;
		for(int i = 0; i<N; i++) {
			streams.add((double)readInt());
		}
		while(true) {
			in = readInt();
			if(in == 77) {
				break;
			}
			else if(in == 88) {//join
				index = readInt()-1;
				save = streams.remove(index);
				streams.add(index,save+streams.remove(index));
			}
			else if(in == 99) {//split
				index = readInt()-1;
				percent = readInt();
				save = streams.remove(index);
				streams.add(index, (save*(1-(percent/100.00))));
				streams.add(index, (save*(percent/100.00)));
			}
		}
		for(int i = 0; i<streams.size(); i++){
			System.out.print(streams.get(i).intValue()+" ");
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