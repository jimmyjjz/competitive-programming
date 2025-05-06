import java.util.*;
import java.io.*;
public class AnimeConventions {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), Q = readInt();
		int[] rep = new int[N+1];
		Stack<Integer>[] block = new Stack[N+1];
		for(int i = 1; i<=N; i++) {
			rep[i]=i;
			Stack<Integer> s = new Stack<Integer>();
			s.push(i);
			block[i]=s;
		}
		for(int i = 0; i<Q; i++) {
			String s = next();
			int x = rep[readInt()], y = rep[readInt()];
			if(s.equals("A")){
				if(x==y)continue;
				if(block[y].size()>block[x].size()) {
					int save = x;
					x=y;
					y=save;
				}
					while(!block[y].isEmpty()) {
						rep[block[y].peek()]=x;
						block[x].add(block[y].pop());
					}
					//System.out.println(Arrays.toString(block));
					//System.out.println(Arrays.toString(rep));
			}
			else {
				if(rep[x]==rep[y]) {
					System.out.println("Y");
				}
				else {
					System.out.println("N");
				}
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