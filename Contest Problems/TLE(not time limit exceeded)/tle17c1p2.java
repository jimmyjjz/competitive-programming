import java.util.*;
import java.io.*;
public class willson {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		 HashMap<String,Integer> foods = new HashMap<String,Integer>();
		 List<String> food = new ArrayList<String>();
		 List<Integer> meter = new ArrayList<Integer>();
		 List<Integer> valid = new ArrayList<Integer>();
		 int save = 0;
		 int F = readInt();
		 int index = 0;
		 int target = 0;
		 int count = 0;
		 int energy = 0;
		 for(int i = 0; i<F; i++) {
			 StringTokenizer split = new StringTokenizer(readLine()," ");
			 foods.put(split.nextToken(),Integer.parseInt(split.nextToken()));
		 }
		 int N = readInt();
		 for(int j = 0; j<N; j++) {
			 StringTokenizer split = new StringTokenizer(readLine()," ");
			 food.add(split.nextToken());
			 save = Integer.parseInt(split.nextToken());
			 meter.add(save);
			 valid.add(save);
			 }
		 Collections.sort(valid);
		 while(!food.isEmpty()) {
			 target = valid.remove(0);
				energy =  energy - (target - index);
				if(energy < 0 && target != index) {
					break;
				}
				index = target;
				 energy = energy + foods.get(food.remove(meter.indexOf(target)));
				 meter.remove(meter.indexOf(target));
				 count++;
			 if(meter.indexOf(target) == -1) {
				 if(energy <= 0) {
					 break;
				 }
			 }
		 }
		 System.out.println(count);
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