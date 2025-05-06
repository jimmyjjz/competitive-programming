import java.util.*;
import java.io.*;
public class phone {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		Map<Integer,String> names = new HashMap<Integer,String>();
		List<Integer> nums = new ArrayList<Integer>();
		List<Integer> current = new ArrayList<Integer>();
		int save = 0;
		String saveS = "";
		int savenum = 0;
		int smallnum = 0;
		int highest = 0;
		int N = readInt();
		for(int i = 0; i<N; i++) {
			StringTokenizer split = new StringTokenizer(readLine(), " ");
			saveS = split.nextToken();
			save = Integer.parseInt(split.nextToken());
			names.put(save,saveS);
			nums.add(save);
		}
		int D = readInt();
		for(int j = 0; j<D; j++) {
			current.add(readInt());
		}
		for(int k = 0; k<N; k++) {
			savenum = nums.remove(0);
			save = current.size();
			current.removeAll(Collections.singleton(savenum));
			save = save - current.size();
			if(highest < save) {
				highest = save;
				smallnum = savenum;
			}
			else if(highest == save && savenum < smallnum) {
				smallnum = savenum;
			}
		}
		System.out.println(names.get(smallnum));
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