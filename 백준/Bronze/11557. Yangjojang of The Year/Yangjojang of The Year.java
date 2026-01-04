import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine().trim());
            String maxName = "";
            int max = -1;
            for (int j = 0; j < n; j++) {
                String[] input = br.readLine().trim().split(" ");
                int l = Integer.parseInt(input[1]);
                if (l > max) {
                    maxName = input[0];
                    max = l;
                }
            }
            System.out.println(maxName);
        }
    }
}
