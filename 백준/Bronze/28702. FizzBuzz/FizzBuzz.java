import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int nxt = 0;
        for (int i = 3; i > 0; i--) {
            st = new StringTokenizer(br.readLine());
            String input = st.nextToken();
            if (input.charAt(0) <= '9') {
                nxt = Integer.parseInt(input.strip()) + i;
                break;
            }
        }
        StringBuilder result = new StringBuilder();
        if (nxt % 3 == 0) {
            result.append("Fizz");
        }
        if (nxt % 5 == 0) {
            result.append("Buzz");
        }
        if (result.isEmpty()){
            result.append(nxt);
        }
        System.out.println(result);
    }
}