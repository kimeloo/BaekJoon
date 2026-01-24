import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int n;
    static int start;
    static int end;
    static int[][] graph;
    static int[] cities;

    static final long MIN = Long.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputArr = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt).toArray();

        n = inputArr[0];
        start = inputArr[1];
        end = inputArr[2];
        int m = inputArr[3];
        graph = new int[m][3];

        for (int i = 0; i < m; i++) {
            graph[i] = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
            graph[i][2] *= -1;
        }

        cities = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt).toArray();
    }

    static void solve() {
        long[] money = new long[n];
        Arrays.fill(money, MIN);
        money[start] = cities[start];

        for (int i = 0; i <= n; i++) {
            for (int[] road : graph) {
                int u = road[0];
                int v = road[1];
                int d = road[2];

                long next = money[u] + d + cities[v];
                if (money[u] != MIN && money[v] < next) {
                    money[v] = next;
                    if (i == n && reachEnd(v)) {
                        System.out.println("Gee");
                        return;
                    }
                }
            }
        }

        if (money[end] == MIN) {
            System.out.println("gg");
        } else {
            System.out.println(money[end]);
        }
    }

    static boolean reachEnd(int from) {
        long[] dist = new long[n];
        Arrays.fill(dist, MIN);
        dist[from] = 0;

        for (int city = 0; city < n; city++) {
            for (int[] road : graph) {
                if (dist[road[0]] != MIN) {
                    if (road[1] == end) {
                        return true;
                    }
                    dist[road[1]] = Math.max(dist[road[1]], dist[road[0]] + road[2]);
                }
            }
        }
        return dist[end] != MIN;
    }
}
