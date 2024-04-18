import java.util.*;
import java.io.*;
public class bobkanpsack {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
	int N = readInt(), Q = readInt();
	List<Integer> input = new ArrayList<Integer>();
	long[] arr = new long[N];
	for(int i = 0; i<N; i++) {
		input.add(readInt());
	}
	Collections.sort(input);
	Collections.reverse(input);
	int cap = 0;
	arr[0] = input.get(0);
	for(int i = 1; i<N; i++) {
		if(input.get(i)<=0) {
			cap = i;
			break;
		}
		arr[i]=arr[i-1]+input.get(i);
	}
	for(int i = 0; i<Q; i++) {
		int in = readInt();
		if(in>cap) {
			System.out.println(arr[cap-1]);
			continue;
		}
		System.out.println(arr[in-1]);
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