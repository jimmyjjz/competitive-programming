import java.util.*;
import java.io.*;
public class Bus {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), Q = readInt();
		int[] sort = new int[N];
		for(int i = 0; i<N; i++) {
			sort[i] = readInt();
		}
		Arrays.sort(sort);
		int min, max,bottom,top;
		for(int i = 0; i<Q; i++) {
			min = readInt();
			max = readInt();
			bottom = 0;
			top = N-1;
			if (sort[N-1] < min || sort[0] > max) {
				System.out.println("0");
	            continue;
	            }
		    while (bottom<=top){
		        int mid = bottom+((top-bottom)/2);
		        if(sort[mid] >= min) {
		        	top = mid-1;
		        }
		        else {
		        	bottom = mid+1;
		        }
		    }
		    min = top+1;
		    bottom = 0;
		    top = N-1;
		    while (bottom<=top){
		        int mid = bottom+((top-bottom)/2);
		        if(sort[mid] > max) {
		        	top = mid-1;
		        }
		        else {
		        	bottom = mid+1;
		        }
		    }
		    max = bottom-1;
		    System.out.println((max-min)+1);
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