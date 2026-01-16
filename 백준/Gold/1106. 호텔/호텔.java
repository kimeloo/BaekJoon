import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final int MAX_COST = 200000;

    static int target;
    static int[][] cities;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        target = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        cities = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            cities[i][0] = Integer.parseInt(st.nextToken());
            cities[i][1] = Integer.parseInt(st.nextToken());
        }
    }

    static int solve() {
        dp = new int[MAX_COST];
        for (int cost = 0; cost < MAX_COST; cost++) {
            for (int[] city : cities) {
                dp[cost] = Math.max(dp[cost], findCustomer(cost, city));
            }

            if (dp[cost] >= target) {
                return cost;
            }
        }
        return 0;
    }

    static int findCustomer(int maxCost, int[] city) {
        int cost = city[0];
        int customer = city[1];
        int maxCustomer = dp[maxCost];

        if (maxCost >= cost) {
            maxCustomer = Math.max(dp[maxCost], dp[maxCost - cost] + customer);
        }

        return maxCustomer;
    }
}
