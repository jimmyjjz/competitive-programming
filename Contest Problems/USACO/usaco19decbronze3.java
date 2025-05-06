import java.util.*;
import java.io.*;
public class Livestock {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		StringTokenizer split = new StringTokenizer("Beatrice,Belinda,Bella,Bessie,Betsy,Blue,Buttercup,Sue",",");
		Map<String,Integer> bond = new HashMap<String,Integer>();
		List<String> cows = new ArrayList<String>();
		int N = readInt();
		for (int i=0; i<8; i++) {
			String save = split.nextToken();
			cows.add(save);
			bond.put(save, i);
		}
		int[] background = new int[8],used = new int[8];
		int[][] board = new int[N][2];
		for(int i = 0; i<N; i++) {
			StringTokenizer cut = new StringTokenizer(readLine());
			board[i][0] = bond.get(cut.nextToken());
			cut.nextToken();
			cut.nextToken();
			cut.nextToken();
			cut.nextToken();
			board[i][1] = bond.get(cut.nextToken());
		}
		Arrays.fill(used, 0);
		recur(0,background, used, board, N);
		for(int i = 0; i<8; i++) {
			System.out.println(cows.get(background[i]));	
		}
	}
	
	public static boolean recur(int current, int[] background, int[] used, int[][] board, int N) {
		if(current == 8){
			int[] dex = new int[8];
			for(int i = 0; i<8; i++){
				dex[background[i]] = i; 
			}
			for(int i = 0; i<N; i++) {
				if(Math.abs(dex[board[i][0]]-dex[board[i][1]]) != 1){
					return false;
				}
			}
			return true;
		}
		for(int i = 0; i<8; i++){
			if(used[i] == 0){
				background[current] = i;
				current++;
				used[i] = 1;
				if(recur(current, background, used, board, N)){
					return true;
				}
				current--;
				used[i] = 0;
			}
		}
		return false;
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