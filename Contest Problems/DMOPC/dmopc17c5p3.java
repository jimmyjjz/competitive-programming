import java.util.*;
import java.io.*;
public class MimiAndPrimes {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static int num;
	public static long find;
	public static String [] tread; 
	public static long gcd(long a, long b){
		if(a == 0) {
			return b;
		}
		return gcd(b%a, a);
	}

	public static long isprime(long check){
		int temp = 0;
		ExitB:{
		do{
			ExitA:{
			if(check == 2) {
				break ExitB;
			}
			else {
			for(temp =2; temp <= (int)(Math.ceil(Math.sqrt(check))); temp++){
				if(check%temp == 0)
					break ExitA;
			}
			}
			break ExitB;
			}
			check = check/temp;
		}while (true);
		}
		return check;
	}
	public static void main(String[] args) {
		try{
			num = readInt();
			tread = readLine().split(" " );
			find = Long.parseLong(tread[0]);
			if(num>1){
			for(int i = 1 ; i < num ; i ++){
				long a = Long.parseLong(tread[i]);
				find = gcd(Math.min(find, a), Math.max(find, a));
			}
			}
			find = isprime(find);
			if(find!= 1) {
				System.out.println(find);
			}
			else {
				System.out.println("DNE");
			}
		}
		catch(Exception e){
			e.printStackTrace();
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