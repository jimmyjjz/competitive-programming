import java.util.*;
import java.io.*;
public class bobshuffle {
	public static long getvalue(int[] arr, int N) {
		long total = 0;
		for(int i = 0; i<N-1; i++) {
			total+=Math.abs(arr[i]-arr[i+1]);
		}
		return total;
	}
	public static long HighLow(List<Integer> sorted, int[] arr, int N) {
		int big = sorted.size(), small = -1, fixed = sorted.size();
		int[] clone = arr.clone();
		for(int i = 1; i<=fixed; i++) {
			if(i%2==0) {
				small++;
				arr[i]=sorted.get(small);
			}
			else {
				big--;
				arr[i]=sorted.get(big);
			}
		}
		big = sorted.size();
		small = -1;
		for(int i = 1; i<=fixed; i++) {
			if(i%2!=0) {
				small++;
				clone[i]=sorted.get(small);
			}
			else {
				big--;
				clone[i]=sorted.get(big);
			}
		}
		long a = getvalue(arr,N), b = getvalue(clone,N);
		if(a>b) {
			//System.out.println(Arrays.toString(arr));
			return a;
		}
		//System.out.println(Arrays.toString(clone));
		return b;
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt();
		List<Integer> nums = new ArrayList<Integer>();
		for(int i = 0; i<N; i++) {
			nums.add(readInt());
		}
		Collections.sort(nums);
		long result;
		if(N%2==0) {
			int[] out = new int[N];
			out[0]=nums.remove(N/2-1);
			out[N-1]=nums.remove(N/2-1);
			result = HighLow(nums,out,N);
		}
		else {
			List<Integer> clone = new ArrayList<Integer>(nums);
			int[] a = new int[N];
			int[] b = new int[N];
			a[0]=clone.remove(N/2);
			a[N-1]=clone.remove(N/2);
			b[0]=nums.remove(N/2-1);
			b[N-1]=nums.remove(N/2-1);
			result = Math.max(HighLow(clone,a,N),HighLow(nums,b,N));
		}
		System.out.println(result);
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