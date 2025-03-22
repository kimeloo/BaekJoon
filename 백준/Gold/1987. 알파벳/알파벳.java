import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int CNT, MAX, N, M;
	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };

	static char[][] MAP;
	static boolean[] VISITED;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		MAP = new char[N][M];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for (int c = 0; c < M; c++) {
				MAP[r][c] = str.charAt(c);
			}
		}
		br.close();

		CNT = MAX = 1;
		VISITED = new boolean['Z' - 'A' + 1];
		VISITED[MAP[0][0] - 'A'] = true;
		search(0, 0);
		System.out.println(MAX);
	}

	static void search(int r, int c) {
		boolean check = false;
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (isValid(nr, nc) && !VISITED[MAP[nr][nc] - 'A']) {
				VISITED[MAP[nr][nc] - 'A'] = true;
				CNT++;
				search(nr, nc);
				VISITED[MAP[nr][nc] - 'A'] = false;
				CNT--;
				check = true;
			}
		}
		if (!check) {
			MAX = Math.max(MAX, CNT);
		}
	}

	static boolean isValid(int r, int c) {
		if (r >= N || c >= M || r < 0 || c < 0) {
			return false;
		}
		return true;
	}
}