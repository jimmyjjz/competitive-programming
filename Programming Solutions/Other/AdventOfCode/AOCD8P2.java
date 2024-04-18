import java.util.*;
import java.io.*;
public class AOCD8P2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static int hash(String s) {
		return (s.charAt(0)-'0')*31+(s.charAt(1)-'0')*31*31+(s.charAt(2)-'0')*31*31*31;
	}
    public static long gcd(long a, long b) { 
        if(a==0)return b;  
        return gcd(b%a,a);  
    }  
    public static long lcm(long a, long b) {return(a/gcd(a,b))*b;} 
	public static void main(String[] args) throws IOException {
		String d = readLine();
		int network[][] = new int[1292887][2];//1292886 ZZZ
		List<Integer> curNodes = new ArrayList<Integer>();
		readLine();
		for(int i = 0; i<714; i++) {
			st = new StringTokenizer(readLine().replaceAll("[=(),]","")," ");
			String s = st.nextToken();
			int temp=hash(s);
			if(s.charAt(2)=='A')curNodes.add(temp);
			network[temp][0]=hash(st.nextToken());
			network[temp][1]=hash(st.nextToken());
		}
		int size=curNodes.size(),z[] = new int[size];
		long cnt=0;
		while(true) {
			if(d.charAt((int)(cnt%d.length()))=='R')for(int i = 0; i<size; i++)curNodes.set(i,network[curNodes.get(i)][1]);
			else for(int i = 0; i<size; i++)curNodes.set(i,network[curNodes.get(i)][0]);
			cnt++;
			for(int i = 0; i<size; i++)if(curNodes.get(i)>=1251222&&z[i]==0)z[i]=(int)cnt;
			boolean b = true;
			for(int i = 0; i<size; i++)if(z[i]==0)b=false;
			if(b)break;
		}
		long ans = 1;
		for(int n : z)ans=lcm(ans,n);
		System.out.println(ans);
	}
	static String next() throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}

	static long readLong() throws IOException {
		return Long.parseLong(next());
	}

	static int readInt() throws IOException {
		return Integer.parseInt(next());
	}

	static double readDouble() throws IOException {
		return Double.parseDouble(next());
	}

	static char readCharacter() throws IOException {
		return next().charAt(0);
	}

	static String readLine() throws IOException {
		return br.readLine().trim();
	}
}