import java.util.*;
import java.io.*;
public class photoshoot {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static boolean check(boolean[] in, int len) {
		for(int i = 1; i<=len; i++) {
			if(!in[i]) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) throws IOException{
		List<Integer> out = new ArrayList<Integer>();
		int N = readInt();
		int[] store = new int[N];
		boolean[] encountered = new boolean[10001];
		for(int i = 0; i<N-1; i++) {
			store[i] = readInt();
		}
		for(int j = 1; j<=store[0]; j++) {
		out.clear();
		Arrays.fill(encountered, false);
		out.add(store[0]-j);
		encountered[store[0]-j]=true;
		if(encountered[j]){
			continue;
		}
		out.add(j);
		encountered[j]=true;
		int forward = j;
		for(int i = 1; i<N-1; i++) {
			if(store[i]-forward < 1 || encountered[store[i]-forward]) {
				break;
			}
			out.add(store[i]-forward);
			encountered[store[i]-forward]=true;
			forward = store[i]-forward;
			if(i == N-2 && check(encountered,N)) {
				for(int k = 0; k<out.size(); k++) {
					System.out.print(out.get(k)+" ");
				}
				System.exit(0);
			}
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