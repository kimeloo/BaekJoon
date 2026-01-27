import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    static int max;
    static int[] blocks;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        max = Integer.parseInt(br.readLine().split(" ")[0]);
        blocks = Arrays.stream(br.readLine().trim().split(" "))
            .mapToInt(Integer::parseInt).toArray();
    }

    static int solve() {
        int result = 0;

        int[] leftMax = getLeftMax();
        int[] rightMax = getRightMax();
        for (int i = 0; i < blocks.length; i++) {
            result += Math.min(leftMax[i], rightMax[i]) - blocks[i];
        }

        return result;
    }

    static int[] getLeftMax() {
        int[] leftMax = new int[blocks.length];

        int max = 0;
        for (int i = 0; i < blocks.length; i++) {
            max = Math.max(blocks[i], max);
            leftMax[i] = max;
        }

        return leftMax;
    }

    static int[] getRightMax() {
        int[] rightMax = new int[blocks.length];

        int max = 0;
        for (int i = blocks.length - 1; i >= 0; i--) {
            max = Math.max(blocks[i], max);
            rightMax[i] = max;
        }

        return rightMax;
    }


}
