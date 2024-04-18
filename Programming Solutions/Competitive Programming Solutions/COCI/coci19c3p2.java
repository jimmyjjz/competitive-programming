import java.util.*;
import java.io.*;
public class Grudanje {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		char word[] = readLine().toCharArray();
		int Q = readInt(), len = word.length, seg[][] = new int[Q][2], arrange[] = new int[len];
		for(int i = 0; i<Q; ++i) {
			seg[i][0]=readInt();
			seg[i][1]=readInt();
		}
		for(int i = 0; i<len; i++)arrange[readInt()-1]=i;
		int low = 0, high = len;
		while(low<high) {
			int mid = (low+high)/2, psa[][] = new int[26][len+1];
			for(int i = 0; i<len; i++)if(arrange[i]>=mid)psa[word[i]-97][i+1]++;
			for(int i = 0; i<26; i++){
				for(int j = 1; j<=len; j++)psa[i][j]+=psa[i][j-1];
			}
			out:{
				for(int i = 0; i<Q; i++) {
					for(int j = 0; j<26; j++) {
						if(psa[j][seg[i][1]]-psa[j][seg[i][0]-1]>=2){
							low=mid+1;
							break out;
						}
					}
				}
				high=mid;
			}
		}
		System.out.println(low);
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