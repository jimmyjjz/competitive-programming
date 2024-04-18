import java.io.*;
public class TheOddNumber{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()), num = Integer.parseInt(br.readLine());
		while(N--!=1)num^=Integer.parseInt(br.readLine());
		System.out.println(num);
	}
}