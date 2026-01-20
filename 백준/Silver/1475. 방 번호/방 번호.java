import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        int[] nums = new int[10];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (char c : br.readLine().toCharArray()) {
            nums[c - '0']++;
        }

        nums[6] = (int) Math.ceil((double) (nums[6] + nums[9]) / 2);
        nums[9] = 0;

        System.out.println(Arrays.stream(nums).max().getAsInt());
    }
}
