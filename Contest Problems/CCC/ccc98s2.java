import java.util.ArrayList;
import java.util.List;

public class Crossword {
	public static void main(String[] args) {
		List<Integer> remember = new ArrayList<Integer>();
		int save = 0;
		String digit = "";
		for(int i = 1000; i<9999; i++) {
			save = 0;
			remember.clear();
		for(int j = 1; j<i/2; j++) {
			if(i % j == 0) {
				if(j < i && i/j < i) {
					if(!remember.contains(i/j) && !remember.contains(j)) {
						save = save + i/j+j;
						remember.add(i/j);
						remember.add(j);
					}
					if(!remember.contains(i/j)) {
						save = save + i/j;
						remember.add(i/j);
					}
					if(!remember.contains(j)) {
						save = save + j;
						remember.add(j);
					}
				}
			}
		}
		save = save+1;
		if(save == i) {
			System.out.print(i);
		}
		}
		System.out.println();
		for(int k = 100; k<999; k++) {
			digit = ""+k;
			save = 0;
			for(int z = 0; z<digit.length(); z++) {
				save = save+Integer.parseInt(""+digit.charAt(z))*Integer.parseInt(""+digit.charAt(z))*Integer.parseInt(""+digit.charAt(z));
			}
			if(k == save) {
				System.out.print(k+" ");
			}
		}
	}

}