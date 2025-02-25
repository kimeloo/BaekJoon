import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] triangle, dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		triangle = new int[N][];
		dp = new int[N][];
		for (int i = 0; i < N; i++) {
			triangle[i] = new int[i + 1];
			dp[i] = new int[i + 1];
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j <= i; j++) {
				triangle[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dp[0][0] = triangle[0][0];

		for (int r = 1; r < N; r++) {
			for (int c = 0; c <= r; c++) {
				dp[r][c] = Math.max((c > 0) ? dp[r - 1][c - 1] : 0, (c < r) ? dp[r - 1][c] : 0) + triangle[r][c];
			}
		}

		int result = Arrays.stream(dp[N-1]).max().getAsInt();
		System.out.println(result);

		br.close();
	}
}