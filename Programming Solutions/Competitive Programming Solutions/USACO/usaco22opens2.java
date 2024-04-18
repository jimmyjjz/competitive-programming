import java.util.*;
import java.io.*;
public class SubsetEquality{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		String a = readLine(), b = readLine();
		int len = Math.max(a.length(), b.length());
		int cnts[][][] = new int[len+1][18][2];
		LinkedList<Integer>[][] pos = new LinkedList[18][2];
		for(int i = 0; i<18; i++) {
			for(int j = 0; j<2; j++)pos[i][j]=new LinkedList<Integer>();
		}
		for(int i = 1; i<=len; i++) {
			try{pos[a.charAt(i-1)-'a'][0].add(i);}catch(Exception e) {}
			try{pos[b.charAt(i-1)-'a'][1].add(i);}catch(Exception e) {}
			try{cnts[i][a.charAt(i-1)-'a'][0]++;}catch(Exception e) {}
			try{cnts[i][b.charAt(i-1)-'a'][1]++;}catch(Exception e) {}
			for(int j = 0; j<18; j++) {
				cnts[i][j][0]+=cnts[i-1][j][0];
				cnts[i][j][1]+=cnts[i-1][j][1];
			}
		}
		HashSet<Integer>[] connectivity = new HashSet[18];
		for(int i = 0; i<18; i++) {
			connectivity[i]=new HashSet<Integer>();
			for(int j = 0; j<18; j++)connectivity[i].add(j);
		}
		for(int i = 0; i<18; i++) {
			if(pos[i][0].size()!=pos[i][1].size()) {
				connectivity[i].clear();
				continue;
			}
			while(!pos[i][0].isEmpty()) {
				int x = pos[i][0].poll(), y = pos[i][1].poll();
				for(int j = 0; j<18; j++) {
					if(cnts[x][j][0]!=cnts[y][j][1])connectivity[i].remove(j);
				}
			}
		}
		//for(int i = 0; i<18; i++)System.out.println((char)(i+'a')+" "+connectivity[i]);
		int Q = readInt();
		for(int i = 0; i<Q; i++) {
			String s = readLine();
			int lens = s.length();
			out:{
			for(int j = 0; j<lens; j++) {
				for(int k = 0; k<lens; k++) {
					if(!connectivity[s.charAt(j)-'a'].contains(s.charAt(k)-'a')) {
						System.out.print("N");
						break out;
					}
				}
			}
			System.out.print("Y");
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