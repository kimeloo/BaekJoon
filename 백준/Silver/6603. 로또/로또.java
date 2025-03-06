import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int k, r;
	static int[] pool, selected;
	static ArrayList<int[]> combResult;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder out = new StringBuilder();

		r = 6;
		while (true) {
			st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			if (k == 0) {
				break;
			}

			pool = new int[k];
			for (int i = 0; i < k; i++) {
				pool[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(pool);

			combResult = new ArrayList<>();
			selected = new int[r];
			comb(0, 0);

			for (int[] combination : combResult) {
				for (int i : combination) {
					out.append(i).append(" ");
				}
				out.append("\n");
			}
			out.append("\n");
		}
		System.out.print(out);

		br.close();
	}

	static void comb(int idx, int cnt) {
		if (cnt == r) {
			int[] temp = new int[r];
			System.arraycopy(selected, 0, temp, 0, r);
			combResult.add(temp);
			return;
		}
		if (idx == k) {
			return;
		}
		selected[cnt] = pool[idx];
		comb(idx + 1, cnt + 1);
		comb(idx + 1, cnt);
	}
}