import java.util.*;
import java.io.*;
public class gep {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static boolean [][] Orginal = new boolean [20][20];
	public static int result = 0;
	private static void Process(int N, int M, boolean[] versionone, int save) {//make a clone and refine it and repeat till product < save
		if(save>N) {
			return;
		}
		else {
		result = result + 1;
		}
		for(int i = save; i<N; i++) {
			if(versionone[i] == false) {
				boolean [] versionone2 = versionone.clone();
				for(int k=i+1; k<N; k++){
					if(Orginal[i][k]){
						versionone2[k] = true;
					}
				}
				versionone2[i] = true;
				Process(N, M,versionone2,i+1);
			}
		}
	}
	public static void main(String[] args) throws IOException{
		int a = 0;
		int b = 0;
			StringTokenizer split = new StringTokenizer(readLine(), " ");
			int N = Integer.parseInt(split.nextToken());
			int M = Integer.parseInt(split.nextToken());
			boolean [] versionone = new boolean[N];
			for(int i = 0; i<M; i++) {
				StringTokenizer cut = new StringTokenizer(readLine(), " ");
				a = Integer.parseInt(cut.nextToken());
				b = Integer.parseInt(cut.nextToken());
				Orginal[Integer.min(a, b)-1][Integer.max(a, b)-1] = true;
			}
			for(int j = 0; j<N; j++) {
				Orginal[j][j] = true;
			}
			Process(N,M,versionone,0);
			System.out.println(result);
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