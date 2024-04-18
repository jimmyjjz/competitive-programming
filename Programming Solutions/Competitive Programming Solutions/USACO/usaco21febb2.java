import java.util.*;
import java.io.*;
public class comfort {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		HashMap<String,Integer> cows = new HashMap<String,Integer>(); 
		int count = 0;
		int one = 0;
		int two = 0;
		int N = readInt();
		int total = 0;
		for(int i = 0; i<N; i++) {
			StringTokenizer next = new StringTokenizer(readLine()," ");
			count = 0;
			one = Integer.parseInt(next.nextToken());
			two = Integer.parseInt(next.nextToken());
			if(cows.get((one-1)+" "+two) != null) {
				cows.put((one-1)+" "+two, cows.get((one-1)+" "+two) + 1);
				count++;
				if(cows.get((one-1)+" "+two) == 3){
					total++;
				}
				if(cows.get((one-1)+" "+two) == 4){
					total--;
				}
			}
			if(cows.get((one+1)+" "+two) != null) {
				cows.put((one+1)+" "+two, cows.get((one+1)+" "+two) + 1);
				count++;
				if(cows.get((one+1)+" "+two) == 3){
					total++;
				}
				if(cows.get((one+1)+" "+two) == 4){
					total--;
				}
			}
			if(cows.get(one+" "+(two-1)) != null) {
				cows.put(one+" "+(two-1), cows.get(one+" "+(two-1)) + 1);
				count++;
				if(cows.get(one+" "+(two-1)) == 3){
					total++;
				}
				if(cows.get(one+" "+(two-1)) == 4){
					total--;
				}
			}
			if(cows.get(one+" "+(two+1)) != null) {
				cows.put(one+" "+(two+1), cows.get(one+" "+(two+1)) + 1);
				count++;
				if(cows.get(one+" "+(two+1)) == 3){
					total++;
				}
				if(cows.get(one+" "+(two+1)) == 4){
					total--;
				}
			}
			cows.put(one+" "+two, count);
			if(count == 3) {
				total++;
			}
			System.out.println(total);
		}
	}
	static String next () throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}
	static int readInt () throws IOException {
		return Integer.parseInt(next());
	}
	static String readLine () throws IOException {
		return br.readLine().trim();
	}
}