import java.util.*;
import java.io.*;
public class AOCD10P1 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static class des{
		int r,c,v;
		des(int r, int c, int v){
			this.r=r;
			this.c=c;
			this.v=v;
		}
	}
	public static void main(String[] args) throws IOException {
		final int len=140;//140
		char[][] board = new char[len][len];
		int[][] step = new int[len][len];
		Queue<des> q = new LinkedList<des>();
		for(int i = 0; i<len; i++)board[i]=readLine().toCharArray();
		int sr=-1, sc=-1;
		for(int i = 0; i<len; i++)for(int j = 0; j<len; j++)if(board[i][j]=='S') {sr=i;sc=j;break;}
		step[sr][sc]=1;
		try {if(board[sr][sc+1]=='-'||board[sr][sc+1]=='J'||board[sr][sc+1]=='7')q.add(new des(sr,sc+1,step[sr][sc]+1));}catch(Exception e) {}
		try {if(board[sr-1][sc]=='|'||board[sr-1][sc]=='7'||board[sr-1][sc]=='F')q.add(new des(sr-1,sc,step[sr][sc]+1));}catch(Exception e) {}
		try {if(board[sr+1][sc]=='|'||board[sr+1][sc]=='J'||board[sr+1][sc]=='L')q.add(new des(sr+1,sc,step[sr][sc]+1));}catch(Exception e) {}
		try {if(board[sr][sc-1]=='-'||board[sr][sc-1]=='L'||board[sr][sc-1]=='F')q.add(new des(sr,sc-1,step[sr][sc]+1));}catch(Exception e) {}
		while(!q.isEmpty()) {
			des cur = q.poll();
			try{if(step[cur.r][cur.c]!=0||board[cur.r][cur.c]=='.')continue;}catch(Exception e) {continue;}
			if(step[cur.r][cur.c]==0)step[cur.r][cur.c]=cur.v;
			switch(board[cur.r][cur.c]) {
				case '|':q.add(new des(cur.r-1,cur.c,step[cur.r][cur.c]+1));q.add(new des(cur.r+1,cur.c,step[cur.r][cur.c]+1));break;
				case '-':q.add(new des(cur.r,cur.c-1,step[cur.r][cur.c]+1));q.add(new des(cur.r,cur.c+1,step[cur.r][cur.c]+1));break;
				case 'L':q.add(new des(cur.r-1,cur.c,step[cur.r][cur.c]+1));q.add(new des(cur.r,cur.c+1,step[cur.r][cur.c]+1));break;
				case 'J':q.add(new des(cur.r,cur.c-1,step[cur.r][cur.c]+1));q.add(new des(cur.r-1,cur.c,step[cur.r][cur.c]+1));break;
				case '7':q.add(new des(cur.r+1,cur.c,step[cur.r][cur.c]+1));q.add(new des(cur.r,cur.c-1,step[cur.r][cur.c]+1));break;
				case 'F':q.add(new des(cur.r+1,cur.c,step[cur.r][cur.c]+1));q.add(new des(cur.r,cur.c+1,step[cur.r][cur.c]+1));break;
			}
		}
		int max = 0;
		for(int i = 0; i<len; i++)for(int j = 0; j<len; j++)max=Math.max(max,step[i][j]);
		System.out.println(max-1);
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