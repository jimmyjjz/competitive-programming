import java.io.*;
import java.util.*;
public class MultipleOfK {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
    public static void main (String[] args) throws IOException{
        Map<Long, Integer> Board = new HashMap<Long,Integer>();
        int N = readInt(), k = readInt();
        int[] arr = new int[N];
        long second[] = new long[N], biggest = 0, c = 0;
        for(int i = 0; i<N; i++) {
        	arr[i] = readInt();
        }
        for(int i = 0; i < N; i++){
            c += arr[i];
            second[i] = ((c%k)+k)%k;    
        }
        for(int i = 0; i < N; i++){
            if (second[i] == 0) {
                biggest = i + 1;  
            }
            else if (Board.containsKey(second[i]) == false) {
            	Board.put(second[i] , i);
            }
            else if (biggest < (i - Board.get(second[i]))){
            	biggest = i - Board.get(second[i]);  
            }
        }
         if(biggest == 0) {
        	  System.out.println("-1");
         }
         else {
        	 System.out.println(biggest);
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