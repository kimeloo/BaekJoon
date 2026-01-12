import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[] matrix;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        // matrix[i]는 i번째 행렬의 행 수 (그리고 i-1번째 행렬의 열 수)
        matrix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int r = Integer.parseInt(input[0]);
            int c = Integer.parseInt(input[1]);
            matrix[i] = r;
            matrix[i + 1] = c;
        }
    }

    static void solve() {
        // dp[i][j]: i번째부터 j번째 행렬까지 곱하는 최소 비용
        int[][] dp = new int[n + 1][n + 1];

        // 구간 길이를 늘려가며 DP 테이블 채우기
        // len=1일 때는 자기 자신이므로 비용 0 (초기값 그대로)
        for (int len = 2; len <= n; len++) {  // 구간 길이 (2부터 n까지)
            for (int i = 1; i <= n - len + 1; i++) {  // 시작 위치
                int j = i + len - 1;  // 끝 위치
                dp[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {   // k는 i부터 j-1까지
                    dp[i][j] = Math.min(dp[i][j], dp[i][k]+dp[k+1][j]+matrix[i-1]*matrix[k]*matrix[j]);
                // 각 k에 대해:
                //   - 왼쪽 구간 [i, k]의 비용: dp[i][k]
                //   - 오른쪽 구간 [k+1, j]의 비용: dp[k+1][j]
                //   - 두 구간을 합치는 비용: matrix[i-1] × matrix[k] × matrix[j]
                //     (왼쪽 결과 크기: matrix[i-1]×matrix[k], 오른쪽: matrix[k]×matrix[j])
                }
            }
        }

        System.out.println(dp[1][n]);
    }
}
