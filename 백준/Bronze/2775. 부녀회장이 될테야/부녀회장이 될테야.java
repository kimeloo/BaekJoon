import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		int k, n;
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			System.out.println(under(k, n));
		}

		br.close();
	}

	static int under(int k, int n) {
		int sum = 0;
		if (k == 0) {
			return n;
		}

		for (int i = 1; i <= n; i++) {
			sum += under(k - 1, i);
		}
		return sum;
	}
}
