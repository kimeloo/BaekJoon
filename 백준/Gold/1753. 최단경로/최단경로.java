import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder out = new StringBuilder();

        int points, roads, start;
        int[] dist;
        HashMap<Integer, ArrayList<int[]>> field = new HashMap<>();

        points = Integer.parseInt(st.nextToken());
        roads = Integer.parseInt(st.nextToken());
        dist = new int[points + 1];
        for (int i = 0; i < points + 1; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());

        for (int r = 0; r < roads; r++) {
            st = new StringTokenizer(br.readLine());
            int u, v, w;
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            if (!field.containsKey(u)) {
                field.put(u, new ArrayList<>());
            }
            field.get(u).add(new int[]{v, w});

        }

        PriorityQueue<int[]> heapq = new PriorityQueue<>((o1, o2) -> {
            return o1[1] - o2[1];
        });

        heapq.offer(new int[]{start, 0});
        while (!heapq.isEmpty()) {
            int[] cur = heapq.poll();
            int to = cur[0];
            int w = cur[1];
            if (dist[to] <= w) {
                continue;
            }
            dist[to] = w;
            if (!field.containsKey(to)) {
                continue;
            }
            ArrayList<int[]> nexts = field.get(to);
            for (int[] next : nexts) {
                heapq.offer(new int[]{next[0], next[1] + w});
            }
        }

        for (int p = 1; p < points + 1; p++) {
            System.out.println(dist[p] == Integer.MAX_VALUE ? "INF" : dist[p]);
        }
    }
}
