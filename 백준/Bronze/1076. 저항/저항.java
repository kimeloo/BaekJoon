import java.io.*;
import java.util.*;

public class Main {

    enum Color {
        black(0),
        brown(1),
        red(2),
        orange(3),
        yellow(4),
        green(5),
        blue(6),
        violet(7),
        grey(8),
        white(9);

        private final long val;

        Color(long val) {
            this.val = val;
        }

        public long val() {
            return val;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long result = 0;
        result += 10 * Color.valueOf(br.readLine().trim()).val();
        result += Color.valueOf(br.readLine().trim()).val();
        result *= (long) Math.pow(10, Color.valueOf(br.readLine().trim()).val());

        System.out.println(result);
    }
}
