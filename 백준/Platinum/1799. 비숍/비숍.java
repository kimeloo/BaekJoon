import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main {

    static int cnt;
    static int ans;
    static boolean[][] board;
    static boolean[][] visited;


    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.println(ans);
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        board = new boolean[size][size];
        visited = new boolean[2][2 * board.length - 1];

        for (int i = 0; i < size; i++) {
            int[] inputArr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < size; j++) {
                board[i][j] = inputArr[j] == 0;
            }
        }
    }

    static void solve() {

        Deque<int[]> white = new ArrayDeque<>();
        Deque<int[]> black = new ArrayDeque<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j]) {
                    continue;
                }
                if ((i + j) % 2 == 0) {
                    white.offer(new int[]{i, j});
                } else {
                    black.offer(new int[]{i, j});
                }
            }
        }

        ans = Integer.MIN_VALUE;
        cnt = 0;
        backtrack(white);
        int whiteAns = ans;

        ans = Integer.MIN_VALUE;
        cnt = 0;
        backtrack(black);
        ans += whiteAns;
    }

    static void backtrack(Deque<int[]> queue) {
        if (queue.isEmpty()) {
            ans = Integer.max(cnt, ans);
            return;
        }
        int[] next = queue.pollLast();

        // 비숍을 두지 않고 다음으로 넘어감
        backtrack(queue);

        if (checkValid(next[0], next[1])) {
            // 비숍을 두고 다음으로 넘어감
            reverseValid(next[0], next[1]);
            cnt++;
            backtrack(queue);
            reverseValid(next[0], next[1]);
            cnt--;
        }
        queue.offerLast(next);
    }

    static boolean checkValid(int x, int y) {
        return !(visited[0][x + y] || visited[1][x - y + board.length - 1]);
    }

    static void reverseValid(int x, int y) {
        visited[0][x + y] = !visited[0][x + y];
        visited[1][x - y + board.length - 1] = !visited[1][x - y + board.length - 1];
    }
}
