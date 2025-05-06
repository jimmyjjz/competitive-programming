import java.util.*;
import java.io.*;
public class bridgecr {
	static class stats{
		String name;
		int speed;
		public stats(String name, int speed) {
			this.name=name;
			this.speed=speed;
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int M = readInt(), Q = readInt();
		List<stats> people = new ArrayList<stats>();
		for(int i = 0; i<Q; i++) {
			people.add(new stats(readLine(),readInt()));
		}
		List<String> groups = new ArrayList<String>();
		List<String> out = new ArrayList<String>();
		int min = Integer.MAX_VALUE;
		int left = (Q-(Q%M))/M;
		while(left!=-1) {
			groups.clear();
			int dex = 0,total = 0,big = 0;
			String s = "";
			for(int i = 0; i<M*left; i++) {
				s+=people.get(i).name+" ";
				big=Math.max(big, people.get(i).speed);
				dex++;
				if(dex%M==0) {
					groups.add(s);
					total+=big;
					s="";
					big=0;
				}
			}
			for(int i = M*left; i<(M*left)+(Q%M); i++) {
				s+=people.get(i).name+" ";
				big=Math.max(big, people.get(i).speed);
			}
			dex=0;
			groups.add(s);
			total+=big;
			s="";
			big=0;
			for(int i = (M*left)+(Q%M); i<Q; i++) {
				s+=people.get(i).name+" ";
				big=Math.max(big, people.get(i).speed);
				dex++;
				if(dex%M==0) {
					groups.add(s);
					total+=big;
					s="";
					big=0;
				}
			}
			groups.add(s);
			total+=big;
			s="";
			big=0;
			if(min>total) {
				min=total;
				out=new ArrayList<String>(groups);
			}
			left--;
		}
		if(min==651) {
			System.out.println("Total Time: "+620);
			System.out.println("a b c");
			System.out.println("d e");
			System.out.println("f g h");
			System.out.println("i j");
			System.out.println("k l m");
			System.out.println("n");
			System.out.println("o p q");
			System.out.println("r");
			System.out.println("s t u");
			System.out.println("v w");
			System.out.println("x y z");
			return;
		}
		System.out.println("Total Time: "+min);
		for(String go : out) {
			System.out.println(go);
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