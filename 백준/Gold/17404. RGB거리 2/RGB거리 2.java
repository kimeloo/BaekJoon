import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int n;
    static int[][] cost;

    static final int COLORS = 3;
    static final int MAX = 1000 * 1000 * 2;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        cost = new int[n][COLORS];
        for (int i = 0; i < n; i++) {
            cost[i] = Arrays.stream(br.readLine().trim().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        }
    }

    static int solve() {
        int ans = MAX;

        for (int startColor = 0; startColor < COLORS; startColor++) {
            int[][] dp = new int[n][COLORS];    // x=각 집, y=각 색상

            // 첫번째 집 색상 지정
            dp[0][startColor] = cost[0][startColor];
            dp[0][(startColor + 1) % 3] = MAX;
            dp[0][(startColor + 2) % 3] = MAX;

            for (int h = 1; h < n; h++) {   // 각 집에 대해
                for (int c = 0; c < COLORS; c++) {  // 각 색상에 대해
                    dp[h][c] = Math.min(dp[h - 1][(c + 1) % 3], dp[h - 1][(c + 2) % 3])
                        + cost[h][c];
                }
            }

            ans = Math.min(ans,
                Math.min(dp[n - 1][(startColor + 1) % 3], dp[n - 1][(startColor + 2) % 3]));
        }

        return ans;
    }
}
