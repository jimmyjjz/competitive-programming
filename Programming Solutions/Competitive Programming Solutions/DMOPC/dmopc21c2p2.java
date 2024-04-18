import java.util.*;
import java.io.*;
public class Swapping {
	public static int ArrDex(int[] in, int tar) {
		int fixed = in.length;
		for(int i = 0; i<fixed; i++) {
			if(in[i] == tar) {
				return i;
			}
		}
		return -1;
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), Q = readInt();
		int[] plate = new int[N];
		for(int i = 1; i<=N; i++) {
			plate[i-1] = i;
		}
		for(int i = 0; i<Q; i++) {
			//System.out.println("Plate "+Arrays.toString(plate));
			char in = readCharacter();
			if(in == 'E') {
				int x = readInt(), y = readInt(), side = 0;
				side = ArrDex(plate,x);
				plate[ArrDex(plate, y)] = x;
				plate[side] = y;
			}
			else if(in == 'B') {
				int x = readInt(), y = readInt(), side = 0;
				side = plate[x-1];
				plate[x-1] = plate[y-1];
				plate[y-1] = side;
			}
			else {
				int[] display = new int[N];
				for(int j = 0; j<N; j++) {
					display[j] = readInt();
				}
				int[] out = new int[N];
				for(int j = 0; j<N; j++) {
					out[j] = display[plate[j]-1];
				}
				String s = Arrays.toString(out);
				s = s.substring(1,s.length()-1);
				System.out.println(s.replaceAll(",", ""));
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