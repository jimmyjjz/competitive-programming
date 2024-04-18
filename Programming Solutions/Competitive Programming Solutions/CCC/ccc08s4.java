import java.util.*;
import java.io.*;
public class TwentyFour {
	public static int cap = 0;
	public static void comb(int num, List<Integer> pile) {
	 if(pile.isEmpty()){
	 if(num<25){
	 cap=Math.max(cap,num);
	 }
	 return;
	 }
	 for(int i = 0; i<pile.size(); i++) {
	int save = pile.remove(i);
	 comb(num+save,pile);
	 comb(num-save,pile);
	 comb(num*save,pile);
	 if((double)(num)/(double)(save)%1.000==0){
		 comb(num/save,pile);
	 }
	 pile.add(i,save);
	 }
	 if(pile.size()!=1) {
		 int a = pile.remove(0), b = pile.remove(0);
		 if((double)(a)/(double)(b)%1.000==0){
			 comb(num-(a/b),pile);
			 comb(num+(a/b),pile);
		 }
		 if((double)(b)/(double)(a)%1.000==0){
			 comb(num-(b/a),pile);
			 comb(num+(b/a),pile);
		 }
		 comb(num-(a*b),pile);
		 comb(num+(a*b),pile);
		 comb(num*(a+b),pile);
		 pile.add(0,a);
		 pile.add(1,b);
	 }
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt();
		for(int j = 0; j<N; j++) {
			List<Integer> pile = new ArrayList<Integer>();
			for(int i = 0; i<4; i++) {
				pile.add(readInt());
			}
		cap = 0;
		for(int i = 0; i<4; i++) {
		int save = pile.remove(i);
		comb(save,pile);
		pile.add(i,save);
		}
		System.out.println(cap);
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