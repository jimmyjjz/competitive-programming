import java.util.*;
import java.io.*;
public class CowFrisbee {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt();
		for(int i = 0; i<N; i++) {
			long[][] data = new long[100][2];
			long a = readLong(), b = readLong(), moves = 0;
//			while(a>b) {
//				moves++;
//				if(a%2==0)a/=2;
//				else a++;
//			}
			data[0][0]=a;
			data[0][1]=b;
			int j = 0;
			for(j = 1; a>1; j++) {
				if(a%2==0)a/=2;
				else a++;
				data[j][0]=a;
			}
			for(j = 1; b>1; j++) {
				if(b%2==0)b/=2;
				else b--;
				data[j][1]=b;
			}
//			for(j = 0; j<2; j++) {
//				for(int k = 0; k<100; k++)System.out.print(data[k][j]+" ");
//				System.out.println();
//			}
			long min = Long.MAX_VALUE;
			for(j = 0; j<100; j++) {
				for(int k = 0; k<100; k++) {
					if(data[j][0]<data[k][1]&&data[j][0]!=0&&data[k][1]!=0)min=Math.min(data[k][1]-data[j][0]+j+k, min);
			}
			}
			System.out.println((min==Long.MAX_VALUE)?"0":min);
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