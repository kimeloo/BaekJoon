import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int n;
    static int[] arr;
    static int[][] query;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().trim().split(" "))
            .mapToInt(Integer::parseInt).toArray();
        dp = new int[n][n];

        int queries = Integer.parseInt(br.readLine().trim());
        query = new int[queries][2];
        for (int i = 0; i < queries; i++) {
            query[i] = Arrays.stream(br.readLine().trim().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        }
    }

    static void solve() {
        StringBuilder output = new StringBuilder();
        for (int[] q : query) {
            output.append(isPalindrome(q[0] - 1, q[1] - 1) ? 1 : 0).append("\n");
        }
        System.out.println(output);
    }

    static boolean isPalindrome(int start, int end) {
        if (dp[start][end] == 0) {  // 계산된 값이 없는 경우
            if (start == end) {     // 자기 자신은 팰린드롬
                dp[start][end] = 1;
            } else if (end - start == 1) {      // 범위가 짝수개인 경우
                dp[start][end] = arr[end] == arr[start] ? 1 : -1;
            } else {                // 범위가 줄어들 수 있는 경우
                dp[start][end] =
                    (arr[start] == arr[end]) && isPalindrome(start + 1, end - 1) ? 1 : -1;
            }
        }
        return dp[start][end] == 1;     // 계산된 값 사용
    }
}
