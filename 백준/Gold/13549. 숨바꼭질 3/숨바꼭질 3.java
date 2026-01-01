import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    static int n;
    static int k;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        output();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputStr = br.readLine().trim().split(" ");
        br.close();

        n = Integer.parseInt(inputStr[0]);
        k = Integer.parseInt(inputStr[1]);
        dist = new int[100001];
        Arrays.fill(dist, Integer.MAX_VALUE);
    }

    static void solve() {
        PriorityQueue<int[]> heapq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));

        heapq.add(new int[]{n, 0});
        while (!heapq.isEmpty()) {
            int[] cur = heapq.poll();
            if (dist[cur[0]] > cur[1]) {
                dist[cur[0]] = cur[1];

                if (cur[0] > 0 && dist[cur[0] - 1] > cur[1] + 1) {
                    heapq.offer(new int[]{cur[0] - 1, cur[1] + 1});
                }
                if (cur[0] < 100000 && dist[cur[0] + 1] > cur[1] + 1) {
                    heapq.offer(new int[]{cur[0] + 1, cur[1] + 1});
                }
                if (cur[0] != 0) {
                    for (int nxt = cur[0]; nxt < 100001; nxt *= 2) {
                        if (dist[nxt] > cur[1]) {
                            heapq.offer(new int[]{nxt, cur[1]});
                        }
                    }
                }
            }
            if (cur[0] == k) {
                break;
            }
        }
    }

    static void output() {
        System.out.println(dist[k]);
    }
}
