import java.util.*;
import java.io.*;
public class DeathGun {
	public static List<String> dex = new ArrayList<String>();
	public static String[] match;
	public static void send(String s) {
		if(!dex.contains(s)){
			dex.add(s);
            match[dex.indexOf(s)] = s;
        }
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		//str to int
        int M = readInt(), sz = 10000;
        ArrayList<Integer>[] tree = new ArrayList[sz+1];
        int[] req = new int[sz+1];
        match = new String[M+1];
        for(int i = 0; i<=sz; i++) tree[i] = new ArrayList<Integer>();
        for(int i = 0; i<M; i++){
            String x = next(), y = next();
            send(x);
            send(y);
            req[dex.indexOf(x)]++;
            tree[dex.indexOf(y)].add(dex.indexOf(x));
        }
        //System.out.println(tree);
        //System.out.println(Arrays.toString(match));
        boolean fg = true;
        while(fg){
            fg = false;
            for(int i = 0; i<dex.size(); i++){
                if(req[i] == 0){
                	req[i]--;
                    System.out.println(match[i]);
                    for(int n : tree[i]) req[n]--;
                    fg = true;
                    break;
                }
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