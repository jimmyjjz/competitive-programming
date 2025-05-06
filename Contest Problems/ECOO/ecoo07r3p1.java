import java.util.*;
import java.io.*;
public class SumOfPrimes {
	public static boolean isprime(int n){
		for(int x = 2; x <= Math.sqrt(n); x++) {
			if(n%x == 0){
        return false;
			}
		}
		return true;
	}
	public static void print(int s, int a, int b, int c){
	    System.out.println(s+" = "+a+" + "+b+" + "+c);
	}

	public static void print(int s, int a, int b){
		System.out.println(s+" = "+a+" + "+b);
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
    for(int i = 0; i < 5; i++){
        int n = readInt();
        if(isprime(n)){
            System.out.println(n+" = "+n);
           continue;
        }
        for(int x = n/2; x >= 2; x--){
            if(isprime(x)){
                if(isprime(n-x)){
                    print(n, x, n-x);
                    break;
                }
                else{
                    int ma = Integer.MAX_VALUE;
                    for(int y = x; y <= (n-x-y); y++) {
                        if(isprime(y) && isprime(n-x-y)) {
                            ma = y;
                        }
                    }
                    if(ma != Integer.MAX_VALUE){
                        print(n, x, ma, n-x-ma);
                        break;
                    }
                }
            }
        }
        //
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