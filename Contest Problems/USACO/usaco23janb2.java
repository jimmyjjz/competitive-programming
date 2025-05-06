import java.util.*;
import java.io.*;
public class AirCownditioningII {
	static int[][] cows, ac;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		cows = new int[N][3];
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<3; j++)cows[i][j]=Integer.parseInt(st.nextToken());
		}
		ac = new int[M][4];
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<4; j++)ac[i][j]=Integer.parseInt(st.nextToken());
		}
		int combCnt = (1<<M), min = Integer.MAX_VALUE;
		for(int i = 0; i<combCnt; i++) {
			int cost = 0;
			int[] stalls = new int[102];
			for(int j = 0; j<M; j++) {
				if(((1<<j)&i)==0)continue;
				stalls[ac[j][0]]+=ac[j][2];
				stalls[ac[j][1]+1]-=ac[j][2];
				cost+=ac[j][3];
			}
			for(int j = 1; j<=101; j++)stalls[j]+=stalls[j-1];
			out:{
				for(int[] cow : cows) {
					for(int k = cow[0]; k<=cow[1]; k++)if(stalls[k]<cow[2])break out;
				}
				min=Math.min(min,cost);
			}
		}
		System.out.println(min);
	}
}