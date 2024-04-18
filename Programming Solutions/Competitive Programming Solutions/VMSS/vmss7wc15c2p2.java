import java.util.*;
import java.io.*;
public class e4Nations1Secret{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int base = 31, mod = 1000000007, len;
	static long pow = 1;
	static String s,rev;
	static void setup(int len){for(int i = 1; i<len; i++)pow=(pow*base)%mod;}
	static long hashadd(long hash, char c){return(((hash*base)%mod)+(c-'A'+1))%mod;}
	static long hashsub(long hash, char c){return(((hash-(((c-'A'+1)*pow)%mod))%mod)+mod)%mod;}
	public static boolean exist(int size) {
		pow=1;
		setup(size);
		List<Long> hashes = new ArrayList<Long>();
		long hasha= 0, hashb = 0;
		for(int i = 0; i<size; i++)hasha=hashadd(hasha,s.charAt(i));
		hashes.add(hasha);
		for(int i = size; i<len; i++) {
			hasha=hashsub(hasha,s.charAt(i-size));
			hasha=hashadd(hasha,s.charAt(i));
			hashes.add(hasha);
		}
		for(int i = 0; i<size; i++)hashb=hashadd(hashb,rev.charAt(i));
		int back = hashes.size()-1;
		if(hashes.get(back)==hashb&&s.substring(len-size,len).equals(rev.substring(0,size)))return true;
		for(int i = size; i<len; i++) {
			back--;
			hashb=hashsub(hashb,rev.charAt(i-size));
			hashb=hashadd(hashb,rev.charAt(i));
			if(hashes.get(back)==hashb&&s.substring(len-(i+1),len-(i-size+1)).equals(rev.substring(i-size+1,i+1)))return true;
		}
		return false;
	}
	public static String find(int size) {
		pow=1;
		setup(size);
		List<Long> hashes = new ArrayList<Long>();
		long hasha= 0, hashb = 0;
		for(int i = 0; i<size; i++)hasha=hashadd(hasha,s.charAt(i));
		hashes.add(hasha);
		for(int i = size; i<len; i++) {
			hasha=hashsub(hasha,s.charAt(i-size));
			hasha=hashadd(hasha,s.charAt(i));
			hashes.add(hasha);
		}
		for(int i = 0; i<size; i++)hashb=hashadd(hashb,rev.charAt(i));
		int back = hashes.size()-1;
		String closest = "";
		if(hashes.get(back)==hashb&&s.substring(len-size,len).equals(rev.substring(0,size)))closest=rev.substring(0,size);
		for(int i = size; i<len; i++) {
			back--;
			hashb=hashsub(hashb,rev.charAt(i-size));
			hashb=hashadd(hashb,rev.charAt(i));
			if(hashes.get(back)==hashb&&s.substring(len-(i+1),len-(i-size+1)).equals(rev.substring(i-size+1,i+1)))closest=rev.substring(i-size+1,i+1);
		}
		return closest;
	}
	public static void main(String[] args) throws IOException{
		len=readInt();
		s=readLine();
		rev=new StringBuilder(s).reverse().toString();
		List<Integer> odd = new ArrayList<Integer>(), even = new ArrayList<Integer>();
		for(int i = 1; i<=len; i+=2)odd.add(i);
		for(int i = 0; i<=len; i+=2)even.add(i);
		int low = 0, high = odd.size()-1, max = 0;
		while(low<=high) {
			int mid = (low+high)/2;
			if(exist(odd.get(mid)))low=mid+1;
			else high=mid-1;
		}
		max=Math.max(max,odd.get(high));
		low = 0;
		high = even.size()-1;
		while(low<=high) {
			int mid = (low+high)/2;
			if(exist(even.get(mid)))low=mid+1;
			else high=mid-1;
		}
		max=Math.max(max,high==-1?0:even.get(high));
		System.out.println(find(max));
		System.out.println(max);
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