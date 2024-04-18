import java.util.*;
import java.io.*;
public class SwapitySwapitySwap {
	static class part{
		int n;
		int[] vals;
		public part(int n, int[] vals) {
			this.n=n;
			this.vals=vals;
		}
	}
	public static void swap(int l, int r, int[] cows) {
		int[] temp = cows.clone();
		int dex = l;
		for(int i = r; i>=l; i--) {
			cows[i]=temp[dex];
			dex++;
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), M = readInt(), K = readInt();
		List<part> search = new ArrayList<part>();
		int[] ori = new int[N];
		for(int i = 0; i<N; i++) {
			ori[i]=i+1;
		}
		int[] process = ori.clone();
		for(int i = 0; i<M; i++) {
			swap(readInt()-1, readInt()-1, ori);
		}
		//System.out.println(Arrays.toString(order));
		int cnt = 1;
		while(cnt<=K){
			search.add(new part(cnt,ori.clone()));
			int[] clone = ori.clone();
			for(int j = 0; j<N; j++) {
				ori[j]=clone[clone[j]-1];
			}
			cnt*=2;
		}
		int dex = search.size()-1;
		while(K!=0) {
			if(K/search.get(dex).n>0) {
				K-=search.get(dex).n;
				int[] clone = search.get(dex).vals.clone();
				int[] save = process.clone();
				for(int i = 0; i<N; i++) {
					process[i]=save[clone[i]-1];
				}
			}
			else {
				dex--;
			}
		}
		for(int n : process) {
			System.out.println(n);
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