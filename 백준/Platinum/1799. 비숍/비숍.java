import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    static boolean[][] board;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        input();
        int result = solve();
        System.out.println(result);
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        board = new boolean[size][size];
        visited = new boolean[2][2 * size - 1];

        for (int i = 0; i < size; i++) {
            int[] inputArr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < size; j++) {
                board[i][j] = inputArr[j] == 1;
            }
        }
    }

    static int solve() {
        List<int[]> whiteCandidates = collectCandidates(true);
        List<int[]> blackCandidates = collectCandidates(false);

        int whiteMax = findMaxBishops(whiteCandidates, 0, 0);
        int blackMax = findMaxBishops(blackCandidates, 0, 0);

        return whiteMax + blackMax;
    }

    static List<int[]> collectCandidates(boolean isWhite) {
        List<int[]> candidates = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (!board[i][j]) {
                    continue;
                }
                boolean isWhiteSquare = (i + j) % 2 == 0;
                if (isWhiteSquare == isWhite) {
                    candidates.add(new int[]{i, j});
                }
            }
        }
        return candidates;
    }

    static int findMaxBishops(List<int[]> candidates, int index, int currentCount) {
        if (index == candidates.size()) {
            return currentCount;
        }

        int[] position = candidates.get(index);
        int x = position[0];
        int y = position[1];

        // 비숍을 두지 않고 다음으로 넘어감
        int maxWithoutBishop = findMaxBishops(candidates, index + 1, currentCount);

        // 비숍을 둘 수 있으면 두고 다음으로 넘어감
        int maxWithBishop = maxWithoutBishop;
        if (canPlaceBishop(x, y)) {
            toggleDiagonal(x, y);
            maxWithBishop = findMaxBishops(candidates, index + 1, currentCount + 1);
            toggleDiagonal(x, y);
        }

        return Math.max(maxWithoutBishop, maxWithBishop);
    }

    static boolean canPlaceBishop(int x, int y) {
        return !(visited[0][x + y] || visited[1][x - y + board.length - 1]);
    }

    static void toggleDiagonal(int x, int y) {
        visited[0][x + y] = !visited[0][x + y];
        visited[1][x - y + board.length - 1] = !visited[1][x - y + board.length - 1];
    }
}
