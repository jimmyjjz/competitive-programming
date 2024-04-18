import java.util.*;
import java.io.*;
public class Race {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int K = readInt(), N = readInt();
		for(int i = 0; i<N; i++){
		int X = readInt(), ms = 0, add = 0, cnt = 0;
	    while(add<K){
	        if((K-add-((ms-1+X)*(ms-X)/2-X)) > (2*ms+1) || ms==X && K-add>X+1 || ms<X){
	        	ms++;
	        }
	        else if((K-add-((ms-1+X)*(ms-X)/2-X)) <= ms){
	        	ms--;
	        }
	        add+=ms;
	        cnt++;
	    }
	    System.out.println(cnt);
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