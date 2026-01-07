import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static final int INIT_VALUE = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        int[] arr = input();
        int[][] ans = solve(arr);
        output(ans);
    }

    static int[] input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputStrArr = br.readLine().split(" ");
        br.close();
        return Arrays.stream(inputStrArr).mapToInt(Integer::parseInt).toArray();
    }

    static int[][] solve(int[] arr) {
        int[][][] dp = new int[arr.length][5][5];

        for (int[][] dpArrs : dp) {
            for (int[] dpArr : dpArrs) {
                Arrays.fill(dpArr, INIT_VALUE);
            }
        }

        dp[0][0][0] = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            move(dp, i, arr[i]);

        }

        return dp[arr.length - 1];
    }

    static void move(int[][][] dp, int idx, int nxt) {
        for (int left = 0; left < 5; left++) {
            for (int right = 0; right < 5; right++) {
                int curPower = dp[idx][left][right];
                if (curPower != INIT_VALUE) {
                    int nxtPower = curPower + getPower(left, nxt);
                    dp[idx + 1][nxt][right] = Math.min(nxtPower, dp[idx + 1][nxt][right]);
                    nxtPower = curPower + getPower(right, nxt);
                    dp[idx + 1][left][nxt] = Math.min(nxtPower, dp[idx + 1][left][nxt]);
                }
            }
        }
    }

    static int getPower(int bef, int nxt) {
        if (bef == nxt) {
            return 1;
        }
        if (bef == 0) {
            return 2;
        }
        if ((nxt - bef + 4) % 2 == 1) {
            return 3;
        }
        return 4;
    }

    static void output(int[][] ans) {
        int result = INIT_VALUE;
        for (int[] feet : ans) {
            for (int foot : feet) {
                result = Math.min(result, foot);
            }
        }
        System.out.println(result);
    }
}
