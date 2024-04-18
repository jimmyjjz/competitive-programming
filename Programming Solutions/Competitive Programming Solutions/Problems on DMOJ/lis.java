import java.util.*;
import java.io.*;
public class LIS{
	public static int binarysearchfirst(Vector<Integer> piles, int n) {
	    int low = 0, high = piles.size()-1;
	    while(low<=high){
	        int mid=(low+high)/2;
	        try{if(piles.get(mid)>=n&&piles.get(mid-1)<n)return mid;}
	        catch(Exception e) {return mid;}
	        if(piles.get(mid)<n)low=mid+1;
	        else high = mid-1;
	    }
	    return high+1;
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt();
		Vector<Integer> piles = new Vector<Integer>(N);
		for(int i = 0; i<N; i++) {
			int cur = readInt(), bs = binarysearchfirst(piles,cur);
			if(bs==piles.size())piles.add(cur);
			else piles.set(bs,cur);
		}
		System.out.println(piles.size());
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