import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int c = Integer.parseInt(br.readLine().trim());

        for (int tc = 0; tc < c; tc++) {
            int[] input = Arrays.stream(br.readLine().trim().split(" "))
                .mapToInt(Integer::parseInt).toArray();

            double avg = 0;
            int n = input[0];
            for (int st = 1; st <= n; st++) {
                avg += input[st];
            }
            avg /= n;

            int cnt = 0;
            for (int st = 1; st <= n; st++) {
                if (input[st] > avg) {
                    cnt++;
                }
            }

            double ans = (double) cnt * 100 / n;
            System.out.printf("%.3f%%\n", ans);
        }
    }
}
