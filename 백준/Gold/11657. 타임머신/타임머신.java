import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static final long MAX = Long.MAX_VALUE;

    static int n;
    static long[] dist;
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(output(solve()));
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputArr = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt).toArray();
        n = inputArr[0];
        graph = new int[inputArr[1]][3];

        for (int i = 0; i < inputArr[1]; i++) {
            graph[i] = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        }
    }

    static boolean solve() {
        dist = new long[n + 1];
        Arrays.fill(dist, MAX);
        dist[1] = 0;

        for (int i = 0; i < n; i++) {
            for (int[] road : graph) {
                int from = road[0];
                int to = road[1];
                int time = road[2];

                if (dist[from] != MAX && dist[to] > dist[from] + time) {
                    dist[to] = dist[from] + time;
                    if (i == n - 1) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    static String output(boolean isLoop) {
        if (isLoop) {
            return "-1";
        }
        StringBuilder out = new StringBuilder();
        for (int city = 2; city <= n; city++) {
            out.append(dist[city] == MAX ? -1 : dist[city]).append("\n");
        }
        return out.toString().trim();

    }
}
