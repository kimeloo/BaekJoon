import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int N, W, H;
	static int[] dR = new int[] { 0, 0, 1, -1 };
	static int[] dC = new int[] { 1, -1, 0, 0 };
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int conv(int r, int c) {
		return r * 100 + c;
	}

	static int[] conv(int rc) {
		return new int[] { rc / 100, rc % 100 };
	}

	static int[][] input() throws IOException {
		int[][] map;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		for (int r = 0; r < H; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < W; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		return map;
	}

	static int[][] deepCopy(int[][] map) {
		int[][] result = new int[map.length][map[0].length];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				result[i][j] = map[i][j];
			}
		}
		return result;
	}

	static void flush(int[][] map) {
		int cnt, temp;
		for (int c = 0; c < W; c++) {
			cnt = H-1;
			for (int r = H - 1; r >= 0; r--) {
				if (map[r][c] != 0) {
					temp = map[r][c];
					map[r][c] = 0;
					map[cnt--][c] = temp;
				}
			}
		}
	}

	static int dfs(int[][] map, int ballCnt) {
		// 현재 턴 시작
		// 구슬 시작 위치를 모두 순회하여 최적 값 탐색
		int result = Integer.MAX_VALUE;
		if (ballCnt == 0) {
			result = 0;
			for (int[] line : map) {
				for (int n : line) {
					if (n != 0) {
						result++;
					}
				}
			}
//			if (result == 12) {
//				System.out.println("******************");
//				for (int[] line : map) {
//					System.out.println(Arrays.toString(line));
//				}
//			}
			return result;
		}
		for (int c = 0; c < W; c++) {
			for (int r = 0; r < H; r++) {
				if (map[r][c] != 0) {
					result = Math.min(bfs(map, r, c, ballCnt), result);
					break;
				}
			}
		}
		return result;
	}

	static int bfs(int[][] map, int r, int c, int ballCnt) {
		int y, x, size, ny, nx;
		int[] rc;
		int[][] newMap = deepCopy(map);
		ArrayDeque<Integer> Q = new ArrayDeque<>();
		Q.add(conv(r, c));
		while (Q.size() > 0) {
			rc = conv(Q.poll());
			y = rc[0];
			x = rc[1];
			size = newMap[y][x];
			if (size == 0) {
				continue;
			}
			for (int d = 0; d < 4; d++) {
				for (int s = 1; s < size; s++) {
					ny = y + dR[d] * s;
					nx = x + dC[d] * s;
					if (ny < 0 || nx < 0 || ny >= H || nx >= W) {
						continue;
					}
					Q.offer(conv(ny, nx));
				}
			}
			newMap[y][x] = 0;
		}
		flush(newMap);
		return dfs(newMap, ballCnt - 1);
	}

	public static void main(String[] args) throws IOException {
		int t, result;
		int[][] map;
		st = new StringTokenizer(br.readLine());
		t = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= t; tc++) {
			map = input();
			result = dfs(map, N);
			if (result == Integer.MAX_VALUE) {
				result = 0;
			}
			System.out.printf("#%d %d\n", tc, result);
		}
	}
}