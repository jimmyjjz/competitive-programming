import java.util.*;
import java.io.*;
public class SwappingSeats {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		String s = readLine();
		int len = s.length();
		char[] ori = new char[len];
		Map<Character, Integer> correspondence = new HashMap<Character, Integer>();
		int min=Integer.MAX_VALUE;
		correspondence.put('A', 0);
		correspondence.put('B', 0);
		correspondence.put('C', 0);
		for(int i = 0; i<len; i++) {
			ori[i]=s.charAt(i);
			if(ori[i]=='A')correspondence.put('A', correspondence.get('A')+1);
			else if(ori[i]=='B')correspondence.put('B', correspondence.get('B')+1);
			else correspondence.put('C', correspondence.get('C')+1);
		}
		//System.out.println(correspondence);
		//System.out.println(Arrays.toString(ori));
		StringTokenizer permutations = new StringTokenizer("ABC ACB BAC BCA CBA CAB"," ");
		while(permutations.hasMoreTokens()) {
		String token = permutations.nextToken();
		char[] permu = new char[len];
		int Abot=0,Atop=0,Bbot=0,Btop=0;
		int a = correspondence.get(token.charAt(0));
		for(int i = 0; i<a; i++)permu[i]=token.charAt(0);
		if(token.charAt(0)=='A') {
			Abot=0;
			Atop=a;
		}
		else if(token.charAt(0)=='B') {
			Bbot=0;
			Btop=a;
		}
		int b = correspondence.get(token.charAt(1));
		for(int i = a; i<a+b; i++)permu[i]=token.charAt(1);
		if(token.charAt(1)=='A') {
			Abot=a;
			Atop=a+b;
		}
		else if(token.charAt(1)=='B') {
			Bbot=a;
			Btop=a+b;
		}
		int c = correspondence.get(token.charAt(2));//p
		for(int i = a+b; i<a+b+c; i++)permu[i]=token.charAt(2);
		if(token.charAt(2)=='A') {
			Abot=a+b;
			Atop=a+b+c;
		}
		else if(token.charAt(2)=='B') {
			Bbot=a+b;
			Btop=a+b+c;
		}
		//System.out.println(Arrays.toString(permu));
		int A=0, B=0, AB=0, BA=0;
		for(int i = 0; i<len; i++) {
			if(permu[i]!='A'&&ori[i]=='A') {
				A++;
				if(permu[i]=='B')AB++;
			}
			else if(permu[i]!='B'&&ori[i]=='B') {
				B++;
				if(permu[i]=='A')BA++;
			}
		}
		min=Math.min(min,A+B-Math.min(AB, BA));
		//System.out.println(A+" "+B+" "+AB+" "+BA);
		//System.out.println(A+B-Math.min(AB, BA));
		if(Atop>=len)Atop=0;
		if(Btop>=len)Btop=0;
		if(Abot>=len)Abot=0;
		if(Bbot>=len)Bbot=0;
		for(int i = 0; i<len; i++) {
			if(ori[Atop]!='A'){
				A++;
				if(ori[Atop]=='B')BA++;
			}
			if(ori[Btop]!='B') {
				B++;
				if(ori[Btop]=='A')AB++;
			}
			if(ori[Abot]!='A') {
				A--;
				if(ori[Abot]=='B')BA--;
			}
			if(ori[Bbot]!='B') {
				B--;
				if(ori[Bbot]=='A')AB--;
			}
			//System.out.println("=> "+Abot+" "+Atop+" "+Bbot+" "+Btop);
			//System.out.println("--> "+ori[Abot]+" "+ori[Atop]+" "+ori[Bbot]+" "+ori[Btop]);
			//System.out.println(A+" "+B+" "+AB+" "+BA);
			//System.out.println(A+B-Math.min(AB, BA));
			min=Math.min(min,A+B-Math.min(AB, BA));
			Atop++;
			Btop++;
			if(Atop>=len)Atop=0;
			if(Btop>=len)Btop=0;
			Abot++;
			Bbot++;
			if(Abot>=len)Abot=0;
			if(Bbot>=len)Bbot=0;
		}
		}
		System.out.println(min);
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