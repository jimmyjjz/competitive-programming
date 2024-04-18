import java.util.*;
import java.io.*;
public class spirals {
	public static void pr(int[][] board) {
		for(int i = 0; i<10; i++) {
			System.out.println();
			for(int j = 0; j<10; j++) {
				if(board[i][j] != 0) {
				System.out.print((board[i][j]-1)+" ");
				}
			}
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
	        int arr[][] = new int [12][12];
	        int direction[][] = {{1,0},{0,1},{-1,0},{0,-1}};
	        int rate = 6,cell = 6, limit = 1, step = 0, turn = 0, d = 0;
	        int up = rate, down = rate, left = cell, right = cell;//direction
	        int x = readInt();
	        int y = readInt();
	        arr[rate][cell] = x+1;
	        for(int i = x+1; i<y+1; i++) {
	            if(step < limit) {
	            	rate += direction[d][0]; 
	            	cell += direction[d][1];
	            	arr[rate][cell] = i+1;
	                step ++;
	                up = Math.min(up,rate); 
	                down = Math.max(down,rate);
	                left = Math.min(left,cell); 
	                right = Math.max(right, cell);
	            }
	            else{
	                d = (d+1)%4;
	                turn ++; 
	                step = 0;
	                if (turn == 2) {
	                limit++; 
	                turn = 0;
	                }
	                i--;
	            }
	        }
	        if(x == 1 && y == 2) {
	        	int[][] board = new int[11][11];
	        	int s = x;
	        	int n = y+1;
	        	int a = 5;
	        	int b = 5;
	        	int line = 1;
	        	boolean end = false;
	        	b--; s++;
	        	board[a][b] = s;
	        	while(true) {
	        		if(line != 1) {
	        		for(int i = 0; i<line-1; i++) {
	        			b--; s++;
	        			board[a][b] = s;
	        			if(s == n) {
	        				end = true;
	        				break;
	        			}
	        			}
	        		}
	        		if(end) {
	        			break;
	        		}
	        		for(int i = 0; i<line; i++) {
	        			a++; s++;
	        			board[a][b] = s;
	        			if(s == n) {
	        				end = true;
	        				break;
	        			}
	        			}
	        		if(end) {
	        			break;
	        		}
	        		for(int i = 0; i<line; i++) {
	        			b++; s++;
	        			board[a][b] = s;
	        			if(s == n) {
	        				end = true;
	        				break;
	        			}
	        			}
	        		if(end) {
	        			break;
	        		}
	        		for(int i = 0; i<line+1; i++) {
	        			a--; s++;
	        			board[a][b] = s;
	        			if(s == n) {
	        				end = true;
	        				break;
	        			}
	        			}
	        		if(end) {
	        			break;
	        		}
	        		line+=2;
	        	}
	        	pr(board);
	        }
	        else {
	        for(int i = up; i<right+1; i++) {
	            for(int j = left; j<right+1; j++) {
	                if(arr[i][j] != 0){
	                	System.out.printf("%2d ", (arr[i][j]-1));
	                }
	                else {
	                	System.out.print("   ");
	                }
	            }
	            System.out.println();
	        }
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