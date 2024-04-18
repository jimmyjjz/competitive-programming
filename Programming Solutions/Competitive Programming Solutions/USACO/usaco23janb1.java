import java.util.*;
import java.io.*;
public class Leaders {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String cows =  "."+br.readLine();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int ranges[] = new int[N+1], firstH = -1, firstG = -1, lastH = -1, lastG=-1;
		for(int i = 1; i<=N; i++){
			if(cows.charAt(i)=='H') {
				if(firstH==-1)firstH=i;
				lastH=i;
			}
			else {
				if(firstG==-1)firstG=i;
				lastG=i;
			}
			ranges[i]=Integer.parseInt(st.nextToken());
		}
		boolean firstHLeader = false, firstGLeader = false;
		if(ranges[firstH]>=lastH)firstHLeader=true;
		if(ranges[firstG]>=lastG)firstGLeader=true;
		int cnt = 0;
		for(int i = 1; i<=N; i++) {
			if(cows.charAt(i)=='H'&&firstGLeader&&i<firstG&&ranges[i]>=firstG)cnt++;
			else if(cows.charAt(i)=='G'&&firstHLeader&&i<firstH&&ranges[i]>=firstH)cnt++;
		}
		System.out.println(cnt+((firstHLeader&&firstGLeader)?1:0));
	}
}