import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static long[] lines;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        lines = new long[K];
        for (int i = 0; i < K; i++) {
            lines[i] = Long.parseLong(br.readLine().strip());
        }
        Arrays.sort(lines);
    }

    static long findMid() {
        long left = 1;
        long right = Long.MAX_VALUE;
        long ans = 0;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (calculate(mid)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    static boolean calculate(long len) {
        long sum = 0;
        for (int i = K - 1; i >= 0; i--) {
            long line = lines[i] / len;
            if (line == 0)
                break;
            sum += line;
        }
        return sum >= N;
    }

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(findMid());
    }
}
