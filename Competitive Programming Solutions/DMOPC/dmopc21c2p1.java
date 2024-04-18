import java.util.*;
public class Bosses {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextInt(), H = sc.nextInt(), P = sc.nextInt();
		Stack<Long> boss = new Stack<Long>();
		long total = 0;
		for(int i = 0; i<N; i++) {
			long save = sc.nextInt();
			boss.add(save);
			total += save;
		}
		total = total*P;
		long current = 0;
		long old = total;
		Collections.sort(boss);
		Collections.reverse(boss);
		while(!boss.isEmpty()) {
			while(current<boss.peek()) {
				if(current >= boss.peek()) {
					break;
				}
				current++;
				total-=boss.size()*P;
				total+=H;
				if(old < total) {
					System.out.println(old);
					return;
				}
				else {
					old = total;
				}
			}
			while(!boss.isEmpty() && boss.peek() <= current) {
				boss.pop();
			}
		}
		System.out.println(Math.min(old,total));
	}

}