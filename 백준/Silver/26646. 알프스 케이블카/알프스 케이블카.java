import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int result = 0;
        String[] input = br.readLine().trim().split(" ");
        int bef = 0;
        for (int i = 0; i < n; i++) {
            int cur = Integer.parseInt(input[i]);
            if (bef != 0) {
                result += (cur - bef) * (cur - bef);
                result += (cur + bef) * (cur + bef);
            }
            bef = cur;
        }
        System.out.println(result);
    }
}
