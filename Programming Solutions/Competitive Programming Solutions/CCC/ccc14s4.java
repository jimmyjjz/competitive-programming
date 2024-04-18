import java.util.*;
import java.io.*;
public class TintedGlassWindow {
	static class inputs{
		int x1,y1,x2,y2,t;
		inputs(int x1, int y1, int x2, int y2, int t) {
			this.x1=x1;
			this.y1=y1;
			this.x2=x2;
			this.y2=y2;
			this.t=t;
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), T = readInt();
		Set<Integer> nodupeX = new HashSet<Integer>(), nodupeY = new HashSet<Integer>();
		List<inputs> in = new ArrayList<inputs>();
		for(int i = 0; i<N; i++) {
			int x1 = readInt(), y1 = readInt(), x2 = readInt(), y2 = readInt(), t = readInt();
			nodupeX.add(x1); nodupeY.add(y1); nodupeX.add(x2); nodupeY.add(y2);
			in.add(new inputs(x1,y1,x2,y2,t));
		}
		List<Integer> compressedX = new ArrayList<Integer>(nodupeX), compressedY = new ArrayList<Integer>(nodupeY);
		Collections.sort(compressedX);
		Collections.sort(compressedY);
		Map<Integer,Integer> correX = new HashMap<Integer,Integer>(), correY = new HashMap<Integer,Integer>();
		int sizeX = compressedX.size(), sizeY = compressedY.size();
		for(int i = 1; i<=sizeX; i++)correX.put(compressedX.get(i-1),i);
		for(int i = 1; i<=sizeY; i++)correY.put(compressedY.get(i-1),i);
		int[][] board = new int[sizeX+1][sizeY+1];
		for(inputs i : in) {
			board[correX.get(i.x1)][correY.get(i.y1)]+=i.t;
			board[correX.get(i.x2)][correY.get(i.y2)]+=i.t;
			board[correX.get(i.x1)][correY.get(i.y2)]-=i.t;
			board[correX.get(i.x2)][correY.get(i.y1)]-=i.t;
		}
		long total = 0;
		for(int i = 1; i<=sizeX; i++) {
			for(int j = 1; j<=sizeY; j++) {
				board[i][j]+=board[i-1][j]+board[i][j-1]-board[i-1][j-1];
				if(board[i][j]>=T)total+=(long)(compressedY.get(j)-compressedY.get(j-1))*(long)(compressedX.get(i)-compressedX.get(i-1));
			}
		}
//		for(int i = 1; i<=sizeX; i++) {
//			for(int j = 1; j<=sizeY; j++)System.out.print(board[i][j]+" ");
//			System.out.println();
//		}
		System.out.println(total);
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