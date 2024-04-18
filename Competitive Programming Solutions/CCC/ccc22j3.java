import java.util.*;
import java.io.*;
public class Main {//Harp Tuning
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine(), cur = "";
		int len = s.length();
		boolean num = false;
		for(int i = 0; i<len; i++) {
			if(Character.isAlphabetic(s.charAt(i))&&num) {
				num=false;
				System.out.println();
				System.out.print(s.charAt(i));
			}
			else if(s.charAt(i)=='+'||s.charAt(i)=='-') {
				num = true;
				System.out.print((s.charAt(i)=='+')?" tighten ":" loosen ");
			}
			else System.out.print(s.charAt(i));
		}
	}
}