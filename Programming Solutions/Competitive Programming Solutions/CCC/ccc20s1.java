import java.util.*;
import java.io.*;
class observation{
	double time, place;
	public observation(double time, double place) {
		this.time = time;
		this.place = place;
	}
	 public static double getTime(observation a) {
		 return a.time;
	 }
	 public static double getPlace(observation a) {
		 return a.place;
	 }
}
class Sortbytime implements Comparator<observation>{
	public int compare(observation a, observation b) {
		return (int) (a.time - b.time);
	}
}
public class sprint {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
	List<observation> Ob = new ArrayList<observation>();
	int N = readInt();
	for(int i = 0; i<N; i++) {
		Ob.add(new observation(readDouble(), readDouble()));
	}
	Collections.sort(Ob, new Sortbytime());
	double biggest = 0;
	for(int i = 0; i<N-1; i++) {
		biggest = Math.max(biggest,Math.abs(observation.getPlace(Ob.get(i))-observation.getPlace(Ob.get(i+1)))/Math.abs(observation.getTime(Ob.get(i+1))-observation.getTime(Ob.get(i))));
	}
	System.out.println(biggest);
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