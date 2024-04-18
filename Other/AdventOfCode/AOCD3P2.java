import java.util.*;
import java.io.*;
public class AOCD3P2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static class pos{
		int i,j;
		pos(int i, int j){
			this.i=i;
			this.j=j;
		}
	}
	public static void main(String[] args) throws IOException {
		//probably not the best in terms of time and memory complexity. It just 140x140 so its fine.
		int sum=0, l=140;//140
		char board[][] = new char[l][l];
		List<Integer> adjNumbers[][] = new ArrayList[l][l];
		pos[][] grab = new pos[l][l];
		for(int i = 0; i<l; i++)for(int j = 0; j<l; j++) {
			adjNumbers[i][j]=new ArrayList<Integer>();
			grab[i][j]=new pos(i,j);
		}
		for(int i = 0; i<l; i++) {
			String s = readLine();
			for(int j = 0; j<l; j++)board[i][j]=s.charAt(j);
		}
		for(int i = 0; i<l; i++) {
			String s="0";
			Set<pos> gears = new HashSet<pos>();
			for(int j = 0; j<l; j++) {
				if(Character.isDigit(board[i][j])) {
					try {if(board[i+1][j]=='*')gears.add(grab[i+1][j]);}catch(Exception e) {}
					try {if(board[i][j+1]=='*')gears.add(grab[i][j+1]);}catch(Exception e) {}
					try {if(board[i+1][j+1]=='*')gears.add(grab[i+1][j+1]);}catch(Exception e) {}
					try {if(board[i-1][j]=='*')gears.add(grab[i-1][j]);}catch(Exception e) {}
					try {if(board[i][j-1]=='*')gears.add(grab[i][j-1]);}catch(Exception e) {}
					try {if(board[i-1][j-1]=='*')gears.add(grab[i-1][j-1]);}catch(Exception e) {}
					try {if(board[i+1][j-1]=='*')gears.add(grab[i+1][j-1]);}catch(Exception e) {}
					try {if(board[i-1][j+1]=='*')gears.add(grab[i-1][j+1]);}catch(Exception e) {}
					s+=board[i][j]+"";
				}
				else {
					for(pos p : gears) adjNumbers[p.i][p.j].add(Integer.parseInt(s));
					gears = new HashSet<pos>();
					s="0";
				}
			}
			for(pos p : gears)adjNumbers[p.i][p.j].add(Integer.parseInt(s));
		}
		for(int i = 0; i<l; i++) {
			for(int j = 0; j<l; j++) {
				if(adjNumbers[i][j].size()==2)sum+=adjNumbers[i][j].get(0)*adjNumbers[i][j].get(1);
			}
		}
		System.out.println(sum);
	}
	static String next() throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}

	static long readLong() throws IOException {
		return Long.parseLong(next());
	}

	static int readInt() throws IOException {
		return Integer.parseInt(next());
	}

	static double readDouble() throws IOException {
		return Double.parseDouble(next());
	}

	static char readCharacter() throws IOException {
		return next().charAt(0);
	}

	static String readLine() throws IOException {
		return br.readLine().trim();
	}
}