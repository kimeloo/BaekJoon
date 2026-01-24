import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().trim().split(" "))
            .mapToInt(Integer::parseInt).toArray();

        System.out.println(pow(input[0], input[1], input[2]));
    }

    static int pow(int base, int exp, int div) {
        int result = 1;

        while (exp > 0) {
            if (exp % 2 == 1) {
                result = (int) (((long) result * base) % div);
            }
            base = (int) (((long) base * base) % div);
            exp /= 2;
        }

        return result;
    }
}
