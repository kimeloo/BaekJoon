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

        for (int height = max; height > 0; height--) {
            int lastIdx = -1;
            for (int i = 0; i < blocks.length; i++) {
                if (blocks[i] >= height) {
                    if (lastIdx != -1) {
                        result += i - lastIdx - 1;
                    }
                    lastIdx = i;
                }
            }
        }

        return result;
    }
}
