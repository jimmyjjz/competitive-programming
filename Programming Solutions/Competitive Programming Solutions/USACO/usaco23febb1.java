import java.util.*;
import java.io.*;
public class HungryCow{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		long T = Long.parseLong(st.nextToken()), backlog = 0, day = 0, ate = 0;
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			long a = Long.parseLong(st.nextToken()), b = Long.parseLong(st.nextToken());
			ate+=Math.min(backlog,a-day-1);
			backlog=Math.max(0, backlog-(a-day-1));
			backlog+=b;
			day=a-1;
		}
		ate+=Math.min(backlog,T-day);
		System.out.println(ate);
	}
}