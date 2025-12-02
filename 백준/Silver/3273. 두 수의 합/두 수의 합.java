import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] an = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            an[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(an);
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());

        int left = 0;
        int right = n - 1;
        int ans = 0;
        while (left<right) {
            int sum = an[left] + an[right];
            if (sum > x) {
                right--;
            } else if (sum < x) {
                left++;
            } else {
                ans++;
                left++;
            }
        }
        System.out.println(ans);
    }
}
