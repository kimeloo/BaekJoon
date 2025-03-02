import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long pow(long base, long exp, long mod) {
		long res = 1;
		base %= mod;
		while (exp > 0) {
			if (exp % 2 == 1) {
				res = (res * base) % mod;
			}
			exp /= 2;
			base = (base * base) % mod;
		}
		return res;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		long c = Long.parseLong(st.nextToken());
		System.out.println(pow(a, b, c));
		br.close();
	}
}