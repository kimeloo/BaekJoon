import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder out = new StringBuilder();

		int N, M;
		int[][] map;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][N + 1];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 1; c < N+1; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				map[r][c] += map[r][c - 1];
			}
		}

		int x1, y1, x2, y2, result;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());

			result = 0;
			for (int row = x1 - 1; row < x2; row++) {
				result += map[row][y2];
				result -= map[row][y1-1];
			}

			out.append(result).append("\n");
		}

		System.out.print(out);

		br.close();
	}
}