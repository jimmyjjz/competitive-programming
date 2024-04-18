import java.util.*;
import java.io.*;
public class PrefixPostfix{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
    public static void main(String args[]) throws IOException{
    	String in = "";
    	while(!in.equals("0")) {
    	in = readLine();
    	Stack<String> board = new Stack<String>();
        for(int i=in.length()-1; i>=0; i--){
            if(in.charAt(i) == '+' || in.charAt(i) == '-' || in.charAt(i) == '/' || in.charAt(i) == '*'){
    
                board.push(board.pop()+board.pop()+in.charAt(i)+" ");
            }
            else if(!Character.isWhitespace(in.charAt(i))){
            	board.push(in.charAt(i)+" ");
            }
        }
        if(!in.equals("0")) {
        System.out.println(board.peek());
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