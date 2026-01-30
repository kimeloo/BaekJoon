import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Main {

    static int n;
    static List<Integer>[] graph;
    static Stack<Integer> dfsStack;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine().trim());
        for (int t = 0; t < testCase; t++) {
            input(br);
            System.out.println(solve());
        }
    }

    static void input(BufferedReader br) throws IOException {
        int[] inputArr = Arrays.stream(br.readLine().trim().split(" "))
            .mapToInt(Integer::parseInt).toArray();
        int size = inputArr[0];
        int lines = inputArr[1];
        init(size);

        for (int i = 0; i < lines; i++) {
            inputArr = Arrays.stream(br.readLine().trim().split(" "))
                .mapToInt(Integer::parseInt).toArray();
            graph[inputArr[0]].add(inputArr[1]);
        }
    }

    static void init(int size) {
        n = size;
        graph = new ArrayList[size + 1];
        for (int i = 0; i < size + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        dfsStack = new Stack<>();
        visited = new boolean[size + 1];
    }

    static int solve() {
        int ans = 0;
        // 정방향 dfs (visited false -> true)
        for (int i = 1; i < n + 1; i++) {
            if (!visited[i]) {
                dfs(i);
            }
        }

        // 역방향 dfs (visited true -> false)
        while (!dfsStack.isEmpty()) {
            int top = dfsStack.pop();
            if (!visited[top]) {    // 이미 방문한 경우
                continue;
            }
            ans++;
            dfs(top);
        }

        return ans;
    }

    static void dfs(int node) {
        visited[node] = !visited[node];
        for (int next : graph[node]) {
            if (visited[next] != visited[node]) {
                dfs(next);
            }
        }
        if (visited[node]) {
            dfsStack.push(node);
        }
    }
}
