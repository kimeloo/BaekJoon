import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N, M;
    static char[][] lines;
    static int[][] lcsField;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        lines = new char[2][];
        lines[0] = br.readLine().toCharArray();
        lines[1] = br.readLine().toCharArray();
        N = lines[0].length;
        M = lines[1].length;
        lcsField = new int[N + 1][M + 1];
    }

    static int simulate() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (lines[0][i] == lines[1][j]) {
                    lcsField[i + 1][j + 1] = lcsField[i][j] + 1;
                } else {
                    lcsField[i + 1][j + 1] = Math.max(lcsField[i + 1][j], lcsField[i][j + 1]);
                }
            }
        }
//        for (int[] arr : lcsField) {
//            System.out.println(Arrays.toString(arr));
//        }
        return lcsField[N][M];
    }

    static String backtrack(int cnt) {
        StringBuilder sb = new StringBuilder();
        int[] rct = {N + 1, M + 1, cnt};
        for (int left = cnt; left > 0; left--) {
            sb.append(findNext(rct));
        }
        return sb.reverse().toString();
    }

    static char findNext(int[] rct) {
        int r = rct[0] - 1;
        int c = rct[1] - 1;
        int t = rct[2];

        while (lcsField[r][c] == t) {
            r--;
        }
        ++r;
        while (lcsField[r][c] == t) {
            c--;
        }

        rct[0] = r;
        rct[1] = ++c;
        rct[2] = --t;

        return lines[0][r - 1];
    }

    public static void main(String[] args) throws IOException {
        input();
        int result = simulate();
        System.out.println(result);
        if (result > 0) {
            System.out.println(backtrack(result));
        }
    }
}
