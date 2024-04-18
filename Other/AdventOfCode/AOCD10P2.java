import java.util.*;
import java.io.*;
public class AOCD10P2 {
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
	static final int len=11;//140
	static char[][] board = new char[len][len];
	static boolean[][] bar = new boolean[len][len];
	static void dfs(int r, int c,boolean barred[][]) {
		try{if(barred[r][c]) {flood(barred);return;}}catch(Exception e) {return;}
		barred[r][c]=true;
		//for(int i = 0; i<len; i++)System.out.println(Arrays.toString(barred[i]).replaceAll("true","X").replaceAll("false","O"));
		//System.out.println("_______________________"+board[r][c]+" "+r+" "+c);
		switch(board[r][c]) {
			case '|':dfs(r-1,c,barred);dfs(r+1,c,barred);break;
			case '-':dfs(r,c-1,barred);dfs(r,c+1,barred);break;
			case 'L':dfs(r-1,c,barred);dfs(r,c+1,barred);break;
			case 'J':dfs(r-1,c,barred);dfs(r,c-1,barred);break;
			case '7':dfs(r+1,c,barred);dfs(r,c-1,barred);break;
			case 'F':dfs(r+1,c,barred);dfs(r,c+1,barred);break;
		}
	}
	static void flood(boolean[][] barred) {
		//test
		System.out.println("ASDADAD");
		for(int i = 0; i<len; i++)System.out.println(Arrays.toString(barred[i]));
	}
	public static boolean[][] truedBarred(int r, int c){
		boolean[][] barred = new boolean[len][len];
		barred[r][c]=true;
		return barred;
	}
	public static void main(String[] args) throws IOException {
		for(int i = 0; i<len; i++)board[i]=readLine().toCharArray();
		int sr=-1, sc=-1;
		for(int i = 0; i<len; i++)for(int j = 0; j<len; j++)if(board[i][j]=='S') {sr=i;sc=j;break;}
//		for(int r = 0; r<len; r++) {
//			for(int c = 0; c<len; c++) {
//				switch(board[r][c]) {
//					case '|':dfs(r-1,c,truedBarred(r,c));dfs(r+1,c,truedBarred(r,c));break;
//					case '-':dfs(r,c-1,truedBarred(r,c));dfs(r,c+1,truedBarred(r,c));break;
//					case 'L':dfs(r-1,c,truedBarred(r,c));dfs(r,c+1,truedBarred(r,c));break;
//					case 'J':dfs(r-1,c,truedBarred(r,c));dfs(r,c-1,truedBarred(r,c));break;
//					case '7':dfs(r+1,c,truedBarred(r,c));dfs(r,c-1,truedBarred(r,c));break;
//					case 'F':dfs(r+1,c,truedBarred(r,c));dfs(r,c+1,truedBarred(r,c));break;
//				}
//			}
//		}
		try {if(board[sr][sc+1]=='-'||board[sr][sc+1]=='J'||board[sr][sc+1]=='7')dfs(sr,sc+1,truedBarred(sr,sc));}catch(Exception e) {}
		try {if(board[sr-1][sc]=='|'||board[sr-1][sc]=='7'||board[sr-1][sc]=='F')dfs(sr-1,sc,truedBarred(sr,sc));}catch(Exception e) {}
		try {if(board[sr+1][sc]=='|'||board[sr+1][sc]=='J'||board[sr+1][sc]=='L')dfs(sr+1,sc,truedBarred(sr,sc));}catch(Exception e) {}
		try {if(board[sr][sc-1]=='-'||board[sr][sc-1]=='L'||board[sr][sc-1]=='F')dfs(sr,sc-1,truedBarred(sr,sc));}catch(Exception e) {}
//		while(!q.isEmpty()) {
//			des cur = q.poll();
//			try{if(step[cur.r][cur.c]!=0||board[cur.r][cur.c]=='.')continue;}catch(Exception e) {continue;}
//			if(step[cur.r][cur.c]==0)step[cur.r][cur.c]=cur.v;
//			switch(board[cur.r][cur.c]) {
//				case '|':q.add(new des(cur.r-1,cur.c,step[cur.r][cur.c]+1));q.add(new des(cur.r+1,cur.c,step[cur.r][cur.c]+1));break;
//				case '-':q.add(new des(cur.r,cur.c-1,step[cur.r][cur.c]+1));q.add(new des(cur.r,cur.c+1,step[cur.r][cur.c]+1));break;
//				case 'L':q.add(new des(cur.r-1,cur.c,step[cur.r][cur.c]+1));q.add(new des(cur.r,cur.c+1,step[cur.r][cur.c]+1));break;
//				case 'J':q.add(new des(cur.r,cur.c-1,step[cur.r][cur.c]+1));q.add(new des(cur.r-1,cur.c,step[cur.r][cur.c]+1));break;
//				case '7':q.add(new des(cur.r+1,cur.c,step[cur.r][cur.c]+1));q.add(new des(cur.r,cur.c-1,step[cur.r][cur.c]+1));break;
//				case 'F':q.add(new des(cur.r+1,cur.c,step[cur.r][cur.c]+1));q.add(new des(cur.r,cur.c+1,step[cur.r][cur.c]+1));break;
//			}
//		}
//		int max = 0;
//		for(int i = 0; i<len; i++)for(int j = 0; j<len; j++)max=Math.max(max,step[i][j]);
//		System.out.println(max-1);
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