import java.util.*;
import java.io.*;

public class Main {

    static final int TARGET = 100;

    static List<Integer> heights;
    static int sum;

    public static void main(String[] args) throws IOException {
        input();
        output(solve());
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        heights = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            int height = Integer.parseInt(st.nextToken());
            heights.add(height);
            sum += height;
        }

        Collections.sort(heights);
    }

    static void output(List<Integer> answer) {
        Collections.sort(answer);

        StringBuilder sb = new StringBuilder();
        for (int n : answer) {
            sb.append(n).append("\n");
        }
        System.out.print(sb);
    }

    static List<Integer> solve() {
        HashSet<Integer> twoSum = new HashSet<>(heights);

        for (int height : heights) {
            if (twoSum.contains(sum - 100 - height)) {
                twoSum.remove(height);
                twoSum.remove(sum - 100 - height);
                break;
            }
        }

        return new ArrayList<>(twoSum);
    }
}
