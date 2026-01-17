import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = Arrays.stream(br.readLine().split(" "))
            .map(s -> {
                StringBuilder sb = new StringBuilder(s);
                sb.reverse();
                return sb.toString();
            }).mapToInt(Integer::parseInt).toArray();
        System.out.println(Arrays.stream(nums).max().getAsInt());
    }
}
