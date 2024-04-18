import java.util.*;
import java.io.*;
public class Maths {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int a = readInt(), b = readInt(), save = 0, total = 0;
		List<Integer> num = new ArrayList<Integer>();
		Map<Integer,Integer> fre = new HashMap<Integer,Integer>();
		List<Integer> results = new ArrayList<Integer>();
		while (a % 2 == 0) {
			if(fre.get(2) == null) {
				num.add(2);
				fre.put(2, 0);
			}
			fre.put(2, fre.get(2)+1);
            a /= 2;
        }
        for (int i = 3; i <= Math.sqrt(a); i += 2) {
            while (a % i == 0) {
            	if(fre.get(i) == null) {
            		num.add(i);
    				fre.put(i, 0);
    			}
    			fre.put(i, fre.get(i)+1);
                a /= i;
            }
        }
        if (a > 2) {
        	if(fre.get(a) == null) {
        		num.add(a);
				fre.put(a, 0);
			}
			fre.put(a, fre.get(a)+1);
        }
        for(int i = 0; i<num.size(); i++) {
        	save = 0;
        	total = 0;
        	while(true) {
        		 save++;
        		 if(Math.pow(num.get(i), save) > b) {
        			 break;
        		 }
        		 total+= b/Math.pow(num.get(i), save);
        	}
        	results.add(total/fre.get(num.get(i)));
        	
        }
        Collections.sort(results);
        System.out.println(results.get(0));
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