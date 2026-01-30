import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class Main {

    static int v;
    static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        output();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().trim().split(" "))
            .mapToInt(Integer::parseInt).toArray();

        // 초기화
        v = input[0];
        int e = input[1];
        graph = new ArrayList[v + 1];

        for (int i = 0; i < v + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        // 입력값 저장
        for (int i = 0; i < e; i++) {
            input = Arrays.stream(br.readLine().trim().split(" "))
                .mapToInt(Integer::parseInt).toArray();
            int x = input[0];
            int y = input[1];
            graph[x].add(y);
        }
    }

    static Stack<Integer> stack;
    static boolean[] finished;  // SCC 추출 완료 여부
    static int[] dfsId;         // DFS 방문 순서
    static int[] low;           // 도달 가능한 가장 작은 dfsId
    static int dfsCnt;
    static List<List<Integer>> scc;

    static void solve() {
        stack = new Stack<>();
        finished = new boolean[v + 1];
        dfsId = new int[v + 1];
        low = new int[v + 1];
        dfsCnt = 0;
        scc = new ArrayList<>();

        for (int i = 1; i < v + 1; i++) {
            if (dfsId[i] == 0) {  // 방문하지 않은 노드
                dfs(i);
            }
        }
    }

    static void dfs(int node) {
        dfsId[node] = ++dfsCnt;  // 방문 순서 기록 (1부터 시작)
        low[node] = dfsId[node];  // 초기값: 자기 자신의 dfsId
        stack.push(node);

        // 인접한 노드들 탐색
        for (int next : graph[node]) {
            if (dfsId[next] == 0) {
                // 1. 아직 방문하지 않은 노드
                dfs(next);
                low[node] = Math.min(low[node], low[next]);

            } else if (!finished[next]) {
                // 2. 방문했지만 아직 SCC 추출 안 된 노드
                low[node] = Math.min(low[node], dfsId[next]);
            }
            // 3. 이미 SCC 추출 완료된 노드는 무시 (다른 SCC에 속함)
        }

        // 4. SCC 추출
        if (dfsId[node] == low[node]) {
            List<Integer> currentScc = new ArrayList<>();
            while (!stack.isEmpty()) {
                int top = stack.pop();
                currentScc.add(top);
                finished[top] = true;

                if (top == node) {
                    break;
                }
            }
            scc.add(currentScc);
        }
    }

    static void output() {
        for (int i = 0; i < scc.size(); i++) {
            scc.get(i).sort(Integer::compare);
        }
        scc.sort((Comparator.comparingInt(o -> o.get(0))));

        StringBuilder sb = new StringBuilder();
        sb.append(scc.size()).append("\n");
        for (List<Integer> list : scc) {
            for (int i : list) {
                sb.append(i).append(" ");
            }
            sb.append(-1).append("\n");
        }
        System.out.print(sb);
    }
}
