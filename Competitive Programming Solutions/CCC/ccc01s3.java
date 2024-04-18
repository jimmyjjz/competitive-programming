import java.util.*;
import java.io.*;
public class StrategicBombing {
	static class pair{
		int a,b;
		String s;
		public pair(int a, int b, String s) {
			this.a=a;
			this.b=b;
			this.s=s;
		}
	}
	public static List<Integer>[] tree = new ArrayList[26];
	public static List<List<Integer>> all = new ArrayList<List<Integer>>();
	public static void allpath(boolean[] valid, Stack<Integer> path) {
		if(path.peek()==1) {
			List<Integer> save = new ArrayList<Integer>(path);
			all.add(save);
			return;
		}
		if(!valid[path.peek()]) {
			valid[path.peek()]=true;
			int fixed = tree[path.peek()].size();
			for(int i = 0; i<fixed; i++) {
				path.push(tree[path.peek()].get(i));
				allpath(valid,path);
				path.pop();
			}
			valid[path.peek()]=false;
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		//-65 for each letter to get number 
		for(int i = 0; i<26; i++) tree[i]=new ArrayList<Integer>();
		while(true) {
			String road = readLine();
			if(road.equals("**")) break;
			tree[(road.charAt(0)-65)].add((road.charAt(1)-65));
			tree[(road.charAt(1)-65)].add((road.charAt(0)-65));
		}
		Stack<Integer> insert = new Stack<Integer>();
		insert.push(0);
		allpath(new boolean[26], insert);
		int N = all.size(); 
		Set<pair> convert = new HashSet<pair>();
		Map<String,Integer> cnt = new HashMap<String,Integer>();
		for(int i = 0; i<N; i++) {
			int fixed = all.get(i).size();
			for(int j = 1; j<fixed; j++) {
				String road = all.get(i).get(j-1)+""+all.get(i).get(j);
				if(cnt.get(road) == null) {
					convert.add(new pair(all.get(i).get(j-1),all.get(i).get(j),road));
					cnt.put(road,0);
				}
				cnt.put(road,cnt.get(road)+1);
			}
		}
		//System.out.println(all);
		List<pair> key = new ArrayList<pair>(convert);
		int fixed = key.size(), count = 0;
		for(int i = 0; i<fixed; i++) {
			if(cnt.get(key.get(i).s) == N) {
				System.out.println((char)(Integer.parseInt(key.get(i).a+"")+65)+""+(char)(Integer.parseInt(key.get(i).b+"")+65));
				count++;
			}
		}
		System.out.println("There are "+count+" disconnecting roads.");
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