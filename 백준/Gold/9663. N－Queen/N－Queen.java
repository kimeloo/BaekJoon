import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, CNT;
	static boolean[][] BOARD;

	static BufferedReader br;
	static StringTokenizer st;

	static int nextInt() throws IOException {
		st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = nextInt();
		BOARD = new boolean[N][N];
		CNT = 0;
		search(0);
		System.out.print(CNT);
		br.close();
	}

	static void search(int row) {
		if (row == N) {
			CNT++;
			return;
		}

		for (int col = 0; col < N; col++) {
			if (isOk(row, col)) {
				BOARD[row][col] = true;
				search(row + 1);
				BOARD[row][col] = false;
			}
		}
	}

	static boolean isOk(int r, int c) {
		int nr, nc;
		int[] dr = { -1, -1, -1 };
		int[] dc = { 1, -1, 0 };

		for (int x = 1; x < N; x++) {
			for (int d = 0; d < 3; d++) {
				nr = r + x * dr[d];
				nc = c + x * dc[d];
				if (isValid(nr, nc) && BOARD[nr][nc]) {
					return false;
				}
			}
		}
		return true;
	}

	static boolean isValid(int r, int c) {
		if (r >= N || c >= N || r < 0 || c < 0) {
			return false;
		}
		return true;
	}
}