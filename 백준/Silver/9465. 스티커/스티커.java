import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static BufferedReader br;
    static StringTokenizer st;

    static int[][] input() throws IOException {
        N = Integer.parseInt(br.readLine().strip());
        int[][] result = new int[2][N];
        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                result[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        return result;
    }

    static int simulate(int[][] dp) {
        if (N > 1) {
            dp[0][1] += dp[1][0];
            dp[1][1] += dp[0][0];
        }
        for (int col = 2; col < N; col++) {
            for (int i = 0; i < 2; i++) {
                dp[i][col] += Math.max(dp[1 - i][col - 2], dp[1 - i][col - 1]);
            }
        }
        return Math.max(dp[0][N - 1], dp[1][N - 1]);
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().strip());
        for (int tc = 0; tc < T; tc++) {
            int[][] inp = input();
            System.out.println(simulate(inp));
        }
    }
}