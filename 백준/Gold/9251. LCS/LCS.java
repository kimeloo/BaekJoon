import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[][] lines;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        lines = new char[2][];
        lines[0] = br.readLine().toCharArray();
        lines[1] = br.readLine().toCharArray();
    }

    static int simulate() {
        int N = lines[0].length;
        int M = lines[1].length;
        int[][] lcsField = new int[N + 1][M + 1];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (lines[0][i] == lines[1][j]) {
                    lcsField[i + 1][j + 1] = lcsField[i][j] + 1;
                } else {
                    lcsField[i + 1][j + 1] = Math.max(lcsField[i + 1][j], lcsField[i][j + 1]);
                }
            }
        }

        return lcsField[N][M];
    }

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(simulate());
    }
}
