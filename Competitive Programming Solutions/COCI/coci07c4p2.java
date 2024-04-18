import java.util.*;
import java.io.*;
public class permute {
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
		List<Integer> all = new ArrayList<Integer>();
		String input = readLine();
		int save = 0;
		int staple = Integer.parseInt(input);
		    for (String out : permutes(input)){
		      all.add(Integer.parseInt(out));
		    }
		    Collections.sort(all);
		    while(!all.isEmpty()) {
		    	save = all.remove(0);
		    	if(save > staple) {
		    		System.out.println(save);
		    		return;
		    	}
		    }
		    System.out.println("0");
	}
	static String next () throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}
	static int readInt () throws IOException {
		return Integer.parseInt(next());
	}
	static String readLine () throws IOException {
		return br.readLine().trim();
	}
}