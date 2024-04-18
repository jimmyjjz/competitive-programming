import java.util.*;
import java.io.*;
public class Blocks {
	static void combination(List<String> comb, int arr[], int n, int r, int index,int data[], int i){
		String save = "";
		if(index == r){
		for(int j=0; j<r; j++) {
			save = save+" "+data[j];
		}
			comb.add(save);
			return;
			}
 			if(i >= n) {
 				return;
 			}
	data[index] = arr[i];
	combination(comb,arr, n, r, index+1, data, i+1);
	combination(comb,arr, n, r, index, data, i+1);
	}
		static void erupt(List<String> comb,int arr[], int n, int r){
			int data[] = new int[r];
		combination(comb,arr, n, r, 0, data, 0);
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		List<String> comb = new ArrayList<String>();
		int target = readInt();
		int amount = readInt();
		int size = 0, total = 0, min = 999;
		int[] blocks = new int[amount];
		for(int i = 0; i<amount; i++) {
			blocks[i] = readInt();
		}
		for(int i = 1; i<=10; i++) {
			erupt(comb,blocks, amount, i);
		}
		for(int i = 0; i<comb.size(); i++) {
		StringTokenizer split = new StringTokenizer(comb.get(i));
		size = split.countTokens();
		total = 0;
		for(int j = 0; j<size; j++) {
			total = total+Integer.parseInt(split.nextToken());
		}
		if(total == target && size < min) {
			min = size;
		}
		}
		if(min == 999) {
		System.out.println("0");
		}
		else {
		System.out.println(min);
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