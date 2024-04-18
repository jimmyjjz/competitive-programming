import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
public class canva {

	public static void main(String[] args) {
		List<String> dots = new ArrayList<String>();
		List<Integer> x = new ArrayList<Integer>();
		List<Integer> y = new ArrayList<Integer>();
		Scanner sc = new Scanner(System.in);
		String save = "";
		int num = sc.nextInt();
		sc.nextLine();
		for(int i = 0; i<num; i++) {
			dots.add(sc.nextLine());
		}
		for(int j = 0; j<dots.size(); j++) {
			if(save != "") {
			y.add(Integer.parseInt(save));
			save = "";
			}
			for(int k = 0; k<dots.get(j).length(); k++) {
				if(dots.get(j).charAt(k) == ',') {
					x.add(Integer.parseInt(save));
					save = "";
				}
				else {
				save = save+dots.get(j).charAt(k);
				}
			}
		}
		y.add(Integer.parseInt(save));
		
		Collections.sort(x);
		Collections.sort(y);
		System.out.println((x.get(0)-1)+","+(y.get(0)-1));
		System.out.println((x.get(x.size()-1)+1)+","+(y.get(y.size()-1)+1));
	}

}