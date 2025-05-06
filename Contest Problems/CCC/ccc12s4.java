import java.util.*;
import java.io.*;
public class ACoinGame{
	static class state{
		int m, coins[];
		state(int m, int[] coins){
			this.m=m;
			this.coins=coins;
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		while(true) {
		int N = readInt();
		if(N==0)break;
		int coins[] = new int[N], goal[] = new int[N];
		for(int i = 0; i<N; i++) {
			coins[i]=1<<(readInt()-1);
			goal[i]=1<<i;
		}
		String goalS = Arrays.toString(goal);
		Queue<state> q = new LinkedList<state>();
		Set<String> visited = new HashSet<String>();
		q.add(new state(0,coins));
		out:{
		while(!q.isEmpty()) {
			state poll = q.poll();
			String pollS = Arrays.toString(poll.coins);
			if(!visited.contains(pollS)) {
				if(pollS.equals(goalS)) {
					System.out.println(poll.m);
					break out;
				}
				visited.add(pollS);
				for(int i = 0; i<N-1; i++) {
					if(poll.coins[i]==0&&poll.coins[i+1]!=0) {
						int[] arr = poll.coins.clone();
						arr[i]=poll.coins[i+1]&-poll.coins[i+1];
						arr[i+1]-=poll.coins[i+1]&-poll.coins[i+1];
						q.add(new state(poll.m+1,arr));
					}
					else if(poll.coins[i]!=0&&poll.coins[i+1]==0) {
						int[] arr = poll.coins.clone();
						arr[i]-=poll.coins[i]&-poll.coins[i];
						arr[i+1]=poll.coins[i]&-poll.coins[i];
						q.add(new state(poll.m+1,arr));
					}
					if((poll.coins[i]&-poll.coins[i])<(poll.coins[i+1]&-poll.coins[i+1])) {
						int[] arr = poll.coins.clone();
						arr[i]-=poll.coins[i]&-poll.coins[i];
						arr[i+1]+=poll.coins[i]&-poll.coins[i];
						q.add(new state(poll.m+1,arr));
					}
					else {
						int[] arr = poll.coins.clone();
						arr[i]+=poll.coins[i+1]&-poll.coins[i+1];
						arr[i+1]-=poll.coins[i+1]&-poll.coins[i+1];
						q.add(new state(poll.m+1,arr));
					}
				}
			}
		}
			System.out.println("IMPOSSIBLE");
		}
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