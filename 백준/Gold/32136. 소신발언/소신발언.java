import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] cows;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().strip());
        cows = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cows[i] = Integer.parseInt(st.nextToken());
        }
        br.close();
    }

    static long binarySearch() {
        // T를 탐색
        long left = 0L;
        long right = 150000000000L;   // 300,000 * 500,000
        long mid = 0L;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (simulate(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    static boolean simulate(long time) {
        int start = 0;
        int end = N;
        for (long i = 0; i < N; i++) {
            long distance = time / cows[(int)i];
            int left = (int) Math.max(start, i-distance);
            int right = (int) Math.min(end, i+distance);
            if (left > end || right < start){
                return false;
            }
            start = left;
            end = right;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(binarySearch());
    }
}
