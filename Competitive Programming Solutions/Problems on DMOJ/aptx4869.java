import java.util.*;
import java.io.*;
public class atom {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		List<String> atoms = new ArrayList<String>();
		Map<String,Integer> amount = new HashMap<String,Integer>();
		Stack<String> process = new Stack<String>();
		Stack<Integer> multi = new Stack<Integer>();
		String s = readLine();
		String save = "";
		String savenum = "";
		int multiply = 1;
		for(int i = 0; i<s.length(); i++) {
			if(Character.isUpperCase(s.charAt(i))) {
				if(save != "") {
					amount.put(save,0);
					process.add(save);
					save = "";
				}
				if(savenum != "") {
					process.add(savenum);
					savenum = "";
				}
				save = save + s.charAt(i);
			}
			else if(Character.isLowerCase(s.charAt(i))) {
				save = save + s.charAt(i);
			}
			else if(Character.isDigit(s.charAt(i))) {
				savenum = savenum+s.charAt(i);
			}
			else if(s.charAt(i) == '(' || s.charAt(i) == ')' ) {
				if(save != "") {
					amount.put(save,0);
					process.add(save);
					save = "";
				}
				if(savenum != "") {
					process.add(savenum);
					savenum = "";
				}
				process.add(s.charAt(i)+"");
			}
		}
		if(save != "") {
			amount.put(save,0);
			process.add(save);
			save = "";
		}
		if(savenum != "") {
			process.add(savenum);
			savenum = "";
		}
		while(!process.empty()) {
			save = process.pop();
			if(Character.isDigit(save.charAt(0))){
				if(process.peek().equals(")")) {
					multi.push(Integer.parseInt(save));
					multiply = multiply*Integer.parseInt(save);
					process.pop();
				}
				else{
					savenum = process.pop();
					amount.put(savenum, amount.get(savenum)+(Integer.parseInt(save)*multiply));
					atoms.add(savenum);
				}
			}
			else if(save.equals("(")) {
				multiply = multiply/multi.pop();
			}
			else {
				amount.put(save, amount.get(save)+1*multiply);
				atoms.add(save);
			}
			
		}
		save = "";
		LinkedHashSet<String> removedupe = new LinkedHashSet<String>(atoms);
		List<String> result = new ArrayList<String>(removedupe);
		Collections.sort(result);
		for(int k = 0; k<result.size(); k++) {
			if(amount.get(result.get(k)) == 1){
				save = save+result.get(k);
			}
			else {
		save = save+result.get(k)+amount.get(result.get(k));
			}
		}
		System.out.println(save);
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