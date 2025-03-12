import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, result;
	static int[] dir = { 0, 1, 2, 3 }; // 서,남,동,북
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { -1, 0, 1, 0 };
	static int[][][] filter = new int[4][5][5]; // {흩날리는 모래 비율을 저장할 2차원 배열}을 저장할 direction 배열
	static int[][] map;

	public static void main(String[] args) throws IOException {
		init();
		simulate();
		System.out.println(result);
	}

	static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		result = 0;
		map = new int[N][N];
		for (int row = 0; row < N; row++) {
			st = new StringTokenizer(br.readLine());
			for (int col = 0; col < N; col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}
		br.close();
		genFilter();
	}

	static void genFilter() {
		filter[0][0][2] = 2;
		filter[0][1][1] = 10;
		filter[0][1][2] = 7;
		filter[0][1][3] = 1;
		filter[0][2][0] = 5;
		filter[0][3][1] = 10;
		filter[0][3][2] = 7;
		filter[0][3][3] = 1;
		filter[0][4][2] = 2;

		for (int r = 0; r < 5; r++) {
			for (int c = 0; c < 5; c++) {
				filter[1][4 - c][r] = filter[0][r][c];
				filter[2][r][4 - c] = filter[0][r][c];
			}
		}
		for (int r = 0; r < 5; r++) {
			for (int c = 0; c < 5; c++) {
				filter[3][4 - r][c] = filter[1][r][c];
			}
		}
	}

	static void simulate() {
		int r, c, d, endR, endC, cnt, len;
		r = N / 2;
		c = N / 2;
		d = 0;
		endR = 0;
		endC = 0;
		cnt = 0;
		len = 1;

		while (true) {
			r += dr[d];
			c += dc[d];
			if (map[r][c] > 0) {
				blow(r, c, d);
			}

			if (r == endR && c == endC) {
				break;
			}
			cnt++;
			if (cnt == len) {
				cnt = 0;
				if (d % 2 == 1) {
					len++;
				}
				d = (d + 1) % 4;
			}
		}
	}

	static void blow(int r, int c, int d) {
		int current, sand, alpha;
		current = alpha = map[r][c];
		for (int x = -2; x <= 2; x++) {
			for (int y = -2; y <= 2; y++) {
				sand = (current * filter[d][x + 2][y + 2]) / 100;
				alpha -= sand;
				if (!isValid(r + x, c + y)) {
					result += sand;
					continue;
				}
				map[r + x][c + y] += sand;
			}
		}
		map[r][c] = 0;
		if (isValid(r + dr[d], c + dc[d])) {
			map[r + dr[d]][c + dc[d]] += alpha;
		} else {
			result += alpha;
		}
	}

	static boolean isValid(int r, int c) {
		if (r >= N || c >= N || r < 0 || c < 0) {
			return false;
		}
		return true;
	}
}