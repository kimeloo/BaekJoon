import com.sun.source.util.Trees;
import java.util.*;
import java.io.*;

public class Main {

    static List<Integer>[] graph;
    static int[] distants;

    public static void main(String[] args) throws IOException {
        input();
        int[] ans = solve();
        System.out.println(ans[0] + " " + ans[1] + " " + ans[2]);
    }

    static int[] solve() {
        Deque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[]{1, 0});     // {현재 번호, 거리}
        while (!deque.isEmpty()) {
            int[] current = deque.poll();
            int cur = current[0];
            int dist = current[1];

            if (graph[cur] != null) {
                for (int nxt : graph[cur]) {
                    if (distants[nxt] > dist + 1) {
                        distants[nxt] = dist + 1;
                        deque.offer(new int[]{nxt, dist + 1});
                    }
                }
            }
        }

        int max = 0;
        TreeSet<Integer> maxHouse = new TreeSet<>();
        for (int h = 2; h < graph.length; h++) {
            if (distants[h] > max) {
                max = distants[h];
                maxHouse = new TreeSet<>();
                maxHouse.add(h);
            } else if (distants[h] == max) {
                maxHouse.add(h);
            }
        }
        return new int[]{maxHouse.first(), max, maxHouse.size()};
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputStr = br.readLine().split(" ");

        int n = Integer.parseInt(inputStr[0]);
        int m = Integer.parseInt(inputStr[1]);
        graph = new ArrayList[n + 1];
        for (int i = 0; i < m; i++) {
            inputStr = br.readLine().split(" ");
            int a = Integer.parseInt(inputStr[0]);
            int b = Integer.parseInt(inputStr[1]);

            if (graph[a] == null) {
                graph[a] = new ArrayList<>();
            }
            if (graph[b] == null) {
                graph[b] = new ArrayList<>();
            }
            graph[a].add(b);
            graph[b].add(a);
        }
        distants = new int[n + 1];
        Arrays.fill(distants, Integer.MAX_VALUE);
    }
}
