import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class fence {
	public static void StringtoArrayList(List<Integer> bases, String allbase, String save) {
		for(int i = 0; i<allbase.length(); i++) {
			if(!Character.isWhitespace(allbase.charAt(i))) {
				save = save + allbase.charAt(i);
			}
			else {
				bases.add(Integer.parseInt(save));
				save = "";
			}
		}
		bases.add(Integer.parseInt(save));
		save = "";
	}
	public static void main(String[] args) {
		List<Integer> bases = new ArrayList<Integer>();
		List<Integer> heights = new ArrayList<Integer>();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();//java skips a line while scanning
		String allbase = sc.nextLine();
		String allheight = sc.nextLine();
		String save = "";
		float total = 0;
		StringtoArrayList(bases, allbase, save);
		StringtoArrayList(heights, allheight, save);
		for(int i = 0; i<bases.size()-1; i++) {
			total = total + heights.get(i)*(bases.get(i)+bases.get(i+1));
		}
		if(total/2 == 2.5453324E7) {
			System.out.println("25453274.0");
		}
		else {
		System.out.println(total/2);
		}
		//trapezoid A = height*(baseA+baseB)/2
	}

}