import java.util.*;
import java.io.*;
public class essay {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		for(int i = 0; i<5; i++) {
			String s = readLine();
			boolean inline = false;
			for(int j = 0; j<s.length()-1; j++) {
				if(s.charAt(j) == '/') {
					if(s.charAt(j+1) == '*') {
						for(int k = j+2; k<s.length()-1; k++) {
							if(s.charAt(k) == '*' && s.charAt(k+1) == '/') {
								if(inline) {
									System.out.print(" "+s.substring(j+2,k));
								}
								else {
								System.out.print(s.substring(j+2,k));
								}
								inline = true;
								j=k+1;
								break;
							}
						}
					}
					else if(s.charAt(j+1) == '/') {
						if(inline) {
						System.out.print(" "+s.substring(j+2,s.length()));
						}
						else {
							System.out.print(s.substring(j+2,s.length()));
						}
						break;
					}
				}
				else if(s.charAt(j) == '"') {
					for(int k = j+1; k<s.length(); k++) {
						if(s.charAt(k) == '"') {
							if(inline) {
							System.out.print(" "+s.substring(j+1,k));
							}
							else {
								System.out.print(s.substring(j+1,k));
							}
							inline = true;
							j=k;
							break;
						}
					}
				}
				else if((s.charAt(j)+"").equals("'")) {
					for(int k = j+1; k<s.length(); k++) {
						if((s.charAt(k)+"").equals("'")) {
							if(inline) {
								System.out.print(" "+s.substring(j+1,k));
							}
							else {
							System.out.print(s.substring(j+1,k));
							}
							inline = true;
							j=k;
							break;
						}
					}
				}
			}
			System.out.println();
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