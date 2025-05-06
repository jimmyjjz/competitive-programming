import java.util.*;
import java.io.*;
public class HyperFax{
	static class ends{
		int l,r;
		public ends(int l, int r) {
			this.l=l;
			this.r=r;
		}
	}
	public static class Sortbyv implements Comparator<ends>{
		public int compare(ends a, ends b) {
			return Integer.compare(a.l,b.l);
		}
	}
	public static int dif(int a, int b) {
		if((a>=0&&b>=0)||(a<=0&&b<=0))return Math.abs(a-b);
		else return Math.abs(Math.min(a,b))+Math.max(a,b);
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt();
		List<ends> n = new ArrayList<ends>(),p = new ArrayList<ends>();
		for(int i = 0; i<N; i++) {
			int a = readInt(), b = readInt();
			if(a>=0)p.add(new ends(a, b));
			if(a<=0)n.add(new ends(a, b));
		}
		Collections.sort(n, new Sortbyv());
		Collections.sort(p, new Sortbyv());
		ends[][] dp = new ends[n.size()][p.size()];
		dp[n.size()-1][0]=new ends(p.get(0).r,p.get(0).r);
		int pos = p.size();
		for(int i = n.size()-1; i>=0; i--) {
			for(int j = 0; j<pos; j++) {
				if(dp[i][j]==null)continue;
				try {
				int left = -1;
				if(dp[i][j].l>0)left = dp[i][j].l-dif(n.get(i).l,n.get(i-1).l);
				if(dp[i][j].r>0)left = Math.max(left, dp[i][j].r-dif(p.get(j).l,n.get(i-1).l));
				if(left>=0)left+=n.get(i-1).r;
				int right = left-dif(n.get(i-1).l,p.get(j).l);
				if(dp[i-1][j]==null)dp[i-1][j]=new ends(left,right);
				else{
					dp[i-1][j].l=Math.max(dp[i-1][j].l,left);
					dp[i-1][j].r=Math.max(dp[i-1][j].r,right);
				}
				}catch(Exception e) {}
				try {
				int right = -1;
				if(dp[i][j].l>0)right = dp[i][j].l-dif(n.get(i).l,p.get(j+1).l);
				if(dp[i][j].r>0)right = Math.max(right,dp[i][j].r-dif(p.get(j).l,p.get(j+1).l));
				if(right>=0)right+=p.get(j+1).r;
				int left = right-dif(n.get(i).l,p.get(j+1).l);
				if(dp[i][j+1]==null)dp[i][j+1]=new ends(left,right);
				else{
					dp[i][j+1].l=Math.max(dp[i][j+1].l,left);
					dp[i][j+1].r=Math.max(dp[i][j+1].r,right);
				}
				}catch(Exception e) {}
			}
		}
		int[] nums = new int[N+1];
		int d = 1;
		for(ends e : n)nums[d++]=nums[d-2]+e.r;
		d--;
		for(ends e : p)nums[d++]=nums[d-2]+e.r;
		int max = 0;
		//System.out.println(Arrays.toString(nums));
		for(int i = 0; i<n.size(); i++) {
			for(int j = 0; j<p.size(); j++) {
				if(dp[i][j]==null)continue;
				if(dp[i][j].l>0||dp[i][j].r>0) {
					//System.out.println(nums[n.size()+j]-nums[i]);
					max = Math.max(max,nums[n.size()+j]-nums[i]);
				}
				//System.out.print(dp[i][j].l+" "+dp[i][j].r+" | ");
			}
			//System.out.println();
		}
		System.out.println(max);
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