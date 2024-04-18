import java.util.*;
import java.io.*;
public class PeanutPlanning{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static int findrep(int n, int disjoint[]) {
		while(disjoint[n]!=n)n=disjoint[n];
		return n;
	}
	public static int binarysearchfirst(int[] nums, int n) {
	    int low = 0, high = nums.length-1;
	    while(low<=high){
	        int mid=(low+high)/2;
	        try{if(nums[mid]>=n&&nums[mid-1]<n)return mid;}
	        catch(Exception e) {return mid;}
	        if(nums[mid]<n)low=mid+1;
	        else high = mid-1;
	    }
	    return high+1;
	}
	public static void main(String[] args) throws IOException{
		int N = readInt(), M = readInt(), nums[] = new int[N], point[] = new int[N+1], dex = 0;
		for(int i = 0; i<N; i++) {
			nums[i]=readInt();
			point[i]=i;
		}
		point[N]=N;
		Arrays.sort(nums);
		List<Integer> plan = new ArrayList<Integer>();
		try {
		for(int i = 0; i<N/2; i++){
			point[dex]=findrep(point[dex+1],point);
			plan.add(nums[dex]);
			int temp = binarysearchfirst(nums,M-nums[dex]),rep = findrep(temp,point),save = findrep(point[rep+1],point);
			point[temp]=save;
			point[rep]=save;
			plan.add(nums[rep]);
			dex=findrep(point[dex],point);
		}
		}catch(Exception e) {System.out.println("-1"); return;}
		if(N%2==1)plan.add(nums[dex]);
		for(int i : plan)System.out.print(i+" ");
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