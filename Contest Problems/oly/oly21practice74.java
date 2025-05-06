import java.util.*;
import java.io.*;
public class bobgrouping {
	public static void pr(int[][] board, int len) {
		for(int i = 0; i<len+1; i++) {
			System.out.print(len);
			for(int j = 0; j<len; j++) {
				System.out.print(" "+board[j][i]);
			}
			System.out.println();
		}
	}
	public static int FactorFind(int N) {
		List<Integer> order = new ArrayList<Integer>();
		N*=2;
		for(int i = 1; i<Math.sqrt(N)+1; i++) {
			if(N%i==0) {
				order.add(i);
				order.add(N/i);
			}
		}
		Collections.sort(order);
		int fixed = order.size()/2+1;
		for(int i = 0; i<fixed; i++) {
			if(order.get(i)+1==N/order.get(i)) {
				return order.get(i);
			}
		}
		return 0;
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt();
		int len = FactorFind(N);
		if(len==0){
			System.out.println("No");
			return;
		}
		System.out.println("Yes");
		System.out.println(len+1);
		int[][] board = new int[len][len+1];
		int cnt = len;
		for(int i = 0; i<len; i++) {
			board[i][0]=i+1;
		}
		for(int i = 1; i<len+1; i++) {
			for(int j = 0; j<i; j++) {
				board[j][i]=board[i-1][j];
			}
			for(int j = i; j<len; j++) {
				board[j][i]=++cnt;
			}
		}
		pr(board,len);
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