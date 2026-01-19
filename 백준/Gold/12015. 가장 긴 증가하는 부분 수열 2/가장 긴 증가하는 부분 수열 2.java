import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        int[] arr = input();
        System.out.println(solve(arr));
    }

    static int[] input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();

        return Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt).toArray();
    }

    static int solve(int[] arr) {
        List<Integer> dp = new ArrayList<>();
        for (int n : arr) {
            int idx = findIdx(dp, n);
            if (idx == dp.size()) {
                dp.add(n);
            } else {
                dp.set(idx, n);
            }
        }
        return dp.size();
    }

    static int findIdx(List<Integer> list, int n) {
        int lt = 0;
        int rt = list.size();

        while (lt < rt) {
            int mid = lt + (rt - lt) / 2;
            if (list.get(mid) >= n) {
                rt = mid;
            } else {
                lt = mid + 1;
            }
        }
        return lt;
    }
}
