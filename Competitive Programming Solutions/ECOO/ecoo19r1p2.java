import java.util.*;
import java.io.*;
public class LSystem {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		for(int x = 0; x<10; x++) {
            int rules = readInt(), iterations = readInt();
            String save = next()+"";
            String[] board = new String[26];
            long frequncy[][] = new long[2][26];
            int fixed = save.length();
            char F,L;
            long result = 0;
            for(int i=0; i<rules; i++) {
            	board[next().charAt(0)-65] = next();
            }
            for(int i = 0; i<fixed; i++) {
            	frequncy[0][save.charAt(i)-65]++;
            }
            F = save.charAt(0);
            L = save.charAt(fixed-1);
            for(int i = 0; i<iterations; i++) {
                F = board[F-65].charAt(0); 
                L = board[L-65].charAt(board[L-65].length()-1); 
                for(int j = 0; j<26; j++) {
                    if (frequncy[0][j] == 0) {
                    	continue;
                    }
                    for(int k = 0; k<board[j].length(); k++) {
                    	frequncy[1][board[j].charAt(k)-65] += frequncy[0][j];
                    }
                }
                frequncy[0] = Arrays.copyOf(frequncy[1], frequncy[1].length);
                Arrays.fill(frequncy[1], 0);
            }
            for (int j = 0; j<26; j++) {
            	result += frequncy[0][j];
            }
            System.out.println((F+"")+(L+"")+" "+result);
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