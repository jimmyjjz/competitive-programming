import java.util.*;
import java.io.*;
public class CrossSpiral {
	public static int h,w;
	public static void print(boolean[][] room) {
		for(int i = 0; i<h; i++) {
			for(int j = 0; j<w; j++) {
				System.out.print((room[i][j])?"1 ":"0 ");
			}
			System.out.println();
		}
	}
	public static void surrounded(int x, int y, boolean[][] room) {
		boolean a=false,b=false,c=false,d=false;
		try {if(room[x+1][y])a=true;}catch(Exception e) {a=true;}
		try {if(room[x][y+1])b=true;}catch(Exception e) {b=true;}
		try {if(room[x-1][y])c=true;}catch(Exception e) {c=true;}
		try {if(room[x][y-1])d=true;}catch(Exception e) {d=true;}
		if(a&&b&&c&&d) {
			//print(room);
			System.out.println(y+1);
			System.out.println(x+1);
			System.exit(0);
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		w = readInt();
		h = readInt();
		boolean[][] room = new boolean[h][w];
		int a = readInt(), b = readInt();
		for(int i = 0; i<b; i++) {
			for(int j = 0; j<a; j++)room[i][j]=true;
		}
		for(int i = 0; i<b; i++) {
			for(int j = w-a; j<w; j++)room[i][j]=true;
		}
		for(int i = h-b; i<h; i++) {
			for(int j = w-a; j<w; j++)room[i][j]=true;
		}
		for(int i = h-b; i<h; i++) {
			for(int j = 0; j<a; j++)room[i][j]=true;
		}
		int moves = readInt();
		//print(room);
		int x = 0, y = 0;
		out:{
		for(int i = 0; i<h; i++) {
			for(int j = 0; j<w; j++){
				if(!room[i][j]) {
					x=i;
					y=j;
					break out;
				}
			}
		}
		}
		while(moves>0) {
		while(moves>0&&!room[x][y+1]) {
			room[x][y]=true;
			moves--;
			y++;
		}
		surrounded(x,y,room);
		while(moves>0&&room[x][y+1]&&!room[x+1][y]) {
			room[x][y]=true;
			moves--;
			x++;
		}
		surrounded(x,y,room);
		while(moves>0&&y+1<w&&!room[x][y+1]) {
			room[x][y]=true;
			moves--;
			y++;
		}
		surrounded(x,y,room);
		while(moves>0&&!room[x+1][y]) {
			room[x][y]=true;
			moves--;
			x++;
		}
		surrounded(x,y,room);
		while(moves>0&&room[x+1][y]&&!room[x][y-1]) {
			room[x][y]=true;
			moves--;
			y--;
		}
		surrounded(x,y,room);
		while(moves>0&&x+1<h&&!room[x+1][y]) {
			room[x][y]=true;
			moves--;
			x++;
		}
		surrounded(x,y,room);
		while(moves>0&&!room[x][y-1]) {
			room[x][y]=true;
			moves--;
			y--;
		}
		surrounded(x,y,room);
		while(moves>0&&room[x][y-1]&&!room[x-1][y]) {
			room[x][y]=true;
			moves--;
			x--;
		}
		surrounded(x,y,room);
		while(moves>0&&y>0&&!room[x][y-1]) {
			room[x][y]=true;
			moves--;
			y--;
		}
		surrounded(x,y,room);
		while(moves>0&&!room[x-1][y]) {
			room[x][y]=true;
			moves--;
			x--;
		}
		surrounded(x,y,room);
		while(moves>0&&room[x-1][y]&&!room[x][y+1]) {
			room[x][y]=true;
			moves--;
			y++;
		}
		surrounded(x,y,room);
		while(moves>0&&x>0&&!room[x-1][y]) {
			room[x][y]=true;
			moves--;
			x--;
		}
		surrounded(x,y,room);
		}
		//print(room);
		System.out.println(y+1);
		System.out.println(x+1);
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