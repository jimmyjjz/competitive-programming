import java.util.*;
import java.io.*;
public class MinimumCostFlow{
	static class stat{
		int u,v,w,q;
		public stat(int u, int v, int w, int q) {
			this.u=u;
			this.v=v;
			this.w=w;
			this.q=q;
		}
	}
	static int disjoint[];
	static int findrep(int d) {  
		while(d!=disjoint[d]) {
			disjoint[d] = findrep(disjoint[d]);
			d=disjoint[d];
		}
		return d;
		}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), M = readInt(), D = readInt(), day = 0, pre = 0;
		disjoint = new int[N+1];
		List<stat> edges = new ArrayList<stat>();
		    for(int i = 1; i<=N; i++)disjoint[i]=i;
		    for(int i = 1; i<=M; i++)edges.add(new stat(readInt(),readInt(),readInt(),i>N-1?1:0));
		    Collections.sort(edges, (a,b)->Integer.compare(a.w,b.w)==0?Integer.compare(a.q,b.q):Integer.compare(a.w,b.w));
		    for(int i = 0; i<M; i++){
		        int a = findrep(edges.get(i).u), b = findrep(edges.get(i).v);
		        if(a!=b) {
		        	disjoint[a]=b;
		        	day+=edges.get(i).q;
		        	pre=i;
		        }
		    }
		    if(edges.get(pre).q==0) {
		    	System.out.println(day);
		    	return;
		    }
		    for(int i = 1; i<=N; i++)disjoint[i]=i;
		    for(int i = 0; i<pre; i++) {
		    	if(edges.get(i).q==0||edges.get(i).w<edges.get(pre).w){
		    		int a = findrep(edges.get(i).u), b = findrep(edges.get(i).v);
		            if(a!=b)disjoint[a]=b;
		        }
		    }
		    for(int i = pre; i<M; i++) {
		    	if(edges.get(i).q==0&&edges.get(i).w<=D&&findrep(edges.get(i).u)!=findrep(edges.get(i).v)) { 
		    		day--;
		        	break;
		        }
		    }
		   	System.out.println(day);
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