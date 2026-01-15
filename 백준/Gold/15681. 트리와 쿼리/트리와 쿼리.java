import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int root;
    static int[] queries;

    public static void main(String[] args) throws IOException {
        Set<Integer>[] graph = input();
        int[] count = getChildCount(graph);
        answer(count);
    }

    static Set<Integer>[] input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        root = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        queries = new int[q];

        // 무향 그래프 생성
        Set<Integer>[] graph = new HashSet[n + 1];
        for (int i = 0; i < n + 1; i++) {
            graph[i] = new HashSet<>();
        }

        // 무향 그래프 입력
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        // 질의 목록 입력
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            queries[i] = Integer.parseInt(st.nextToken());
        }

        return graph;
    }

    static int[] getChildCount(Set<Integer>[] graph) {
        int[] result = new int[graph.length];

        boolean[] visited = new boolean[graph.length];
        List<Integer> order = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            int current = stack.pop();
            if (visited[current]) {
                continue;
            }
            // 방문 처리
            visited[current] = true;
            order.add(current);

            // 다음 방문할 목록 저장
            int node = 0;   // 초기화
            for (int nxt : graph[current]) {
                if (visited[nxt]) {     // 방문했다면 부모
                    node = nxt;
                } else {
                    stack.add(nxt);
                }
            }
            graph[current].remove(node);
        }

        for (int i = order.size() - 1; i >= 0; i--) {
            int current = order.get(i);

            // 기본값 1 + 자식의 합
            result[current] = 1;
            for (int child : graph[current]) {
                result[current] += result[child];
            }
        }

        return result;
    }

    static void answer(int[] count) {
        StringBuilder output = new StringBuilder();
        for (int q : queries) {
            output.append(count[q]);
            output.append("\n");
        }
        System.out.println(output);
    }
}
