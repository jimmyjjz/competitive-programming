import java.util.*;
import java.io.*;
public class HwHelp2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException{
		int N = Integer.parseInt(br.readLine());
		for(int i = 1; i<=N; i++) {
			String s = br.readLine(), num = "", str="";
			int fixed = s.length();
			for(int j = 0; j<fixed; j++) {
				if(Character.isWhitespace(s.charAt(j))) {
					str=s.substring(j+1,fixed);
					break;
				}
				num+=s.charAt(j);
			}
			int dex = Integer.parseInt(num)-1;
			//System.out.println(dex+" - "+str);
			System.out.println(i+" "+(str.substring(0,dex)+str.substring(dex+1,str.length())));
		}
	}
}