import java.util.*;
import java.io.*;
public class PrimeTime {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		List<Integer> unique = new ArrayList<Integer>();
		int num = 0, ori = 0, count = 0;
		 boolean prime[] = new boolean[10001];
		 	Arrays.fill(prime,true);
	        for(int p = 2; p*p<=10000; p++){
	            if(prime[p] == true){
	                for (int i = p*p; i<=10000; i+=p) {
	                    prime[i] = false;
	                }
	            }
	        }
	        prime[0] = false;
	        prime[1] = false;
	        for(int i = 0; i<=10000; i++) {
	        	if(prime[i]) {
	        		unique.add(i);
	        	}
	        }
	        for(int i = 0; i<5; i++) {
	        	System.out.println();
	        	int in = readInt();
	        	for(int j = 0; j<unique.size(); j++) {
	        		if(unique.get(j)>in) {
	        			break;
	        		}
	        		ori = unique.get(j);
		        	num = ori;
		        	count = 0;
		        	while(in>=num) {
		        		count += in/num;
		        		num=num*ori;
		        	}
		        	if(j == 0) {
		        	System.out.print(ori+"^"+count+" ");
		        	}
		        	else {
		        		System.out.print("* "+ori+"^"+count+" ");
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