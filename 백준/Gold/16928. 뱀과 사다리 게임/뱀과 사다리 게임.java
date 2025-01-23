import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int n, m, current, next, cnt, cntNext;
		int[] map;
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		HashSet<Integer> visited = new HashSet<>();
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[101];
		for (int i = 0; i < (n + m); i++) {
			current = sc.nextInt();
			next = sc.nextInt();
			map[current] = next;
		}
		
		cnt = 0;
		cntNext = 1;
		queue.offer(cntNext);
		while (queue.size() > 0) {
			cntNext = queue.poll();
			if (visited.contains(cntNext)) {
				continue;
			} else {visited.add(cntNext);}
			cnt = cntNext / 1000;
			current = cntNext % 1000;
			if (current==100) { break; }
			
			cnt++;
			for (int i = 1; i <= 6; i++) {
				next = current + i;
				if (next>100) {
					continue;
				}
				if (map[next] != 0) {
					next = map[next];
				}
				cntNext = cnt * 1000 + next;
				queue.offer(cntNext);
			}
		}
		System.out.println(cnt);
		sc.close();
	}
}
