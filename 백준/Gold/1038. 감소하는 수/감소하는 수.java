import java.io.*;
import java.util.*;

public class Main {
	static PriorityQueue<Long> q = new PriorityQueue<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());

		for (int i = 1; i < 10; i++) {
			dfs(i, i);
		}

		long ans = 0;
		for (int i = 0; i < N; i++) {
			if (q.isEmpty()) {
				ans = -1;
				break;
			}
			ans = q.poll();
		}

		System.out.println(ans);
	}

	static void dfs(long num, int last) {
		q.add(num);
		for (int next = last - 1; next >= 0; next--) {
			dfs(num * 10 + next, next);
		}

	}
}
