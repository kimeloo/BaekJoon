import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    static int[] arr;
    static int[] lisIndex;

    public static void main(String[] args) throws IOException {
        getInput();
        int lis = calcLis();
        int[] ans = reverseTrack(lis);
        print(ans);
    }

    static void getInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        arr = Arrays.stream(br.readLine().trim().split(" "))
            .mapToInt(Integer::parseInt).toArray();
    }

    static int calcLis() {
        List<Integer> result = new ArrayList<>();
        lisIndex = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            int idx = getIdx(result, arr[i]);
            if (idx == result.size()) {
                result.add(arr[i]);
            } else {
                result.set(idx, arr[i]);
            }
            lisIndex[i] = idx;
        }
        return result.size();
    }

    static int[] reverseTrack(int lis) {
        int[] result = new int[lis];
        int currentIdx = lis - 1;

        for (int i = lisIndex.length - 1; i >= 0; i--) {
            if (lisIndex[i] == currentIdx) {
                result[currentIdx] = arr[i];
                currentIdx--;
            }
        }

        return result;
    }

    static int getIdx(List<Integer> dp, int target) {
        int lt = 0;
        int rt = dp.size();
        while (lt < rt) {
            int mid = lt + (rt - lt) / 2;
            if (dp.get(mid) >= target) {
                rt = mid;
            } else {
                lt = mid + 1;
            }
        }
        return lt;
    }

    static void print(int[] ans) {
        StringBuilder sb = new StringBuilder();
        sb.append(ans.length).append("\n");
        for (int n : ans) {
            sb.append(n).append(" ");
        }

        System.out.println(sb);
    }
}
