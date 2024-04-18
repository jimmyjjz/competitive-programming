import java.util.*;
import java.io.*;
public class MusicwithMimi{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		String notes[] = ("C C# D D# E F F# G G# A A# B C C# D D# E F F# G G# A A# B C C# D D# E F F# G G# A A# B C C# D D# E F F# G G# A A# B").split(" ");
		int T = readInt();
		for(int i = 0; i<T; i++) {
			int semitone[] = new int[4];
			String in[] = readLine().split(" ");
			int k = 0;
			for(int j = 0; j<4; j++) {
				while(!in[j].equals(notes[k]))k++;
				semitone[j]=k;
			}
			int a = semitone[1]-semitone[0], b = semitone[2]-semitone[1], c = semitone[3]-semitone[2];
			if(a==4&&b==3&&c==3)System.out.println("root");
			else if(a==3&&b==3&&c==2)System.out.println("first");
			else if(a==3&&b==2&&c==4)System.out.println("second");
			else if(a==2&&b==4&&c==3)System.out.println("third");
			else System.out.println("invalid");
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