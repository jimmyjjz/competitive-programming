import java.util.*;
import java.io.*;
public class PalindromicNumbers{
	public static int binarysearch(List<Long> piles, long n) {
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
	static List<Long> palindromes = new ArrayList<Long>();
	public static void r(String s, int n) {
		palindromes.add(Long.parseLong(s+new StringBuilder(s).reverse().toString()));
		palindromes.add(Long.parseLong(s+new StringBuilder(s).reverse().toString().substring(1,s.length())));
			if(n==6)return;
			r(s+"0",n+1);
			r(s+"1",n+1);
			r(s+"2",n+1);
			r(s+"3",n+1);
			r(s+"4",n+1);
			r(s+"5",n+1);
			r(s+"6",n+1);
			r(s+"7",n+1);
			r(s+"8",n+1);
			r(s+"9",n+1);
	}
	public static void main(String[] args) throws IOException{
		long L = readLong(), R = readLong();
		r("1",1);r("2",1);r("3",1);r("4",1);r("5",1);r("6",1);r("7",1);r("8",1);r("9",1);
		Collections.sort(palindromes);
		System.out.println(binarysearch(palindromes,R)-binarysearch(palindromes,L));
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