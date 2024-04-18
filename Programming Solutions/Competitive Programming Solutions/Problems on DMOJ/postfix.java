import java.util.*;
import java.io.*;
public class PostFix {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		Stack<Double> Storage = new Stack<Double>();
		Stack<String> Board = new Stack<String>();
		StringTokenizer split = new StringTokenizer(readLine());
		int size = split.countTokens();
		for(int i = 0; i<size; i++) {
			Board.add(split.nextToken());
		}
		Collections.reverse(Board);
		double a = 0, b = 0;
		while(!Board.empty()) {
			String s = Board.pop();
			switch(s) {
			case "*":a=Storage.pop(); b=Storage.pop(); Storage.push(b*a); break;
			case "/":a=Storage.pop(); b=Storage.pop(); Storage.push(b/a); break;
			case "+":a=Storage.pop(); b=Storage.pop(); Storage.push(b+a); break;
			case "-":a=Storage.pop(); b=Storage.pop(); Storage.push(b-a); break;
			case "%":a=Storage.pop(); b=Storage.pop(); Storage.push(b%a); break;
			case "^":a=Storage.pop(); b=Storage.pop(); Storage.push(Math.pow(b, a)); break;
			default:Storage.push(Double.parseDouble(s));
			}
		}
		System.out.println(Storage.pop());
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