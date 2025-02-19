import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		int t, n, m, a, b, cnt, result;
		Scanner sc = new Scanner(System.in);
		HashMap<Integer, ArrayList<Integer>> bigger;
		HashMap<Integer, ArrayList<Integer>> smaller;
		ArrayDeque<Integer> q;
		HashSet<Integer> visited;
		t = sc.nextInt();

		for (int tc = 1; tc <= t; tc++) {
			bigger = new HashMap<>();
			smaller = new HashMap<>();
			n = sc.nextInt();
			m = sc.nextInt();
			for (int i = 0; i < m; i++) {
				a = sc.nextInt();
				b = sc.nextInt();

				if (!bigger.containsKey(a)) {
					bigger.put(a, new ArrayList<>());
				}
				bigger.get(a).add(b);

				if (!smaller.containsKey(b)) {
					smaller.put(b, new ArrayList<>());
				}
				smaller.get(b).add(a);
			}
			
			result = 0;
			for (int st = 1; st <= n; st++) {
				cnt = 0;
				q = new ArrayDeque<>();
				visited = new HashSet<>();
				q.add(st);
				while (q.size() > 0) {
					a = q.poll();
					if (visited.contains(a)) {
						continue;
					}
					visited.add(a);
					cnt++;
					if (bigger.containsKey(a)) {
						q.addAll(bigger.get(a));
					}
				}

				q = new ArrayDeque<>();
				visited = new HashSet<>();
				q.add(st);
				while (q.size() > 0) {
					a = q.poll();
					if (visited.contains(a)) {
						continue;
					}
					visited.add(a);
					cnt++;
					if (smaller.containsKey(a)) {
						q.addAll(smaller.get(a));
					}
				}
				if (cnt==n+1) {
					result++;
				}
			}
			System.out.printf("#%d %d\n", tc, result);
		}
		sc.close();
	}
}