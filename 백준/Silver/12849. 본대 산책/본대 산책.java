import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final int DIV = 1000000007;
    static int target;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        target = Integer.parseInt(br.readLine().trim());
    }

    static int solve() {
        int[] result = {1, 0, 0, 0, 0, 0, 0, 0};
        int[][] base = {
            // 정보과학관 | 전산관 | 미래관 | 신양관 | 진리관 | 한경직기념관 | 학생회관 | 형남공학관
            {0, 1, 1, 0, 0, 0, 0, 0},   // 정보과학관
            {1, 0, 1, 1, 0, 0, 0, 0},   // 전산관
            {1, 1, 0, 1, 0, 1, 0, 0},   // 미래관
            {0, 1, 1, 0, 1, 1, 0, 0},   // 신양관
            {0, 0, 0, 1, 0, 1, 1, 0},   // 진리관
            {0, 0, 1, 1, 1, 0, 0, 1},   // 한경직기념관
            {0, 0, 0, 0, 1, 0, 0, 1},   // 학생회관
            {0, 0, 0, 0, 0, 1, 1, 0}    // 형남공학관
        };

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
        int[] result = new int[8];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                result[i] = (int) (((long) arr1[i][j] * arr2[j] + result[i]) % DIV);
            }
        }

        return result;
    }

    static int[][] multiply(int[][] arr1, int[][] arr2) {
        int[][] result = new int[8][8];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                for (int k = 0; k < 8; k++) {
                    result[i][j] = (int) (((long) arr1[i][k] * arr2[k][j] + result[i][j]) % DIV);
                }
            }
        }

        return result;
    }
}
