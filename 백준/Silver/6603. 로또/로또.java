import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, r;
	static int[] pool, selected;
	static StringBuilder out;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		out = new StringBuilder();

		r = 6;
		selected = new int[r];
		while (true) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			if (n == 0)
				break;

			pool = new int[n];
			for (int i = 0; i < n; i++)
				pool[i] = Integer.parseInt(st.nextToken());
			Arrays.sort(pool);

			comb(0, 0);

			out.append("\n");
		}
		System.out.print(out);

		br.close();
	}

	static void comb(int idx, int sidx) {
		if (sidx == r) {
			for (int i : selected)
				out.append(i).append(" ");
			out.append("\n");
			return;
		}
		if (idx == n)
			return;
		selected[sidx] = pool[idx];
		comb(idx + 1, sidx + 1);
		comb(idx + 1, sidx);
	}
}