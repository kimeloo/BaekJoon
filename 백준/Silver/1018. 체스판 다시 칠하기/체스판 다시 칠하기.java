import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N, M, ans;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ans = Integer.MAX_VALUE;

        boolean[][] field = new boolean[N][M];
        boolean[][] filter = new boolean[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                filter[i][j] = i % 2 == j % 2;
            }
        }

        for (int r = 0; r < N; r++) {
            char[] input = br.readLine().trim().toCharArray();
            for (int c = 0; c < M; c++) {
                field[r][c] = input[c] == 'W';
            }
        }

        for (int r = 0; r <= N - 8; r++) {
            for (int c = 0; c <= M - 8; c++) {
                int w = 0;
                int b = 0;
                for (int row = 0; row < 8; row++) {
                    for (int col = 0; col < 8; col++) {
                        if (field[r + row][c + col] == filter[row][col]) {
                            b++;
                        } else {
                            w++;
                        }
                    }
                }
                ans = Math.min(ans, Math.min(w, b));
            }
        }
        System.out.println(ans);
    }
}
