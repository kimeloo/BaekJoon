import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean[][] map = new boolean[N][M];
		int[][][] visited = new int[N][M][2];
		visited[0][0][0] = -1;
		visited[0][0][1] = -1;

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			for (int c = 0; c < M; c++) {
				map[r][c] = (s.charAt(c) == '1' ? true : false);
			}
		}

		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.add(new int[] { 0, 0, 1, 0 }); // r, c, cnt, wall

		while (!q.isEmpty()) {
			int[] next = q.poll();
			int r, c, cnt, wall;
			r = next[0];
			c = next[1];
			cnt = next[2];
			wall = next[3];
			if (r == N - 1 && c == M - 1) {
				System.out.println(cnt);
				return;
			}

			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (nr >= N || nc >= M || nr < 0 || nc < 0) {
					continue;
				}
				if (wall == 0 && map[nr][nc] && (visited[nr][nc][1] == 0 || visited[nr][nc][1] > cnt + 1)) {
					visited[nr][nc][1] = cnt + 1;
					q.offer(new int[] { nr, nc, cnt + 1, 1 });
				}
				if (!map[nr][nc] && (visited[nr][nc][wall] == 0) || visited[nr][nc][wall] > cnt + 1) {
					visited[nr][nc][wall] = cnt + 1;
					q.offer(new int[] { nr, nc, cnt + 1, wall });
				}
			}
		}
		System.out.println(-1);

		br.close();
	}
}