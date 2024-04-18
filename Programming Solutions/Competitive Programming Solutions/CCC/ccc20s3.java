import java.util.*;
import java.io.*;
public class SearchingforStrings{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int base = 31;
	static long mod = 100000000007L,pow = 1;
	static void setup(int len){for(int i = 1; i<len; i++)pow=(pow*base)%mod;}
	static long hashaddordered(long hash, char c){return(((hash*base)%mod)+(c-'a'+1))%mod;}
	static long hashsubordered(long hash, char c){return(((hash-(((c-'a'+1)*pow)%mod))%mod)+mod)%mod;}
	static long hashadd(long hash, char c){return(((hash)%mod)+((c-'a'+1)*10007))%mod;}
	static long hashsub(long hash, char c){return(((hash-(((c-'a'+1)*10007)%mod))%mod)+mod)%mod;}
	public static void main(String[] args) throws IOException{
		String N = br.readLine(), M = br.readLine();
		int count[] = new int[26], section[] = new int[26], nlen = N.length(), mlen = M.length();
		long nhash = 0, mhash = 0, orderedhash = 0;
		setup(nlen);
		if(nlen>mlen) {
			System.out.println(0);
			return;
		}
		Set<Long> unique = new HashSet<Long>();
		for(int i = 0; i<nlen; i++) {
			count[N.charAt(i)-'a']++;
			section[M.charAt(i)-'a']++;
			orderedhash=hashaddordered(orderedhash,M.charAt(i));
			nhash=hashadd(nhash,N.charAt(i));
			mhash=hashadd(mhash,M.charAt(i));
		}
		if(nhash==mhash&&Arrays.equals(section,count))unique.add(orderedhash);
		for(int i = nlen; i<mlen; i++) {
			section[M.charAt(i-nlen)-'a']--;
			section[M.charAt(i)-'a']++;
			orderedhash=hashsubordered(orderedhash,M.charAt(i-nlen));
			orderedhash=hashaddordered(orderedhash,M.charAt(i));
			mhash=hashsub(mhash,M.charAt(i-nlen));
			mhash=hashadd(mhash,M.charAt(i));
			if(nhash==mhash&&Arrays.equals(section,count))unique.add(orderedhash);
		}
		System.out.println(unique.size());
	}
}