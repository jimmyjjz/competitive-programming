import java.util.*;
import java.io.*;
public class ConnectingTwoBarns{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] disjoint;
	static int findrep(int x) {return x==disjoint[x][0]?x:findrep(disjoint[x][0]);}
	static long closest(int x, List<Integer> li) {
		int l = 0, r = li.size()-1;
		while(l<=r) {
			int m = (l+r)/2;
			if(li.get(m)<x)l=m+1;
			else r=m-1;
		}
		if(r<0)return Math.abs(x-li.get(r+1));
		if(r+1==li.size())return Math.abs(x-li.get(r));
		return Math.min(Math.abs(x-li.get(r+1)), Math.abs(x-li.get(r)));
	}
	public static void main(String[] args) throws IOException{
		int T = readInt();
		for(int i = 0; i<T; i++) {
			int N = readInt(), M = readInt();
			disjoint = new int[N+1][2];
			for(int j = 1; j<=N; j++)disjoint[j][0]=j;
			for(int j = 0;  j<M; j++) {
				int a = findrep(readInt()), b = findrep(readInt());
				if(a!=b) {
					if(disjoint[a][1]>disjoint[b][1]) {
						disjoint[b][0]=a;
						disjoint[a][1]++;
					}
					else {
						disjoint[a][0]=b;
						disjoint[b][1]++;
					}
				}
			}
			int con1 = findrep(1), conN = findrep(N);
			if(con1==conN) {
				System.out.println(0);
				continue;
			}
			List<Integer> connected1 = new ArrayList<Integer>(), connectedN = new ArrayList<Integer>();
			Map<Integer,List<Integer>> other = new HashMap<Integer,List<Integer>>();
			for(int j = 1; j<=N; j++) {
				int rep = findrep(j);
				if(rep==con1)connected1.add(j);
				else if(rep==conN)connectedN.add(j);
				else {
					if(other.get(rep)==null)other.put(rep,new ArrayList<Integer>());
					other.get(rep).add(j);
				}
			}
			Collections.sort(connected1);
			Collections.sort(connectedN);
			long min = Long.MAX_VALUE;
			for(int j : connected1) {
				long c = closest(j,connectedN);
				min=Math.min(min,c*c);
			}
			for(List<Integer> s : other.values()) {
				long c1 = Long.MAX_VALUE, c2 = Long.MAX_VALUE;
				for(int j : s) {
					c1=Math.min(c1, closest(j,connected1));
					c2=Math.min(c2, closest(j,connectedN));
				}
				min=Math.min(min,(c1*c1)+(c2*c2));
			}
			System.out.println(min);
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