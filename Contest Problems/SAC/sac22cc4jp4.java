import java.util.*;
import java.io.*;
public class ObligatoryPermutationProblem{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt();
		long K = readLong();
		List<List<Integer>> groups = new ArrayList<List<Integer>>();
		int[][] nums = new int[N][2];
		for(int i = 0; i<N; i++)nums[i][0]=-1;
		int[] arr = new int[N];
		for(int i = 0; i<N; i++)arr[i]=readInt()-1;
		for(int i = 0; i<N; i++) {
			if(nums[i][0]==-1) {
				int dex = arr[i];
				List<Integer> seg = new ArrayList<Integer>();
				nums[dex][0]=groups.size();
				nums[dex][1]=seg.size();
				seg.add(dex);
				dex=arr[dex];
				while(arr[i]!=dex) {
					nums[dex][0]=groups.size();
					nums[dex][1]=seg.size();
					seg.add(dex);
					dex=arr[dex];
				}
				groups.add(seg);
			}
		}
		int[] result = new int[N];
		for(int i = 0; i<N; i++) {
			long cur = K+nums[i][1];
			cur%=groups.get(nums[i][0]).size();
			result[groups.get(nums[i][0]).get((int)cur)]=arr[i]+1;
		}
		for(int i = 0; i<N-1; i++)System.out.print(result[i]+" ");
		System.out.println(result[N-1]);
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