import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;
// dR, dC 활용하여 반시계방향 순회
// 0을 만나거나 표 범위 넘어가면 방향 전환, dir<4까지만
// 반시계방향으로 돌린 값을 새 2차원 배열에 저장하고, 각 배열을 r칸씩 밀고 다시 표에 대입

public class Main {
	static int N, M, R;
	static int[] dR = new int[] { 1, 0, -1, 0 }; // 남동북서
	static int[] dC = new int[] { 0, 1, 0, -1 };
	static int[][] map;
	static ArrayDeque<Integer>[] arr;
	static BufferedReader br;
	static StringTokenizer st;

	@SuppressWarnings("unchecked")
	static void input() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		arr = new ArrayDeque[Math.min(N, M) / 2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	static void print() {
		StringBuilder sb = new StringBuilder();
		for (int[] line : map) {
			for (int num : line) {
				sb.append(num).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static void mapToArr() {
		int r, c, dir, nr, nc;
		for (int i = 0; i < Math.min(N, M) / 2; i++) {
			r = i;
			c = i;
			dir = 0;
			arr[i] = new ArrayDeque<>();
			while (true) {
				arr[i].offer(map[r][c]);
				map[r][c] = 0;
				nr = r + dR[dir];
				nc = c + dC[dir];
				if (nr >= N || nc >= M || nr < 0 || nc < 0 || map[nr][nc] == 0) {
					dir++;
					if (dir == 4) {
						break;
					}
					nr = r + dR[dir];
					nc = c + dC[dir];
					if (map[nr][nc] == 0) {
						break;
					}
				}
				r = nr;
				c = nc;
			}
		}
//		for (ArrayList<Integer> ar : arr) {
//			System.out.println(Arrays.toString(ar.toArray()));
//		}
	}

	static void arrToMap() {
		int r, c, dir, nr, nc;
		for (int i = 0; i < Math.min(N, M) / 2; i++) {
			r = i;
			c = i;
			dir = 0;
			while (!arr[i].isEmpty()) {
				map[r][c] = arr[i].poll();
				nr = r + dR[dir];
				nc = c + dC[dir];
				if (nr >= N || nc >= M || nr < 0 || nc < 0 || map[nr][nc] != 0) {
					dir++;
					if (dir == 4) {
						break;
					}
					nr = r + dR[dir];
					nc = c + dC[dir];
					if (map[nr][nc] != 0) {
						break;
					}
				}
				r = nr;
				c = nc;
			}
		}
	}

	static void simulate() {
		mapToArr();
		for (ArrayDeque<Integer> ar : arr) {
			for (int n = 0; n < R; n++) {
				ar.offerFirst(ar.pollLast());
			}
		}
		arrToMap();
	}

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		input();
		simulate();
		print();
		br.close();
	}
}