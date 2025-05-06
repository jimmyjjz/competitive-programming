import java.util.*;
import java.io.*;
public class champ {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
	List<String> matches = new ArrayList<String>();
	List<String> pointa = new ArrayList<String>();
	List<String> pointb = new ArrayList<String>();
	int fav = readInt();
	int games = readInt();
	int[] teams = new int[4];
	for(int i = 0; i<4; i++) {
		teams[i] = 0;
	}
	StringTokenizer split = new StringTokenizer("1,2 1,3 1,4 2,3 2,4 3,4"," ");
	for(int i = 0; i<6; i++) {
		matches.add(split.nextToken());
	}
	int A,B,ScoreA,ScoreB;
	for(int i = 0; i<games; i++) {
		A = readInt();
		B = readInt();
		ScoreA = readInt();
		ScoreB = readInt();
		if(matches.indexOf(A+","+B) != -1) {
			matches.remove(matches.indexOf(A+","+B));
		}
		else {
			matches.remove(matches.indexOf(B+","+A));
		}
		if(ScoreA > ScoreB) {
			teams[A-1] = teams[A-1]+3;
		}
		else if(ScoreA < ScoreB) {
			teams[B-1] = teams[B-1]+3;
		}
		else {
			teams[A-1] = teams[A-1]+1;
			teams[B-1] = teams[B-1]+1;
		}
	}
	pointb.add(teams[0]+","+teams[1]+","+teams[2]+","+teams[3]);
	for(int i = 0; i<matches.size(); i++) {
		StringTokenizer cut = new StringTokenizer(matches.get(i),",");
		A = Integer.parseInt(cut.nextToken());
		B = Integer.parseInt(cut.nextToken());
		if(i%2==0) {
			pointa.clear();
			for(int j = 0; j<pointb.size(); j++) {
				StringTokenizer chop = new StringTokenizer(pointb.get(j),",");
				int[] end = new int[4];
				for(int k = 0; k<4; k++) {
					end[k] = Integer.parseInt(chop.nextToken());
				}
				int[] clone = end.clone();
				int[] cloneb = end.clone();
				cloneb[A-1] = cloneb[A-1]+1;
				cloneb[B-1] = cloneb[B-1]+1;
				pointa.add(cloneb[0] + "," + cloneb[1] + "," + cloneb[2] + "," + cloneb[3]);
				end[A-1] = end[A-1]+3;
				pointa.add(end[0] + "," + end[1] + "," + end[2] + "," + end[3]);
				clone[B-1] = clone[B-1]+3;
				pointa.add(clone[0] + "," + clone[1] + "," + clone[2] + "," + clone[3]);
			}
		}
		else {
			pointb.clear();
			for(int j = 0; j<pointa.size(); j++) {
				StringTokenizer chop = new StringTokenizer(pointa.get(j),",");
				int[] end = new int[4];
				for(int k = 0; k<4; k++) {
					end[k] = Integer.parseInt(chop.nextToken());
				}
				int[] clone = end.clone();
				int[] cloneb = end.clone();
				cloneb[A-1] = cloneb[A-1]+1;
				cloneb[B-1] = cloneb[B-1]+1;
				pointb.add(cloneb[0] + "," + cloneb[1] + "," + cloneb[2] + "," + cloneb[3]);
				end[A-1] = end[A-1]+3;
				pointb.add(end[0] + "," + end[1] + "," + end[2] + "," + end[3]);
				clone[B-1] = clone[B-1]+3;
				pointb.add(clone[0] + "," + clone[1] + "," + clone[2] + "," + clone[3]);
			}
		}
	}
	int keep = 0;
	int count = 0;
	int determine = 0;
	int index = 0;
	boolean result = true;
	if(matches.size()%2==0) {
		for(int i = 0; i<pointb.size(); i++){
			determine = 0;
			result = true;
		StringTokenizer slice = new StringTokenizer(pointb.get(i),",");
		int[] end = new int[4];
		for(int j = 0; j<4; j++) {
			keep = Integer.parseInt(slice.nextToken());
			end[j] = keep;
			if(keep > determine) {
				determine = keep;
				index = j;
			}
		}
		for(int j = 0; j<4; j++) {
			if(index == j) {
				continue;
			}
			if(end[j] == determine) {
				result = false;
			}
		}
		if(index != fav-1) {
			result = false;
		}
		if(result) {
			count++;
		}
		}
	}
	else {
		for(int i = 0; i<pointa.size(); i++){
			determine = 0;
			result = true;
		StringTokenizer slice = new StringTokenizer(pointa.get(i),",");
		int[] end = new int[4];
		for(int j = 0; j<4; j++) {
			keep = Integer.parseInt(slice.nextToken());
			end[j] = keep;
			if(keep > determine) {
				determine = keep;
				index = j;
			}
		}
		for(int j = 0; j<4; j++) {
			if(index == j) {
				continue;
			}
			if(end[j] == determine) {
				result = false;
			}
		}
		if(index != fav-1) {
			result = false;
		}
		if(result) {
			count++;
		}
		}
	}
	System.out.println(count);
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