import java.util.*;
import java.io.*;
public class CountTheTriplets {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), cnt = 0;
        int[] nums = new int[N];
        boolean[] exist = new boolean[2000001];
        for(int i = 0; i<N; i++) {
        	nums[i]=readInt();
            exist[nums[i]]=true;
        }
        Arrays.sort(nums);
        boolean a = false;
        for(int i = 0; i<N; i++) {
            if(a&&nums[i]==nums[i-1])continue;
            else a = true;
            boolean b = false;
            //System.out.println(nums[i]+" "+nums[i-1]);
            for(int j = i+1; j<N; j++) {
                if(nums[j]==nums[j-1]&&b)continue;
              //System.out.println(nums[j]+" "+nums[j-1]);
                else b = true;
                if(exist[nums[i]+nums[j]])cnt++;
            }
        }
		System.out.println((cnt==0)?"-1":cnt);
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