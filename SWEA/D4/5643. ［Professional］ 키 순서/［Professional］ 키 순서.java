import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		int t, n, m, a, b, cnt, result;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		HashMap<Integer, ArrayList<Integer>> bigger;
		HashMap<Integer, ArrayList<Integer>> smaller;
		ArrayDeque<Integer> q;
		HashSet<Integer> visited;
		st = new StringTokenizer(br.readLine());
		t = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= t; tc++) {
			bigger = new HashMap<>();
			smaller = new HashMap<>();

			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());

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
			for (int student = 1; student <= n; student++) {
				cnt = 0;
				q = new ArrayDeque<>();
				visited = new HashSet<>();
				q.add(student);
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
				q.add(student);
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
				if (cnt == n + 1) {
					result++;
				}
			}
			System.out.printf("#%d %d\n", tc, result);

		}

		br.close();
	}

}
