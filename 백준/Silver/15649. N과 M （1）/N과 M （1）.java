import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static List<List<Integer>> ans;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
    }

    static void output() {
        StringBuilder sb = new StringBuilder();
        for (List<Integer> list : ans) {
            for (int n : list) {
                sb.append(n).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    static void solve() {
        ans = new ArrayList<>();
        backtrack(new ArrayDeque<>(), new boolean[N + 1]);
    }

    static void backtrack(Deque<Integer> deque, boolean[] visited) {
        // M개의 수를 모두 선택한 경우 중단
        if (deque.size() == M) {
            ans.add(new ArrayList<>(deque));
            return;
        }

        // start부터 N까지 수열에 넣으며 재귀
        for (int i = 1; i <= N; i++) {
            if (visited[i]) {
                continue;
            }
            deque.addLast(i);
            visited[i] = true;
            backtrack(deque, visited);
            deque.removeLast();
            visited[i] = false;
        }
    }
}
