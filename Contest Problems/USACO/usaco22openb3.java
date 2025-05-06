import java.util.*;
import java.io.*;
public class Alchemy{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static Map<Integer, List<Integer>> formula = new HashMap<Integer, List<Integer>>();
	public static int[] mats;
	public static boolean r(int head, int amount) {
		if(formula.get(head)==null)return false;
		for(int i : formula.get(head)) {
			if(mats[i]>=amount)mats[i]-=amount;
			else{
				int temp = mats[i];
				mats[i]=0;
				if(r(i,amount-temp))continue;
				else return false;
			}
		}
		return true;
	}
	public static void main(String[] args) throws IOException{
		int N = readInt();
		int[] materials = new int[N+1];
		for(int i = 1; i<=N; i++)materials[i]=readInt();
		int M = readInt();
		for(int i = 0; i<M; i++) {
			int h = readInt(), K = readInt();
			List<Integer> mold = new ArrayList<Integer>();
			for(int j = 0; j<K; j++)mold.add(readInt());
			formula.put(h,mold);
		}
		int high = 1000000, low = 0;
		while(true) {
			int mid = (high+low)/2;
			mats = materials.clone();
			boolean now = r(N, mid);
			if(now)low=mid;
			else high=mid;
			if((high+low)/2==mid) {
				System.out.println(materials[N]+mid);
				return;
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