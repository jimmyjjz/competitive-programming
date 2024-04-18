import java.util.*;
import java.io.*;
public class WTCCC {
	static class Question{
		int indexa, indexb;
		public Question(int indexa, int indexb){
			this.indexa=indexa;//priority order
			this.indexb=indexb;//in list order
		}
	}
	static class order implements Comparator<Question> {
        public int compare(Question a, Question b) { 
            if(a.indexa != b.indexa){
                return Integer.compare(a.indexa, b.indexa);
            } 
            else{
                return Integer.compare(a.indexb,b.indexb);
            }            
        }
    }
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
	Map<String,Integer> index = new HashMap<String,Integer>();
	int T = readInt();
	for(int i = 0; i<T; i++) {
		index.put(readLine(),i);
	}
	List<Question> Qs = new ArrayList<Question>();
	int N = readInt();
	for(int i = 0; i<N; i++) {
		String in = readLine();
		Qs.add(new Question(index.get(in), i));
	}
	Collections.sort(Qs, new order());
	for(int i = 0; i<N; i++) {
		System.out.println(Qs.get(i).indexb+1);
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