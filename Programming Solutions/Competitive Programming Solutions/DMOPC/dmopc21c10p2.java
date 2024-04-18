import java.util.*;
import java.io.*;
public class CycleSort{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static boolean bigger(int[] a, int[] b, int N) {
		for(int i = 0; i<N; i++) {
			if(a[i]>b[i])return false;
			else if(a[i]<b[i])return true;
		}
		return true;
	}
	public static void main(String[] args) throws IOException{
		int N = readInt();
		if(N==1) {
			readInt();
			System.out.println(1);
			return;
		}
		List<Integer> nums = new ArrayList<Integer>();
		for(int i = 0; i<N; i++)nums.add(readInt());
		int[] firstone = new int[N], secondtwo = new int[N];
		int firstdex = nums.indexOf(1), seconddex = (nums.indexOf(2)-1)==-1?N-1:(nums.indexOf(2)-1), dex = 0, spot = -1;
		for(int i = firstdex; i<N; i++) {
			firstone[dex]=nums.get(i);
			dex++;
		}
		for(int i = 0; i<firstdex; i++) {
			firstone[dex]=nums.get(i);
			dex++;
		}
		dex = 0;
		for(int i = seconddex; i<N; i++) {
			secondtwo[dex]=nums.get(i);
			dex++;
		}
		for(int i = 0; i<seconddex; i++) {
			secondtwo[dex]=nums.get(i);
			dex++;
		}
		boolean flag = false;
		for(int i = 0; i<N; i++) {
			if(!flag&&firstone[i]!=i+1) {
				flag=true;
				spot=i;
			}
			else if(firstone[i]==spot+1) {
				firstone[i]=firstone[spot];
				firstone[spot]=spot+1;
				break;
			}
		}
		for(int i = 0; i<N; i++) {
			if(secondtwo[i]==1) {
				secondtwo[i]=secondtwo[0];
				secondtwo[0]=1;
				break;
			}
		}
		int[] edge = new int[N];
		dex = 0;
		for(int i = seconddex+1; i<N; i++) {
			edge[dex]=nums.get(i);
			dex++;
		}
		for(int i = 0; i<seconddex+1; i++) {
			edge[dex]=nums.get(i);
			dex++;
		}
		for(int i = 0; i<N; i++){
			if(edge[i]==1) {
				edge[i]=2;
				edge[0]=1;
				break;
			}
		}
		
		if(bigger(firstone,secondtwo,N)) {
			if(bigger(firstone,edge,N)) {
			System.out.print(firstone[0]);
			for(int i = 1; i<N; i++)System.out.print(" "+firstone[i]);
			System.out.println();
			}
			else {
				System.out.print(edge[0]);
				for(int i = 1; i<N; i++)System.out.print(" "+edge[i]);
				System.out.println();
			}
		}
		else {
			if(bigger(secondtwo,edge,N)) {
			System.out.print(secondtwo[0]);
			for(int i = 1; i<N; i++)System.out.print(" "+secondtwo[i]);
			System.out.println();
			}
			else {
				System.out.print(edge[0]);
				for(int i = 1; i<N; i++)System.out.print(" "+edge[i]);
				System.out.println();
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