import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().strip());
        br.close();

        System.out.println(find(N));
    }

    static int find(int N) {
        int[] dp = Arrays.stream(new int[N + 1]).map(i -> Integer.MAX_VALUE).toArray();
        dp[1] = 0;

        for (int i = 1; i < N; i++) {
            // 1을 더한다
            dp[i + 1] = Math.min(dp[i] + 1, dp[i + 1]);
            // 2를 곱한다
            if (i * 2 <= N) {
                dp[i * 2] = Math.min(dp[i] + 1, dp[i * 2]);
            }
            if (i * 3 <= N) {
                dp[i * 3] = Math.min(dp[i] + 1, dp[i * 3]);
            }
        }

        return dp[N];
    }

}
