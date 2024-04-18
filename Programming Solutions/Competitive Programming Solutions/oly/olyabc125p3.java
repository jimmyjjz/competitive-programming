import java.util.*;
import java.io.*;
public class MGCD{
    static int GCD(int a, int b){
        if (b == 0) {
            return a;
        }
        return GCD(b, a % b);
    }
    static int Cap(int a[], int n){
        int P[] = new int[n + 2];
        int S[] = new int[n + 2];
        P[1] = a[0];
        for(int i = 2; i <= n; i += 1){
            P[i] = GCD(P[i - 1], a[i - 1]);
        }
        S[n] = a[n - 1];
        for(int i = n - 1; i >= 1; i -= 1){
            S[i] = GCD(S[i + 1], a[i - 1]);
        }
        int answer = Math.max(S[2], P[n - 1]);
        for(int i = 2; i < n; i += 1){
            answer = Math.max(answer, GCD(P[i - 1], S[i + 1]));
        }
        return answer;
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
    public static void main(String[] args) throws IOException{
    	int N = readInt();
    	int[] in = new int[N];
    	for(int i = 0; i<N; i++) {
    		in[i] = readInt();
    	}
        System.out.println(Cap(in, N));
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