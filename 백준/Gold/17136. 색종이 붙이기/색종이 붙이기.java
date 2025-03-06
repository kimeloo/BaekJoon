import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int MIN;
	static int[] papers;
	static boolean[][] MAP;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int ones = 0;
		MIN = Integer.MAX_VALUE;
		papers = new int[] { 0, 5, 5, 5, 5, 5 };
		MAP = new boolean[10][10];
		for (int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				MAP[i][j] = (Integer.parseInt(st.nextToken()) == 1 ? true : false);
				if (MAP[i][j]) {
					ones++;
				}
			}
		}

		dfs(ones, 0);
		System.out.println((MIN == Integer.MAX_VALUE ? -1 : MIN));

		br.close();
	}

	static void dfs(int cellLeft, int count) {
		if (cellLeft==0) {
			MIN = Math.min(MIN, count);
			return;
		} else if (count > MIN || count > 25) {
			return;
		}
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (!MAP[i][j]) {
					continue;
				}
				for (int size = 5; size >= 1; size--) {
					if (papers[size] > 0 && canCover(i, j, size)) {
						cover(i, j, size, false);
						papers[size]--;
						dfs(cellLeft - size * size, count + 1);
						papers[size]++;
						cover(i, j, size, true);
					}
				}
				return;
			}
		}
	}

	static boolean canCover(int r, int c, int size) {
		if (r + size > 10 || c + size > 10) {
			return false;
		}
		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				if (!MAP[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	static void cover(int r, int c, int size, boolean rollBack) {
		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				MAP[i][j] = rollBack;
			}
		}
	}

}