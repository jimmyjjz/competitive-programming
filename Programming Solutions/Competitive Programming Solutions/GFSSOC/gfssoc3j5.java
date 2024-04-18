import java.util.*;
import java.io.*;
public class SecretSanta {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	  public static Set<String> permutes(String in){
		    Set<String> process = new TreeSet<String>();
		    if (in.length() == 1){
		    	process.add(in);
		    }
		    else {
		      for (int i = 0; i<in.length(); i++){
		        for (String make : permutes(in.substring(0, i)+in.substring(i+1))){
		        	process.add(in.charAt(i) + make);
		        }
		      }
		    }
		    return process;
		  }
	public static void main(String[] args) throws IOException{
		int N = readInt(), sum = 0;
		int[][] grid = new int[N][2];//floor & weight
		for(int i = 0; i<N; i++) {
			int a = readInt(), b = readInt();
			grid[i][0]=a;
			grid[i][1]=b;
			sum+=b;
		}
		String s = "";
		for(int i = 0; i<N; i++) {
			s+=i;
		}
		List<String> order = new ArrayList<String>(permutes(s));
		//System.out.println(order);
		long total = 0, min = Integer.MAX_VALUE;
		for(int i = 0; i<order.size(); i++) {
			int temp = sum, place = 101;
			String now = order.get(i);
			for(int j = 0; j<N; j++) {
				total+=temp*(Math.abs(place-grid[Integer.parseInt(now.charAt(j)+"")][0])+1);
				temp-=grid[Integer.parseInt(now.charAt(j)+"")][1];
				place = grid[Integer.parseInt(now.charAt(j)+"")][0];
			}
			min = Math.min(total,min);
			total = 0;
		}
		System.out.println(min);
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