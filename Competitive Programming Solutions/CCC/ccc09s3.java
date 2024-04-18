import java.util.*;
import java.io.*;
public class DegreesOfSeparation {
	public static Map<Integer,List<Integer>> connections = new HashMap<Integer,List<Integer>>();
	public static void friend(int a, int b) {
		List<Integer> bind = new ArrayList<Integer>(connections.get(a));
		bind.add(b);
		connections.put(a,bind);
		bind = connections.get(b);
		bind.add(a);
		connections.put(b,bind);
	}
	public static void unfriend(int a, int b) {
		List<Integer> bind = new ArrayList<Integer>(connections.get(a));
		if(bind.contains(b)) {
		bind.remove(bind.indexOf(b));
		}
		connections.put(a, bind);
		bind = connections.get(b);
		if(bind.contains(a)) {
		bind.remove(bind.indexOf(a));
		}
		connections.put(b, bind);
	}
	public static int FofF(int in) {
		List<Integer> direct = new ArrayList<Integer>(connections.get(in));
		Set<Integer> dupe = new HashSet<Integer>();
		for(int i = 0; i<direct.size(); i++) {
			List<Integer> port = new ArrayList<Integer>(connections.get(direct.get(i)));
			for(int j = 0; j<port.size(); j++) {
				if(!direct.contains(port.get(j))) {
					dupe.add(port.get(j));
				}
			}
		}
		return dupe.size()-1;
	}
	public static void separation(int a, int b) {
		Set<Integer> store = new HashSet<Integer>(connections.get(a));
		List<Integer> tracked = new ArrayList<Integer>();
		int dex = 1;
		if(store.contains(b)) {
			System.out.println(dex);
			return;
		}
		while(store.size() > 0) {
			dex++;
			//System.out.println(store);
			List<Integer> grand = new ArrayList<Integer>(store);
			store.clear();
			for(int i = 0; i<grand.size(); i++) {
				if(tracked.contains(grand.get(i))) {
					continue;
				}
				tracked.add(grand.get(i));
				List<Integer> temp = new ArrayList<Integer>(connections.get(grand.get(i)));
				for(int j = 0; j<temp.size(); j++) {
				if(temp.get(j) == b) {
					System.out.println(dex);
					return;
				}
				store.add(temp.get(j));
				}
			}
		}
		System.out.println("Not connected");
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		for(int i = 1; i<50; i++) {
			List<Integer> insert = new ArrayList<Integer>();
			connections.put(i,insert);
		}
		//setup 
		friend(2,6);friend(6,1);friend(6,7);
		friend(3,6);friend(3,4);friend(3,5);
		friend(4,6);friend(4,5);friend(8,7);
		friend(9,8);friend(15,3);friend(12,9);
		friend(12,11);friend(11,10);friend(10,9);
		friend(13,15);friend(13,12);friend(16,18);
		friend(16,17);friend(14,13);friend(18,17);
		friend(6,5);
		//22 total
		//
		while(true) {
			//System.out.println(connections);
			switch(readCharacter()) {
			case 'i':
				friend(readInt(),readInt());
				break;
			case 'd':
				unfriend(readInt(),readInt());
				break;
			case 'n':
				System.out.println(connections.get(readInt()).size());
				break;
			case 'f':
				System.out.println(FofF(readInt()));
				break;
			case 's':
				separation(readInt(),readInt());
				break;
			case 'q':
				System.exit(0);
				break;
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