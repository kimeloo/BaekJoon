import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static final int DIV = 1000000007;

    static int n;
    static int target;
    static int[][] base;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputArr = Arrays.stream(br.readLine().trim().split(" "))
            .mapToInt(Integer::parseInt).toArray();
        n = inputArr[0];
        int m = inputArr[1];

        base = new int[n][n];
        for (int i = 0; i < m; i++) {
            inputArr = Arrays.stream(br.readLine().trim().split(" "))
                .mapToInt(Integer::parseInt).toArray();
            int u = inputArr[0] - 1;
            int v = inputArr[1] - 1;
            base[u][v] = 1;
            base[v][u] = 1;
        }

        target = Integer.parseInt(br.readLine().trim());
    }

    static int solve() {
        int[] result = new int[n];
        result[0] = 1;

        while (target > 0) {
            if (target % 2 == 1) {
                result = multiply(base, result);
            }
            base = multiply(base, base);
            target /= 2;
        }
        return result[0];
    }

    static int[] multiply(int[][] arr1, int[] arr2) {
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i] = (int) (((long) arr1[i][j] * arr2[j] + result[i]) % DIV);
            }
        }

        return result;
    }

    static int[][] multiply(int[][] arr1, int[][] arr2) {
        int[][] result = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    result[i][j] = (int) (((long) arr1[i][k] * arr2[k][j] + result[i][j]) % DIV);
                }
            }
        }

        return result;
    }
}
