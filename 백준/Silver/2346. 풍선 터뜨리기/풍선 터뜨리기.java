import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		ArrayDeque<int[]> nums = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			nums.offer(new int[] { i + 1, Integer.parseInt(st.nextToken()) });
		}

		StringBuilder result = new StringBuilder();
		int cnt;
		int[] current;
		while (!nums.isEmpty()) {
			current = nums.poll();
			result.append(current[0]).append(" ");
			cnt = (current[1] > 0) ? 1 : 0;
			while (!nums.isEmpty() && cnt < Math.abs(current[1])) {
				if (current[1] > 0) {
					nums.offer(nums.poll());
				} else {
					nums.offerFirst(nums.pollLast());
				}
				cnt++;
			}
		}
		System.out.print(result);
		br.close();
	}
}