import java.util.*;
import java.io.*;
public class Personnel {
	static class Novel {
        String name;
        int skill,dex;
        public Novel(String name, int skill, int dex) {
        	this.name = name;
        	this.skill = skill; 
        	this.dex = dex;
        }
    }
    static class SortSO implements Comparator<Novel> {
        public int compare(Novel a, Novel b) { 
            if(a.skill != b.skill){
                return Integer.compare(a.skill, b.skill);
            } 
            else{
                return Integer.compare(a.dex,b.dex);
            }            
        }
    }
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
			int N = readInt();
			Novel arr[] = new Novel[N];
	        for(int i = 0; i<N; i++) {
	        	arr[i] = new Novel(next(),readInt(),i);
	        }
	        Arrays.sort(arr, new SortSO());
	        int Q = readInt();
	        for(int i = 0; i<Q; i++) {
	            int bot = readInt(),top = bot+readInt(), old = 0, max = 2147483647;
	            String nom = "No suitable teacher!";
	            for(int j = 0; j<N; j++) {
	                if(arr[j].skill>=bot && arr[j].skill<=top && old < max){
	                        old = top - arr[j].skill;
	                        max = old;
	                        nom = arr[j].name;
	                    
	                }             
	            }
	            System.out.println(nom);
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