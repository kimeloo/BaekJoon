import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		int n, a, b;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int[] result;
		ArrayList<Integer> next;
		HashMap<Integer, ArrayList<Integer>> tree = new HashMap<>();
		ArrayDeque<Integer> q = new ArrayDeque<>();

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		result = new int[n + 1];
		for (int i = 0; i < n-1; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			if (!tree.containsKey(a)) {
				tree.put(a, new ArrayList<>());
			}
			tree.get(a).add(b);

			if (!tree.containsKey(b)) {
				tree.put(b, new ArrayList<>());
			}
			tree.get(b).add(a);
		}

		q.offer(1);
		result[1] = -1;
		while (q.size() > 0) {
			a = q.poll();
			next = tree.get(a);
			for (int nxt : next) {
				if (result[nxt] != 0) {
					continue;
				}
				result[nxt] = a;
				q.offer(nxt);
			}
		}
		for (int i=2; i<=n; i++) {
			System.out.println(result[i]);
		}

		br.close();
	}
}