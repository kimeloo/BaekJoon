import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        for (char c : br.readLine().trim().toCharArray()) {
            sum += (c - 'A' - (c >= 'S' ? 1 : 0)) / 3 + 3 - (c == 'Z' ? 1 : 0);
        }
        System.out.println(sum);
    }
}
