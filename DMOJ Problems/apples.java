import java.util.*;
public class Apple {
	static Scanner sc = new Scanner(System.in);
	public static int N = sc.nextInt();
	public static int[] board = new int[N];
	public static int count = 0;
	static void recur(int spot, int num, int tar){
	    if(tar == 0 && board[0] != N){
	    	String s = Arrays.toString(board);
	    	s=s.replaceAll(", "+N, "");
	    	s=s.replaceAll(", ", "+");
			s=s.replaceAll("\\]", "");
			s=s.replaceAll("\\[", N+"=");
	        System.out.println(s);
	        count++;
	        return;
	    }
	    if(!(tar >= 0)){//stop
	        return;
	    }
	    if(spot == 0){
	    	for(int i = 1; i <= num; i++){
		    	board[spot]=i;
		        recur(spot+1,num,tar-i);
		    }
	    }
	    else{
	    	for(int i = board[spot-1]; i <= num; i++){
		    	board[spot]=i;
		        recur(spot+1,num,tar-i);
		    }
	    }
	}
	public static void main(String[] args){
		recur(0, N, N);
		System.out.println("total="+count);
	}
}