import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Thing {
	int weight;
	int value;

	public Thing(int weight, int value) {
		this.weight = weight;
		this.value = value;
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		int N, TARGET;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		TARGET = Integer.parseInt(st.nextToken());

		Thing[] things = new Thing[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			things[i] = new Thing(w, v);
		}
		br.close();

		// N번째까지 고려했을 때, 가방의 무게별 최대 가치
		int[][] dp = new int[N][TARGET + 1];
		for (int weight = things[0].weight; weight <= TARGET; weight++) {
			dp[0][weight] = things[0].value;
		}

		for (int idx = 1; idx < N; idx++) {
			for (int weight = 0; weight < Math.min(things[idx].weight, TARGET); weight++) {
				dp[idx][weight] = dp[idx - 1][weight];
			}
			for (int weight = things[idx].weight; weight <= TARGET; weight++) {
				dp[idx][weight] = Math.max(dp[idx - 1][weight],
						things[idx].value + dp[idx - 1][weight - things[idx].weight]);
			}
		}

		int result = 0;
		for (int weight = 0; weight <= TARGET; weight++) {
			result = Math.max(result, dp[N - 1][weight]);
		}
		System.out.println(result);
	}
}