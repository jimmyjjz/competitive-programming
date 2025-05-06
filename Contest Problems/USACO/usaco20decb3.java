import java.util.*;
import java.io.*;
public class StuckInARut {
	public static int contact(int xa, int ya, int xb, int yb) {
		if(xb>xa&&yb<ya) {
			if((ya-yb)>(xb-xa))return 1;
			if((ya-yb)<(xb-xa))return 2;
		}
		return 0;
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt();
		int[][] cows = new int[N][2];
		int[] dis = new int[N];
		TreeMap<Integer,Integer> East = new TreeMap<Integer,Integer>();
		TreeMap<Integer,Integer> North = new TreeMap<Integer,Integer>();
		for(int i = 0; i<N; i++) {
			char d = readCharacter();
			int x = readInt(), y = readInt();
			if(d == 'E') East.put(y,i);
			else North.put(x,i);
			cows[i][0]=x;
			cows[i][1]=y;
		}
		int fixed = North.size();
		while(true) {
			int a = East.firstKey(),b = North.firstKey(),c = North.get(North.firstKey()),d = East.get(East.firstKey());
			out:	
			for(int i = 0; i<fixed; i++) {
				switch(contact(cows[d][0],cows[d][1],cows[c][0],cows[c][1])) {
				case 1: {
					dis[c]=cows[d][1]-cows[c][1];
					North.remove(b);
					if(fixed-1!=i) {
						b=North.higherKey(b);
						c=North.get(b);
					}
					break;
				}
				case 2:{
					dis[d]=cows[c][0]-cows[d][0];
					East.remove(a);
					break out;
				}
				case 0:{
					East.remove(a);
					if(i!=fixed-1) {
						b=North.higherKey(b);
						c = North.get(b);
					}
					break;
				}
				}
			}
			fixed=North.size();
			if(North.isEmpty() || East.isEmpty()) {
				break;
			}
		}
		for(int i = 0; i<N; i++) {
			if(dis[i]==0) {
				System.out.println("Infinity");
			}
			else {
				System.out.println(dis[i]);
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