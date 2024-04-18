import java.util.*;
import java.io.*;
public class ThatTeacher {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		System.out.println(C-(N*M));
	}
}