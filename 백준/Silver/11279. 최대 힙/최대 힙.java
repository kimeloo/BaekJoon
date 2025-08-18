import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        StringBuilder out = new StringBuilder();

        PriorityQueue<Integer> heapq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < n; i++) {
            int cur = Integer.parseInt(br.readLine().trim());
            if (cur == 0) {
                out.append(heapq.isEmpty() ? 0 : heapq.poll());
                out.append("\n");
            } else {
                heapq.offer(cur);
            }
        }
        System.out.print(out);
    }
}
