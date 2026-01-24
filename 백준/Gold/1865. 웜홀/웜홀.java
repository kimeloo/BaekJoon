import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    static int n;
    static final int MAX = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine().trim());
        for (int t = 0; t < tc; t++) {
            List<int[]> dist = input(br);
            System.out.println(solve(dist) ? "YES" : "NO");
        }
    }

    static List<int[]> input(BufferedReader br) throws IOException {
        int[] input = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt).toArray();
        n = input[0];
        int roads = input[1];
        int wormholes = input[2];

        List<int[]> graph = new ArrayList<>();
        for (int i = 0; i < roads; i++) {
            input = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
            graph.add(new int[]{input[0], input[1], input[2]});
            graph.add(new int[]{input[1], input[0], input[2]});
        }
        for (int i = 0; i < wormholes; i++) {
            input = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
            graph.add(new int[]{input[0], input[1], -input[2]});
        }

        return graph;
    }

    static boolean solve(List<int[]> graph) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, MAX);
        // 도달 불가한 웜홀이 있는 경우를 대비해, 모든 웜홀을 시작점으로 추가
        for (int[] road : graph) {
            if (road[2] < 0) {
                dist[road[0]] = 0;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int[] road : graph) {
                int u = road[0];
                int v = road[1];
                int d = road[2];
                if (dist[u] != MAX
                    && dist[v] > dist[u] + d) {
                    dist[v] = dist[u] + d;
                    if (i == n - 1) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
