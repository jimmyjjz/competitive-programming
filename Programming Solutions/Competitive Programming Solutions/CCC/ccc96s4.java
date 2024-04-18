import java.util.*;
import java.io.*;
public class WhenInRome {
	public static int RomanToValue(Map<String,Integer> value, String rank, String s) {
		int out = 0;
		for(int i = 0; i<s.length(); i++) {
			out+=value.get(s.charAt(i)+"");
		}
		if(s.length()>1) {
		for(int i = 0; i<s.length()-1; i++) {
		if(rank.indexOf(s.charAt(i))<rank.indexOf(s.charAt(i+1))){
			out-=value.get(s.charAt(i)+"")*2;
		}
		}
		}
		return out;
	}
	public static String ValueToRoman(Map<String,Integer> value, String rank, int val) {
		String out = "";
		if(val%1000!=val) {
			for(int i = 0; i<(val-(val%1000))/1000; i++) {
			out+="M";
			}
			val=val%1000;
		}
		if(val%900!=val) {
			for(int i = 0; i<(val-(val%900))/900; i++) {
			out+="CM";
			}
			val=val%900;
		}
		if(val%500!=val) {
			for(int i = 0; i<(val-(val%500))/500; i++) {
			out+="D";
			}
			val=val%500;
		}
		if(val%400!=val) {
			for(int i = 0; i<(val-(val%400))/400; i++) {
			out+="CD";
			}
			val=val%400;
		}
		if(val%100!=val) {
			for(int i = 0; i<(val-(val%100))/100; i++) {
			out+="C";
			}
			val=val%100;
		}
		if(val%90!=val) {
			for(int i = 0; i<(val-(val%90))/90; i++) {
			out+="XC";
			}
			val=val%90;
		}
		if(val%50!=val) {
			for(int i = 0; i<(val-(val%50))/50; i++) {
			out+="L";
			}
			val=val%50;
		}
		if(val%40!=val) {
			for(int i = 0; i<(val-(val%40))/40; i++) {
			out+="XL";
			}
			val=val%40;
		}
		if(val%10!=val) {
			for(int i = 0; i<(val-(val%10))/10; i++) {
			out+="X";
			}
			val=val%10;
		}
		if(val%9!=val) {
			for(int i = 0; i<(val-(val%9))/9; i++) {
			out+="IX";
			}
			val=val%9;
		}
		if(val%5!=val) {
			for(int i = 0; i<(val-(val%5))/5; i++) {
			out+="V";
			}
			val=val%5;
		}
		if(val%4!=val) {
			for(int i = 0; i<(val-(val%4))/4; i++) {
			out+="IV";
			}
			val=val%4;
		}
		if(val%1!=val) {
			for(int i = 0; i<val; i++) {
			out+="I";
			}
			val=val%1;
		}
		return out;
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		String rank = "IVXLCDM";
		StringTokenizer v = new StringTokenizer("1,5,10,50,100,500,1000",",");
		Map<String,Integer> value = new HashMap<String,Integer>();
		for(int i = 0; i<rank.length(); i++) {
			value.put(rank.charAt(i)+"", Integer.parseInt(v.nextToken()));
		}
		//System.out.println(value);
		int N = readInt();
		for(int i = 0; i<N; i++) {
			StringTokenizer equation = new StringTokenizer(readLine(),"[+=]");
			String a = equation.nextToken(),b = equation.nextToken();
			int val = RomanToValue(value,rank,a)+RomanToValue(value,rank,b);
			if(val>1000) {
				System.out.println(a+"+"+b+"="+"CONCORDIA CUM VERITATE");
				continue;
			}
			System.out.println(a+"+"+b+"="+ValueToRoman(value,rank,val));
		}
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