import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int target;
    static long[] an;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        an = new long[n + 1];
        for (int i = 0; i < n; i++) {
            an[i + 1] = an[i] + Integer.parseInt(st.nextToken());
        }
    }

    static long solve() {
        long answer = 0;
        Map<Long, Long> count = new HashMap<>();

        for (int i = 0; i <= n; i++) {
            if (count.containsKey(an[i] - target)) {
                answer += count.get(an[i] - target);
            }
            count.put(an[i], count.getOrDefault(an[i], 0L) + 1);
        }
        return answer;
    }
}
