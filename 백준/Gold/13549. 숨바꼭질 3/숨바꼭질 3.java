import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
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
        ArrayDeque<int[]> deque = new ArrayDeque<>();

        deque.add(new int[]{n, 0});
        while (!deque.isEmpty()) {
            int[] cur = deque.pollFirst();
            int pos = cur[0];
            int time = cur[1];
            if (dist[pos] > time) {
                dist[pos] = time;

                if (pos > 0 && dist[pos - 1] > time + 1) {
                    deque.offerLast(new int[]{pos - 1, time + 1});
                }
                if (pos < 100000 && dist[pos + 1] > time + 1) {
                    deque.offerLast(new int[]{pos + 1, time + 1});
                }
                if (pos != 0) {
                    for (int nxt = pos * 2; nxt < 100001; nxt *= 2) {
                        if (dist[nxt] > time) {
                            deque.offerFirst(new int[]{nxt, time});
                        }
                    }
                }
            }
            if (pos == k) {
                break;
            }
        }
    }

    static void output() {
        System.out.println(dist[k]);
    }
}
