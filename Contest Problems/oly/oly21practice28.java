import java.util.*;
import java.io.*;
public class monster {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		List<Integer> all = new ArrayList<Integer>();
		StringTokenizer split = new StringTokenizer(readLine(), " ");
		int mon = Integer.parseInt(split.nextToken());
		double atk = Double.parseDouble(split.nextToken());
		int stop = Integer.parseInt(split.nextToken());
		long total = 0;
		StringTokenizer cut = new StringTokenizer(readLine(), " ");
		for(int i = 0; i<mon; i++) {
			all.add(Integer.parseInt(cut.nextToken()));
		}
		Collections.sort(all);
		stop = all.size() - stop;
		for(int j = 0; j<stop; j++) {
			if(all.get(j)/atk % 1 == 0) {
				total = (long) (total + all.get(j)/atk);
			}
			else {
				total = (long) (total + (all.get(j)/atk)+1);
			}
		}
		System.out.println(total);
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