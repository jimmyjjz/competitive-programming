import java.util.*;
import java.io.*;
public class BoringBusiness{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		Map<String,Boolean> dug = new HashMap<String,Boolean>();
		//already dug
		dug.put("0 -1",true);
		dug.put("0 -2",true);
		dug.put("0 -3",true);
		dug.put("1 -3",true);
		dug.put("2 -3",true);
		dug.put("3 -3",true);
		dug.put("3 -4",true);
		dug.put("3 -5",true);
		dug.put("4 -5",true);
		dug.put("5 -5",true);
		dug.put("5 -4",true);
		dug.put("5 -3",true);
		dug.put("6 -3",true);
		dug.put("7 -3",true);
		dug.put("7 -4",true);
		dug.put("7 -5",true);
		dug.put("7 -6",true);
		dug.put("7 -7",true);
		dug.put("6 -7",true);
		dug.put("5 -7",true);
		dug.put("4 -7",true);
		dug.put("3 -7",true);
		dug.put("2 -7",true);
		dug.put("1 -7",true);
		dug.put("0 -7",true);
		dug.put("-1 -7",true);
		dug.put("-1 -6",true);
		dug.put("-1 -5",true);
		//
		int x = -1, y = -5;
		String s = next();
		int n = readInt();
		while(!s.equals("q")) {
		if(s.equals("d")) {
			int save = y;
			for(int i = 0; i<n; i++) {
				y--;
				if(dug.get(x+" "+y)!=null) {
					System.out.println(x+" "+(save-n)+" DANGER");
					return;
				}
				dug.put(x+" "+y,true);
			}
		}
		else if(s.equals("u")) {
			int save = y;
			for(int i = 0; i<n; i++) {
				y++;
				if(dug.get(x+" "+y)!=null) {
					System.out.println(x+" "+(save+n)+" DANGER");
					return;
				}
				dug.put(x+" "+y,true);
			}
		}
		else if(s.equals("l")) {
			int save = x;
			for(int i = 0; i<n; i++) {
				x--;
				if(dug.get(x+" "+y)!=null) {
					System.out.println((save-n)+" "+y+" DANGER");
					return;
				}
				dug.put(x+" "+y,true);
			}
		}
		else if(s.equals("r")) {
			int save = x;
			for(int i = 0; i<n; i++) {
				x++;
				if(dug.get(x+" "+y)!=null) {
					System.out.println((save+n)+" "+y+" DANGER");
					return;
				}
				dug.put(x+" "+y,true);
			}
		}
		System.out.println(x+" "+y+" safe");
		s = next();
		n = readInt();
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