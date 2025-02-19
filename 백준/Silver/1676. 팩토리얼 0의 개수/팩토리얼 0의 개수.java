import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		int n, num, cnt2, cnt5;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		cnt2 = cnt5 = 0;

		for (int i = 2; i <= n; i++) {
			num = i;
			while (num % 2 == 0) {
				cnt2++;
				num /= 2;
			}
			while (num % 5 == 0) {
				cnt5++;
				num /= 5;
			}
		}
		System.out.println(Math.min(cnt2, cnt5));
	}
}