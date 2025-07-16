import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] field;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().strip());
        field = new int[N][3];

        for (int row = 0; row < N; row++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int col = 0; col < 3; col++) {
                field[row][col] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static int findMax() {
        int[][] dp = new int[N][2];     // {Max(left,mid), Max(mid,right)}
        dp[0][0] = Math.max(field[0][0], field[0][1]);
        dp[0][1] = Math.max(field[0][1], field[0][2]);

        for (int row = 1; row < N; row++) {
            int left = dp[row - 1][0] + field[row][0];
            int mid = Math.max(dp[row - 1][0], dp[row - 1][1]) + field[row][1];
            int right = dp[row - 1][1] + field[row][2];
            dp[row][0] = Math.max(left, mid);
            dp[row][1] = Math.max(mid, right);
        }
        return Math.max(dp[N - 1][0], dp[N - 1][1]);
    }

    static int findMin() {
        int[][] dp = new int[N][2];     // {Min(left,mid), Min(mid,right)}
        dp[0][0] = Math.min(field[0][0], field[0][1]);
        dp[0][1] = Math.min(field[0][1], field[0][2]);

        for (int row = 1; row < N; row++) {
            int left = dp[row - 1][0] + field[row][0];
            int mid = Math.min(dp[row - 1][0], dp[row - 1][1]) + field[row][1];
            int right = dp[row - 1][1] + field[row][2];
            dp[row][0] = Math.min(left, mid);
            dp[row][1] = Math.min(mid, right);
        }
        return Math.min(dp[N - 1][0], dp[N - 1][1]);
    }

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(findMax()+" "+findMin());
    }
}
