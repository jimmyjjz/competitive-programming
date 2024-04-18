import java.util.*;
import java.io.*;
public class BadNews {
	static class pos{
		int x,y;
		public pos(int x, int y) {
			this.x=x;
			this.y=y;
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static Set<String> fill = new HashSet<String>();
	static String tar = "";
	static Map<String,String> resolve = new HashMap<String,String>();
	public static void find(int x, int y, char[][] grid, int N, String current, boolean[][] encountered, int place) {
		if(place >= tar.length()) {
			return;
		}
		if(x-1 >= 0) {
			if(!encountered[x-1][y] && (grid[x-1][y]+"").equals(tar.charAt(place)+"")){
			encountered[x-1][y]=true;
			if((current+grid[x-1][y]).equals(tar)) {
				resolve.put(tar,"yes");
				return;
			}
			find(x-1,y,grid,N,current+grid[x-1][y],encountered,place+1);
			encountered[x-1][y]=false;
			}
			if(y-1 >= 0) {
				if(!encountered[x-1][y-1]  && (grid[x-1][y-1]+"").equals(tar.charAt(place)+"")) {
					encountered[x-1][y-1]=true;
					if((current+grid[x-1][y-1]).equals(tar)) {
						resolve.put(tar,"yes");
						return;
					}
					find(x-1,y-1,grid,N,current+grid[x-1][y-1],encountered,place+1);
					encountered[x-1][y-1]=false;
					}
			}
		}
		//
		if(y-1 >= 0) {
			if(!encountered[x][y-1] && (grid[x][y-1]+"").equals(tar.charAt(place)+"")) {
			encountered[x][y-1]=true;
			if((current+grid[x][y-1]).equals(tar)) {
				resolve.put(tar,"yes");
				return;
			}
			find(x,y-1,grid,N,current+grid[x][y-1],encountered,place+1);
			encountered[x][y-1]=false;
			}
			if(x+1 < N) {
				if(!encountered[x+1][y-1] && (grid[x+1][y-1]+"").equals(tar.charAt(place)+"")) {
					encountered[x+1][y-1]=true;
					if((current+grid[x+1][y-1]).equals(tar)) {
						resolve.put(tar,"yes");
						return;
					}
					find(x+1,y-1,grid,N,current+grid[x+1][y-1],encountered,place+1);
					encountered[x+1][y-1]=false;
					}
			}
		}
		//
		if(x+1 < N) {
			if(!encountered[x+1][y] && (grid[x+1][y]+"").equals(tar.charAt(place)+"")) {
				encountered[x+1][y]=true;
				if((current+grid[x+1][y]).equals(tar)) {
					resolve.put(tar,"yes");
					return;
				}
				find(x+1,y,grid,N,current+grid[x+1][y],encountered,place+1);
				encountered[x+1][y]=false;
				}
			if(y+1 < N) {
				if(!encountered[x+1][y+1] && (grid[x+1][y+1]+"").equals(tar.charAt(place)+"")) {
					encountered[x+1][y+1]=true;
					if((current+grid[x+1][y+1]).equals(tar)) {
						resolve.put(tar,"yes");
						return;
					}
					find(x+1,y+1,grid,N,current+grid[x+1][y+1],encountered,place+1);
					encountered[x+1][y+1]=false;
					}
			}
		}
		//
		if(y+1 < N) {
			if(!encountered[x][y+1] && (grid[x][y+1]+"").equals(tar.charAt(place)+"")) {
				encountered[x][y+1]=true;
				if((current+grid[x][y+1]).equals(tar)) {
					resolve.put(tar,"yes");
					return;
				}
				find(x,y+1,grid,N,current+grid[x][y+1],encountered,place+1);
				encountered[x][y+1]=false;
				}
			if(x-1 >= 0) {
				if(!encountered[x-1][y+1] && (grid[x-1][y+1]+"").equals(tar.charAt(place)+"")) {
					encountered[x-1][y+1]=true;
					if((current+grid[x-1][y+1]).equals(tar)) {
						resolve.put(tar,"yes");
						return;
					}
					find(x-1,y+1,grid,N,current+grid[x-1][y+1],encountered,place+1);
					encountered[x-1][y+1]=false;
					}
			}
		}
		//
	}
	public static void printgrid(boolean[][] grid, int N) {
		for(int i = 0; i<N; i++) {
			System.out.println();
			for(int j = 0; j<N; j++) {
				System.out.print(grid[i][j]+" ");
			}
		}
	}
	public static void main(String[] args) throws IOException{
		int N = readInt(), Q = readInt();
		char[][] grid = new char[N][N];
		List<pos> search = new ArrayList<pos>();
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				grid[i][j] = readCharacter();
			}
		}
		for(int i = 0; i<Q; i++) {
			search.clear();
			tar = readLine();
			for(int j = 0; j<N; j++) {
				for(int k = 0; k<N; k++) {
					if(tar.charAt(0) == grid[j][k]) {
						search.add(new pos(j,k));
					}
				}
			}
			boolean end = false;
			for(int j = 0; j<search.size(); j++) {
				boolean[][] encountered = new boolean[N][N];
				encountered[search.get(j).x][search.get(j).y] = true;
				find(search.get(j).x,search.get(j).y,grid,N,tar.charAt(0)+"",encountered,1);
				encountered[search.get(j).x][search.get(j).y] = false;
				//printgrid(encountered, N);
				if(resolve.get(tar) != null) {
					System.out.println("good puzzle!");
					end = true;
					break;
				}
			}
			if(!end) {
				System.out.println("bad puzzle!");
			}
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