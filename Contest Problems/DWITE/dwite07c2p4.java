import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
public class stacbalance {
	public static boolean check(Stack a, String b) {
		String save = "";
		for(int i = 0; i<a.size(); i++){
			save = save+a.get(i);
		}
		if(save.equals(b)) {
			return true;
		}
		else {
			return false;
		}
	}
	public static Character closedbracket(Character bracket) {
		if(bracket == ')') {
			return '(';
		}
		if(bracket == '}') {
			return '{';
		}
		if(bracket == ']') {
			return '[';
		}
		return ' ';
	}
	public static void main(String[] args) {
		Stack<Character> brackets = new Stack<Character>();
		List<String> all = new ArrayList<String>();
		Scanner sc = new Scanner(System.in);
		for(int j = 0; j<5; j++) {
		all.add(sc.nextLine());
		}
		for(int k = 0; k<all.size(); k++) {
			String input = all.get(k);
		for(int i = 0; i<input.length(); i++) {
			if(input.charAt(i) == '(' || input.charAt(i) == '[' || input.charAt(i) == '{') {
			brackets.add(input.charAt(i));
		}
			if(brackets.empty()) {
			}
			else {
		if(input.charAt(i) == ')' || input.charAt(i) == ']' || input.charAt(i) == '}') {
			if(brackets.peek() == closedbracket(input.charAt(i))) {
				brackets.pop();
			}
			else {
				brackets.add(input.charAt(i));
			}
		}
		}
		}
		if(brackets.empty()) {
			System.out.println("balanced");
		}
		else {
			brackets.clear();
		System.out.println("not balanced");
		}
		}
	}
}