import java.util.*;
import java.io.*;
public class ArithmeticSquare{
	static long grid[][] = {{-Integer.MAX_VALUE,-Integer.MAX_VALUE,-Integer.MAX_VALUE},{-Integer.MAX_VALUE,-Integer.MAX_VALUE,-Integer.MAX_VALUE},{-Integer.MAX_VALUE,-Integer.MAX_VALUE,-Integer.MAX_VALUE}};
	public static void gridfill() {
		boolean cont = true;
		while(cont) {
		cont = false;
		for(int i = 0; i<3; i++) {
		int cnt = 0, spot = -1;
		for(int j = 0; j<3; j++) {
			if(grid[j][i]!=-Integer.MAX_VALUE)cnt++;
			else spot=j;
		}
		if(cnt==2) {
			cont = true;
			switch(spot) {
			case 0:grid[0][i]=grid[1][i]*2-grid[2][i];break;
			case 1:grid[1][i]=(grid[0][i]+grid[2][i])/2;break;
			case 2:grid[2][i]=grid[1][i]*2-grid[0][i];break;
			}
		}
		}
		for(int i = 0; i<3; i++) {
		int cnt = 0, spot = -1;
		for(int j = 0; j<3; j++) {
			if(grid[i][j]!=-Integer.MAX_VALUE)cnt++;
			else spot=j;
		}
		if(cnt==2) {
			cont = true;
			switch(spot) {
			case 0:grid[i][0]=grid[i][1]*2-grid[i][2];break;
			case 1:grid[i][1]=(grid[i][0]+grid[i][2])/2;break;
			case 2:grid[i][2]=grid[i][1]*2-grid[i][0];break;
			}
		}
		}
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		for(int i = 0; i<3; i++) {
			for(int j = 0; j<3; j++) {
				String s = next();
				if(!s.equals("X"))grid[i][j]=Long.parseLong(s);
			}
		}
		gridfill();
		if(grid[1][1]==-Integer.MAX_VALUE)grid[1][1]=0;
		gridfill();
		if(grid[0][1]==-Integer.MAX_VALUE)grid[0][1]=0;
		gridfill();
		if(grid[2][1]==-Integer.MAX_VALUE)grid[2][1]=0;
		gridfill();
		if(grid[1][0]==-Integer.MAX_VALUE)grid[1][0]=0;
		gridfill();
		if(grid[1][2]==-Integer.MAX_VALUE)grid[1][2]=0;
		gridfill();
		if(grid[0][0]==-Integer.MAX_VALUE)grid[0][0]=0;
		gridfill();
		for(long[] arr : grid) {
			for(long l : arr)System.out.print(l+" ");
			System.out.println();
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