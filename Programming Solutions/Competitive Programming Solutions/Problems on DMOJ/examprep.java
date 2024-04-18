import java.util.*;
import java.io.*;
public class ExamPrep {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static int findrep(int[] rep, int n) {
		while(rep[n]!=n)n=rep[n];
		return n;
	}
	public static void main(String[] args) throws IOException{
		int N = readInt(), Q = readInt();
		int[] rep = new int[N+1];
		long[] resource = new long[N+1];
		int[] size = new int[N+1];
		for(int i = 1; i<=N; i++) {
			int in = readInt();
			resource[i]=in;
		}
		for(int i = 1; i<=N; i++) {
			rep[i]=i;
			size[i]=1;
		}
		for(int i = 0; i<Q; i++) {
			//System.out.println(Arrays.toString(rep));
			//System.out.println(Arrays.toString(resource));
			//System.out.println(Arrays.toString(size));
			int op = readInt();
			if(op==1){
				int x = findrep(rep,readInt()), y = findrep(rep,readInt());
				//System.out.println(x+" "+y);
				if(x==y)continue;
				if(size[x]>=size[y]) {
					rep[y]=x;
					size[x]+=size[y];
					resource[x]+=resource[y];
				}
				else {
					rep[x]=y;
					size[y]+=size[x];
					resource[y]+=resource[x];
				}
			}
			else if(op==2){
				System.out.println(size[findrep(rep,readInt())]);
			}
			else if(op==3){
				System.out.println(resource[findrep(rep,readInt())]);
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