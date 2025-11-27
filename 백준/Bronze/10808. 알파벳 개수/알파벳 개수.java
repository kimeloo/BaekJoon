import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] s = br.readLine().trim().toCharArray();
        int[] chars = new int[26];
        for (char c:s){
            chars[c-'a']++;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i:chars){
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}
