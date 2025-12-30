import java.io.*;

public class Main {

    static int n;
    static int[][] field;
    static long[][] visited;

    public static void main(String[] args) throws IOException {
        input();
        long result = bfs(0, 0);
        System.out.println(result);
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine().trim());
        field = new int[n][n];
        visited = new long[n][n];

        for (int r = 0; r < n; r++) {
            String inpStr = br.readLine().trim();
            for (int c = 0; c < n; c++) {
                field[r][c] = inpStr.charAt(c * 2) - '0';
                visited[r][c] = -1L;
            }
        }

        br.close();
    }

    static long bfs(int r, int c) {
        // 범위 초과 시 종료
        if (r >= n || c >= n) {
            return 0;
        }
        // 목표 지점 도착 시 종료
        if (r == n - 1 && c == n - 1) {
            return 1;
        }
        // 무한재귀 방지용 종료
        if (field[r][c] == 0) {
            return 0;
        }
        // 이미 방문한 경우 종료
        if (visited[r][c] > -1) {
            return visited[r][c];
        }

        long result = 0;
        result += bfs(r + field[r][c], c);
        result += bfs(r, c + field[r][c]);

        visited[r][c] = result;

        return result;
    }
}
