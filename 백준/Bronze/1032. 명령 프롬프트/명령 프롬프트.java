import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        String[] inputStrArr = new String[n];
        for (int i = 0; i < n; i++) {
            inputStrArr[i] = br.readLine().trim();
        }

        StringBuilder pattern = new StringBuilder();
        for (int i = 0; i < inputStrArr[0].length(); i++) {
            char c = inputStrArr[0].charAt(i);
            for (int j = 1; j < n; j++) {
                if (inputStrArr[j].charAt(i) != c) {
                    c = '?';
                    break;
                }
            }
            pattern.append(c);
        }

        System.out.println(pattern);
    }
}
