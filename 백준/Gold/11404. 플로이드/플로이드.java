import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int n;
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        print();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine().trim());

        graph = new int[n + 1][n + 1];
        for (int[] arr : graph) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        for (int i = 1; i <= n; i++) {
            graph[i][i] = 0;
        }

        int m = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < m; i++) {
            int[] bus = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
            graph[bus[0]][bus[1]] = Math.min(graph[bus[0]][bus[1]], bus[2]);
        }
    }

    static void solve() {
        for (int k = 1; k <= n; k++) {
            for (int from = 1; from <= n; from++) {
                for (int to = 1; to <= n; to++) {
                    if (graph[from][k] == Integer.MAX_VALUE || graph[k][to] == Integer.MAX_VALUE) {
                        continue;
                    }
                    graph[from][to] =
                        Math.min(graph[from][to], graph[from][k] + graph[k][to]);
                }
            }
        }
    }

    static void print() {
        StringBuilder output = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                output.append(graph[i][j] == Integer.MAX_VALUE ? 0 : graph[i][j]).append(" ");
            }
            output.append("\n");
        }
        System.out.println(output);
    }
}
