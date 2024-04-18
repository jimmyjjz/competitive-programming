import java.util.*;
import java.io.*;
public class KeepOnTruckin {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int A = readInt(), B = readInt(), N = readInt();
		int[] motels = new int[14+N];
		StringTokenizer add = new StringTokenizer("0,990,1010,1970,2030,2940,3060,3930,4060,4970,5030,5990,6010,7000",",");
		for(int i = 0; i<14; i++) {
			motels[i]=Integer.parseInt(add.nextToken());
		}
		for(int i = 14; i<14+N; i++) {
			motels[i]=readInt();
		}
		Arrays.sort(motels);
		//System.out.println(Arrays.toString(motels));
		Map<Integer,Long> values = new HashMap<Integer,Long>();
		Map<Integer,Boolean> found = new HashMap<Integer,Boolean>();
		Stack<Integer> current = new Stack<Integer>();
		current.push(7000);
		values.put(7000, (long) 1);
		while(!current.isEmpty()) {
			int n = current.pop();
			if(found.get(n)!=null)continue;
			for(int i = 0; i<14+N; i++) {
				if(n-motels[i]<=B&&n-motels[i]>=A) {
					if(values.get(motels[i])==null) {
						//System.out.println(motels[i]+" "+n);
						values.put(motels[i], values.get(n));
					}
					else {
						//System.out.println(motels[i]+" "+n);
						values.put(motels[i], values.get(motels[i])+values.get(n));
					}
					current.push(motels[i]);
				}
			}
			found.put(n, true);
			Collections.sort(current);
		}
		//System.out.println(values);
		System.out.println((values.get(0)==null)?"0":values.get(0));
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