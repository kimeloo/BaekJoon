import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        int ans = 0;
        for (int i = 0; i < n; i++) {
            boolean flag = true;
            boolean[] check = new boolean['z' - 'a' + 1];

            char bef = '-';
            for (char c : br.readLine().trim().toCharArray()) {
                if (check[c - 'a'] && c != bef) {
                    flag = false;
                    break;
                }
                check[c - 'a'] = true;
                bef = c;
            }

            if (flag) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}
