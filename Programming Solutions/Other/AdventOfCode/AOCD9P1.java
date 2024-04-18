import java.util.*;
import java.io.*;
public class AOCD9P1 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static List<List<Integer>> difs = new ArrayList<List<Integer>>();
	public static List<Integer> difLi(List<Integer> li) {
		List<Integer> dif = new ArrayList<Integer>();
		for(int i = 0, size=li.size(); i<size-1; i++)dif.add(li.get(i+1)-li.get(i));
		return dif; 
	}
	public static void main(String[] args) throws IOException {
		int total = 0;
		for(int i = 0; i<200; i++) {//200
			difs.clear();
			List<Integer> dif = new ArrayList<Integer>();
			st = new StringTokenizer(readLine()," ");
			while(st.hasMoreTokens())dif.add(Integer.parseInt(st.nextToken()));
			int add=0;
			while(true) {
				String s = dif.toString().replaceAll("[, \\[\\]]",""),s2="";
				for(int j = 0,size=dif.size(); j<size; j++)s2+="0";
				if(s.equals(s2)) {
					for(int j = difs.size()-1; j>=0; j--)add=difs.get(j).get(difs.get(j).size()-1)+add;
					break;
				}
				difs.add(dif);
				dif=difLi(dif);
			}
			total+=add;
		}
		System.out.println(total);
	}
	static String next() throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}

	static long readLong() throws IOException {
		return Long.parseLong(next());
	}

	static int readInt() throws IOException {
		return Integer.parseInt(next());
	}

	static double readDouble() throws IOException {
		return Double.parseDouble(next());
	}

	static char readCharacter() throws IOException {
		return next().charAt(0);
	}

	static String readLine() throws IOException {
		return br.readLine().trim();
	}
}