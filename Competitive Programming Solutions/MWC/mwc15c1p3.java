import java.util.*;
import java.io.*;
public class Dolls{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()), freq[] = new int[101], bigV = 0, smallV = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++)freq[Integer.parseInt(st.nextToken())]++;
		for(int i = 1, big = 0, small = Integer.MAX_VALUE; i<=100; i++) {
			if(freq[i]==0)continue;
			if(freq[i]>=big) {
				big=freq[i];
				bigV=i;
			}
			if(freq[i]<small) {
				small=freq[i];
				smallV=i;
			}
		}
		System.out.println(Math.abs(bigV-smallV));
	}
}