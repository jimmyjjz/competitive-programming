import java.util.*;
import java.io.*;
public class Towers {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
			int N = readInt();
	        int[] in = new int[N];
	        int[] out = new int[N];
	        for(int i=0; i<N; i++){
	        	in[i] = readInt();
	        }
	        Stack<Integer> Storage = new Stack<Integer>();
	        for(int i=N-1; i>0; i--){
	            while(!Storage.isEmpty() && in[Storage.peek()] < in[i]){
	                int val = Storage.pop();
	                out[val] = val - i;
	            }
	            Storage.push(i);
	        }
	        for(int i=0; i<N; i++){
	            if(out[i] != 0){
	            	System.out.print(out[i]+" ");
	            	continue;
	            }
	            System.out.print(i+" ");
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