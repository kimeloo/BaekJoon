import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] an = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            an[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(an);

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int a : an) {
            deque.offer(a);
        }

        int min = 0;
        int max = 0;
        boolean first = false;
        while (!deque.isEmpty()) {
            if (first) {
                min += deque.pollFirst();
                first = !first;
            } else {
                max += deque.pollLast();
                first = !first;
            }
        }

        System.out.println(min + " " + max);
    }
}