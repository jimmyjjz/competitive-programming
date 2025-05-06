import java.util.*;
import java.io.*;
public class MooOperations{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i<N; i++) {
			String s = br.readLine();
			int len = s.length();
			if(len<3) {
				System.out.println(-1);
				continue;
			}
			boolean OOO = false, MOO = false, OOM = false, MOM = false;
			for(int j = 0; j<len-2; j++) {
				String cur = s.substring(j,j+3);
				if(cur.equals("OOO"))OOO=true;
				else if(cur.equals("MOO"))MOO=true;
				else if(cur.equals("OOM"))OOM=true;
				else if(cur.equals("MOM"))MOM=true;
			}
			int swaps = Integer.MAX_VALUE;
			if(OOO||MOM)swaps=Math.min(swaps, 1);
			if(MOO)swaps=Math.min(swaps, 0);
			if(OOM)swaps=Math.min(swaps, 2);
			if(swaps==Integer.MAX_VALUE)System.out.println(-1);
			else System.out.println(len-3+swaps);
		}

	}

}