import java.util.*;
import java.io.*;
public class StampGrid{
	static int K;
	static char[][] target,canva;
	static char[][][] stamps;
	static void rotate90cw(char a[][], char b[][]) {
		for(int i = 0; i<K; i++) {
			for(int j = 0; j<K; j++)b[j][K-i-1]=a[i][j];
		}
	}
	static void stamp(int r, int c) {
		for(int i = 0; i<4; i++) {
			boolean pass = true;
			for(int j = r; j<r+K; j++) {
				for(int k = c; k<c+K; k++)if(target[j][k]=='.'&&stamps[i][j-r][k-c]=='*')pass=false;
			}
			if(!pass)continue;
			for(int j = r; j<r+K; j++) {
				for(int k = c; k<c+K; k++)if(stamps[i][j-r][k-c]=='*')canva[j][k]=stamps[i][j-r][k-c];
			}
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int z = 0; z<T; z++) {
			br.readLine();
			int N = Integer.parseInt(br.readLine());
			target = new char[N][N];
			canva = new char[N][N];
			for(int i = 0; i<N; i++) {
				String s = br.readLine();
				for(int j = 0; j<N; j++) {
					target[i][j]=s.charAt(j);
					canva[i][j]='.';
				}
			}
			K = Integer.parseInt(br.readLine());
			stamps = new char[4][K][K];
			for(int i = 0; i<K; i++) {
				String s = br.readLine();
				for(int j = 0; j<K; j++)stamps[0][i][j]=s.charAt(j);
			}
			rotate90cw(stamps[0],stamps[1]);
			rotate90cw(stamps[1],stamps[2]);
			rotate90cw(stamps[2],stamps[3]);
			for(int i = 0; i<=N-K; i++) {
				for(int j = 0; j<=N-K; j++)stamp(i,j);
			}
			boolean same = true;
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<N; j++)if(canva[i][j]!=target[i][j])same=false;
			}
			System.out.println(same?"YES":"NO");
		}
	}
}