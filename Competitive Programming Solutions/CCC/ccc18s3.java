import java.util.*;
import java.io.*;
public class RoboThieves {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static class PS{
		int v,h,s;
		public PS(int v, int h, int s) {
			this.h=h;
			this.v=v;
			this.s=s;
		}
	}
	public static void printarr(int ver, int hor, String[][] room) {
		for(int i = 0; i<ver; i++) {
			for(int j = 0; j<hor; j++) {
				System.out.print(room[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) throws IOException{
		int ver = readInt(), hor = readInt();
		Queue<PS> current = new LinkedList<PS>();
		String[][] room = new String[ver][hor];
		for(int i = 0; i<ver; i++) {
			String s = readLine();
			for(int j = 0; j<hor; j++)room[i][j]=s.charAt(j)+"";
		}
//		printarr(ver,hor,room);
//		System.out.println();
		for(int i = 0; i<ver; i++) {
			for(int j = 0; j<hor; j++) {
				if(room[i][j].equals("C")) {
					room[i][j]="W";
					try{for(int k = j-1; !room[i][k].equals("W"); k--) {
						if(room[i][k].equals("."))room[i][k]="-1";
						if(room[i][k].equals("S"))room[i][k]="W";
						}
						}catch(Exception e) {}
					try{for(int k = j+1; !room[i][k].equals("W"); k++) {
						if(room[i][k].equals("."))room[i][k]="-1";
						if(room[i][k].equals("S"))room[i][k]="W";
						}
						}catch(Exception e) {}
					try{for(int k = i-1; !room[k][j].equals("W"); k--) {
						if(room[k][j].equals("."))room[k][j]="-1";
						if(room[k][j].equals("S"))room[k][j]="W";
					}
					}catch(Exception e) {}
					try{for(int k = i+1; !room[k][j].equals("W"); k++) {
						if(room[k][j].equals("."))room[k][j]="-1";
						if(room[k][j].equals("S"))room[k][j]="W";
					}
					}catch(Exception e) {}
					}
				}
			}
		out:{
		for(int i = 0; i<ver; i++) {
			for(int j = 0; j<hor; j++)if(room[i][j].equals("S")) {
				current.add(new PS(i,j,0));
				break out;
			}
		}
		}
//		printarr(ver,hor,room);
//		System.out.println();
		int[][] valid = new int[ver][hor];
		for(int i = 0; i<ver; i++) {
			for(int j = 0; j<hor; j++) {
				valid[i][j]=Integer.MAX_VALUE;
			}
		}
		while(!current.isEmpty()) {
//			printarr(ver,hor,room);
//			System.out.println();
			PS cur = current.poll();
//			System.out.println(cur.v+" "+cur.h+" "+cur.s);
//			System.out.println("size "+current.size());
			try {
			if(cur.s<valid[cur.v][cur.h]&&!room[cur.v][cur.h].equals("W")&&!room[cur.v][cur.h].equals("-1")){
				valid[cur.v][cur.h]=cur.s;
				if(room[cur.v][cur.h].equals(".")) {
					room[cur.v][cur.h]=cur.s+"";
					current.add(new PS(cur.v+1,cur.h,cur.s+1));
					current.add(new PS(cur.v-1,cur.h,cur.s+1));
					current.add(new PS(cur.v,cur.h+1,cur.s+1));
					current.add(new PS(cur.v,cur.h-1,cur.s+1));
				}
				else if(room[cur.v][cur.h].equals("L"))current.add(new PS(cur.v,cur.h-1,cur.s));
				else if(room[cur.v][cur.h].equals("R"))current.add(new PS(cur.v,cur.h+1,cur.s));
				else if(room[cur.v][cur.h].equals("U"))current.add(new PS(cur.v-1,cur.h,cur.s));
				else if(room[cur.v][cur.h].equals("D"))current.add(new PS(cur.v+1,cur.h,cur.s));
				else if(room[cur.v][cur.h].equals("S")){
					current.add(new PS(cur.v+1,cur.h,cur.s+1));
					current.add(new PS(cur.v-1,cur.h,cur.s+1));
					current.add(new PS(cur.v,cur.h+1,cur.s+1));
					current.add(new PS(cur.v,cur.h-1,cur.s+1));
				}
				else{
					room[cur.v][cur.h]=Math.min(Integer.parseInt(room[cur.v][cur.h]),cur.s)+"";
					current.add(new PS(cur.v+1,cur.h,cur.s+1));
					current.add(new PS(cur.v-1,cur.h,cur.s+1));
					current.add(new PS(cur.v,cur.h+1,cur.s+1));
					current.add(new PS(cur.v,cur.h-1,cur.s+1));
				}
			}
			}catch(Exception e) {}
		}
		for(int i = 0; i<ver; i++) {
			for(int j = 0; j<hor; j++) {
				try{
					System.out.println((room[i][j].equals("."))?"-1":Integer.parseInt(room[i][j]));
				}catch(Exception e){}
			}
		}
//		printarr(ver,hor,room);
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