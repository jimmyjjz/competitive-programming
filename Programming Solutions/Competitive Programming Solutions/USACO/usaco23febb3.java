import java.util.*;
import java.io.*;
public class MooLoo{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		long pre = Long.parseLong(st.nextToken()), tot = 1+K;
		for(int i = 1; i<N; i++) {
			long cur = Long.parseLong(st.nextToken());
			tot+=Math.min(cur-pre, K+1);
			pre=cur;
		}
		System.out.println(tot);
	}
}