import java.util.*;
import java.io.*;
public class TugOfWar {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{	
		Deque<Long> A = new ArrayDeque<Long>();
		Deque<Long> B = new ArrayDeque<Long>();
		long Atotal = 0, Btotal =  0, save;
		int N = readInt();
		for(int i = 0; i<N; i++) {
			save = readLong();
			Atotal += save;
			A.push(save);
		}
		long min = Atotal-Btotal;
		while(true){
			if(Math.abs((Atotal-A.peek())-(Btotal+A.peek())) < min) {
				Atotal -= A.peek();
				Btotal += A.peek();
				min = Math.abs(Atotal-Btotal);
				B.push(A.pop());
			}
			else {
				break;
			}
		}
		System.out.print(Math.abs(Atotal-Btotal));
		for(int i = 0; i<N-1; i++) {
			Atotal-=A.getLast();
			Btotal+=A.getLast();
			B.addLast(A.removeLast());
			while(true) {
		if(Math.abs(Atotal-Btotal) > Math.abs((Atotal+B.getFirst())-(Btotal-B.getFirst()))) {
			Atotal+=B.getFirst();
			Btotal-=B.getFirst();
			A.addFirst(B.removeFirst());
		}
		else {
			break;
		}
			}

			System.out.print(" "+Math.abs(Atotal-Btotal));
		}
		System.out.println();
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