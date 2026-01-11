import java.util.*;
import java.io.*;

public class Main{
    
    static final String chars = "aeiouAEIOU";
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String[] input = br.readLine().trim().split(" ");
            if ("#".equals(input[0])) {
                break;
            }
            
            int[] counter = new int[150];
            for (String str : input) {
                for (char c : str.toCharArray()) {
                    counter[c]++;
                }
            }
            
            int ans = 0;
            for (char c : chars.toCharArray()) {
                ans += counter[c];
            }
            System.out.println(ans);
        }
    }
}