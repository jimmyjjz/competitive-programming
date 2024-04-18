import java.util.*;
import java.io.*;
public class ThatCircle {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] in = br.readLine().split(" ");
		double L = Double.parseDouble(in[0]),H = Double.parseDouble(in[1]),W = Double.parseDouble(in[2]);
		double D = Double.parseDouble(br.readLine());
		System.out.println((L*H*W)-((3.14*Math.pow(D/2.00,2.00))*H));
		
	}
}