import java.util.*;
import java.io.*;
public class order {
	 public static int sum(int a, int b, int pre[]){
	        if (a == 0) {
	            return pre[b];
	        }
	        return pre[b] - pre[a - 1];
	    }
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
			StringTokenizer cut = new StringTokenizer(readLine(), " ");
			int size = Integer.parseInt(cut.nextToken());
			int selections = Integer.parseInt(cut.nextToken());
			StringTokenizer split = new StringTokenizer(readLine(), " ");
			int sumA = 0;
			int sumB = 0;
			double test = 0;
			int save = 0;
			int prices[] = new int[size];
			for(int i = 0; i<size; i++) {
				prices[i] = Integer.parseInt(split.nextToken());
			}
	        int change[] = new int[size];
	        change[0] = prices[0];
			 for (int j = 1; j < size; j++) {
				 change[j] = prices[j] + change[j - 1];
			 }
			 for(int k = 0; k<selections; k++) {
				 StringTokenizer chop = new StringTokenizer(readLine(), " ");
				 sumA = sum(Integer.parseInt(chop.nextToken())-1, Integer.parseInt(chop.nextToken())-1, change);
				 sumB = sum(Integer.parseInt(chop.nextToken())-1, Integer.parseInt(chop.nextToken())-1, change);
				 save = sumB-10;
				 if(save < 0) {
					 save = 0;
				 }
				 test = (sumA/2.0)+save;
				 save = sumA-10;
				 if(save < 0) {
					 save = 0;
				 }
				 System.out.println(Math.abs(sumA+sumB-(Math.min(test, (sumB/2.0)+save))));
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