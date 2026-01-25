import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int n;
    static int m;
    static int[] startPos;
    static int[][] field;

    static final int[] dr = {-1, 0, 1, 0};  // 북동남서
    static final int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputArr;

        inputArr = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt).toArray();

        n = inputArr[0];
        m = inputArr[1];
        field = new int[n][m];

        inputArr = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt).toArray();

        startPos = inputArr;

        for (int r = 0; r < n; r++) {
            field[r] = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        }
    }

    static int solve() {
        int result = 0;

        int curR = startPos[0];
        int curC = startPos[1];
        int curD = startPos[2];

        while (true) {
            // 1. 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
            if (field[curR][curC] == 0) {
                result++;
                field[curR][curC] = -1;
            }

            // 2. 현재 칸의 주변 4칸 중
            int notCleanedDir = -1;
            for (int i = 1; i < 5; i++) {
                int dir = (curD - i + 4) % 4;  // 바라보는 방향부터 반시계 방향으로 주변을 탐색
                int nextR = curR + dr[dir];
                int nextC = curC + dc[dir];
                if (isValid(nextR, nextC) && field[nextR][nextC] == 0) {
                    notCleanedDir = dir;
                    break;
                }
            }

            if (notCleanedDir == -1) {
                // 청소되지 않은 빈 칸이 없는 경우
                int nextR = curR - dr[curD];
                int nextC = curC - dc[curD];

                if (isValid(nextR, nextC) && field[nextR][nextC] != 1) {
                    // 바라보는 방향을 유지한 채로 한칸 후진
                    curR = nextR;
                    curC = nextC;
                } else {
                    // 후진할 수 없다면 작동 중지
                    break;
                }
            } else {
                // 청소되지 않은 빈 칸이 있는 경우 해당 칸으로 전진
                // 반시계 방향으로의 탐색은 이미 앞에서 마쳤으므로 전진만 하면 됨
                curR = curR + dr[notCleanedDir];
                curC = curC + dc[notCleanedDir];
                curD = notCleanedDir;
            }
        }

        return result;
    }

    static boolean isValid(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < m;
    }
}
