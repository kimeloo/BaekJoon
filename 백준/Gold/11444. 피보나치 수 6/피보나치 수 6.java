import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        long n = input();
        System.out.println(solve(n));
    }

    static long input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return Long.parseLong(br.readLine().trim());
    }

    static int solve(long n) {
        int[][] result = new int[][]{{1, 0}, {1, 0}};
        int[][] base = new int[][]{{1, 1}, {1, 0}};

        while (n > 0) {
            if (n % 2 == 1) {
                result = multiply(result, base);
            }

            base = multiply(base, base);

            n /= 2;
        }
        return result[0][1];
    }

    static int[][] multiply(int[][] arr1, int[][] arr2) {
        int[][] result = new int[2][2];
        result[0][0] = (int)
            (((long) arr1[0][0] * arr2[0][0]) % MOD + ((long) arr1[0][1] * arr2[1][0]) % MOD) % MOD;
        result[0][1] = (int)
            (((long) arr1[0][0] * arr2[0][1]) % MOD + ((long) arr1[0][1] * arr2[1][1]) % MOD) % MOD;
        result[1][0] = (int)
            (((long) arr1[1][0] * arr2[0][0]) % MOD + ((long) arr1[1][1] * arr2[1][0]) % MOD) % MOD;
        result[1][1] = (int)
            (((long) arr1[1][0] * arr2[0][1]) % MOD + ((long) arr1[1][1] * arr2[1][1]) % MOD) % MOD;
        return result;
    }

}
