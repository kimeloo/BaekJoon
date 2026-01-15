import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    static final int SIZE = 9;
    static final List<Integer> CANDIDATES = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

    static int[][] field;
    static Set<Integer>[][] candidate;  // {행,열,3by3}

    public static void main(String[] args) throws IOException {
        init();
        List<int[]> queue = setCandidate();

        solve(queue, 0);
        print();
    }

    @SuppressWarnings("unchecked")
    static void init() throws IOException {
        field = new int[SIZE][SIZE];
        candidate = new HashSet[3][SIZE];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < SIZE; j++) {
                candidate[i][j] = new HashSet<>(CANDIDATES);
            }
        }

        // 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < SIZE; i++) {
            field[i] = br.readLine().trim().chars().map(c -> c - '0').toArray();
        }
    }

    static List<int[]> setCandidate() {
        List<int[]> queue = new ArrayList<>();

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (field[i][j] == 0) {     // 빈칸이면
                    queue.add(new int[]{i, j});     // queue에 넣기
                } else {
                    candidate[0][i].remove(field[i][j]);    // 행 후보 제거
                    candidate[1][j].remove(field[i][j]);    // 열 후보 제거
                    candidate[2][getBoxIndex(i, j)].remove(field[i][j]);    // 박스 후보 제거
                }
            }
        }

        return queue;
    }

    static int getBoxIndex(int row, int col) {
        return row / 3 * 3 + col / 3;
    }

    static boolean solve(List<int[]> queue, int index) {
        if (index == queue.size()) {
            return true;
        }

        int[] pos = queue.get(index);
        int row = pos[0];
        int col = pos[1];
        int box = getBoxIndex(row, col);

        for (int n : CANDIDATES) {
            if (isCandidate(row, col, box, n)) {
                field[row][col] = n;
                removeCandidate(row, col, box, n);
                if (solve(queue, index + 1)) {
                    // 완료 상황 전파
                    return true;
                }
                field[row][col] = 0;
                addCandidate(row, col, box, n);     // 완료 아니면 원상복구
            }
        }
        return false;
    }

    static boolean isCandidate(int row, int col, int box, int n) {
        return candidate[0][row].contains(n)
            && candidate[1][col].contains(n)
            && candidate[2][box].contains(n);
    }

    static void removeCandidate(int row, int col, int box, int n) {
        candidate[0][row].remove(n);
        candidate[1][col].remove(n);
        candidate[2][box].remove(n);
    }

    static void addCandidate(int row, int col, int box, int n) {
        candidate[0][row].add(n);
        candidate[1][col].add(n);
        candidate[2][box].add(n);
    }


    static void print() {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                output.append(field[i][j]);
            }
            output.append("\n");
        }

        System.out.print(output);
    }
}
