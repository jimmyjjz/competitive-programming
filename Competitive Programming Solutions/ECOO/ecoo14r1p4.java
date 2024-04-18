import java.util.*;
import java.io.*;
public class FischerRandomChess{
	static String s;
	static Set<String> delDupe;
	static boolean validate(String s) {
		boolean r1=false,k=false,r2=false;
		int b1 = -1, b2 = -1;
		for(int i = 0; i<8; i++) {
			if(s.charAt(i)=='R') {
				if(r1)r2=true;
				else r1=true;
			}
			else if(s.charAt(i)=='B') {
				if(b1==-1)b1=i;
				else b2=i;
			}
			else if(s.charAt(i)=='K')k=true;
			if(!r1&&k)return false;
			if(r1&&r2&&!k)return false;
		}
		if(r1&&k&&r2&&(b1%2!=b2%2))return true;
		return false;
	}
	static void generate(int k, int q, int r, int b, int n, int i, String cur) {
		if(i==8) {
			if(validate(cur))delDupe.add(cur);
			return;
		}
		if(s.charAt(i)!='_') {
			if(s.charAt(i)=='K')
				if(k==0)return;
				else generate(k-1,q,r,b,n,i+1,cur+"K");
			if(s.charAt(i)=='Q')
				if(q==0)return;
				else generate(k,q-1,r,b,n,i+1,cur+"Q");
			if(s.charAt(i)=='R')
				if(r==0)return;
				else generate(k,q,r-1,b,n,i+1,cur+"R");
			if(s.charAt(i)=='B')
				if(b==0)return;
				else generate(k,q,r,b-1,n,i+1,cur+"B");
			if(s.charAt(i)=='N')
				if(n==0)return;
				else generate(k,q,r,b,n-1,i+1,cur+"N");
		}
		else {
			if(k!=0)generate(k-1,q,r,b,n,i+1,cur+"K");
			if(q!=0)generate(k,q-1,r,b,n,i+1,cur+"Q");
			if(r!=0)generate(k,q,r-1,b,n,i+1,cur+"R");
			if(b!=0)generate(k,q,r,b-1,n,i+1,cur+"B");
			if(n!=0)generate(k,q,r,b,n-1,i+1,cur+"N");
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		for(int i = 0; i<10; i++) {
			s = readLine();
			delDupe = new HashSet<String>();
			generate(1,1,2,2,2,0,"");
			System.out.println(delDupe.size());
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