import java.io.*;

public class Main {

    static int n;
    static int target;
    static int[] sumArr;

    public static void main(String[] args) throws IOException {
        input();
        int result = twoPointer();
        System.out.println(result);
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputStr = br.readLine().trim().split(" ");
        n = Integer.parseInt(inputStr[0]);
        target = Integer.parseInt(inputStr[1]);
        sumArr = new int[n + 1];

        inputStr = br.readLine().trim().split(" ");
        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(inputStr[i]);
            sumArr[i + 1] = sumArr[i] + k;

        }
    }

    static int twoPointer() {
        // 불가능한 조건
        if (sumArr[n] < target) {
            return 0;
        }

        int lt = 0;
        int rt = 1;
        int ans = Integer.MAX_VALUE;

        while (rt <= n) {
            int sum = sumArr[rt] - sumArr[lt];
            if (sum < target) {
                rt++;
            } else {
                ans = Math.min(ans, rt - lt);
                lt++;
            }
        }
        return ans;
    }
}
