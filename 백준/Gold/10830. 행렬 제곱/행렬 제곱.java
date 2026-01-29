import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int n;
    static long exponent;
    static int[][] matrix;

    static final int MOD = 1000;

    public static void main(String[] args) throws IOException {
        input();
        int[][] ans = solve();
        output(ans);
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArr = br.readLine().trim().split("\\s+");
        n = Integer.parseInt(inputArr[0]);
        exponent = Long.parseLong(inputArr[1]);

        matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            matrix[i] = Arrays.stream(br.readLine().trim().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        }
    }

    static int[][] solve() {
        int[][] base = new int[n][n];
        int[][] ans = getUnitMatrix(n);

        for (int i = 0; i < n; i++) {
            System.arraycopy(matrix[i], 0, base[i], 0, n);
        }

        while (exponent > 0) {
            if (exponent % 2 == 1) {
                ans = multiply(ans, base, n);
            }
            base = multiply(base, base, n);
            exponent /= 2;
        }

        return ans;
    }

    static int[][] getUnitMatrix(int size) {
        int[][] result = new int[size][size];
        for (int i = 0; i < size; i++) {
            result[i][i] = 1;
        }
        return result;
    }

    static int[][] multiply(int[][] matrix1, int[][] matrix2, int size) {
        int[][] result = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    result[i][j] = (int) (result[i][j]
                        + ((long) matrix1[i][k] * matrix2[k][j]) % MOD) % MOD;
                }
            }
        }
        return result;
    }

    static void output(int[][] ans) {
        StringBuilder sb = new StringBuilder();
        for (int[] arr : ans) {
            for (int x : arr) {
                sb.append(x).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
