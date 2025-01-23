import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int n, m, y, x, cnt, max;
		int[][] map;
		int[][][] tetromino; // 종류(yx 바꾸기*x부호반전*y부호반전=8가지씩), [[dy],[dx]]
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();
		tetromino = new int[][][] { { { 0, 0, 0, 0 }, { 0, 1, 2, 3 } }, { { 0, 1, 0, 1 }, { 0, 0, 1, 1 } },
				{ { 1, 0, 0, 0 }, { 0, 0, -1, -2 } }, { { 0, 0, 1, 1 }, { 0, 1, 1, 2 } },
				{ { 0, 1, 1, 2 }, { 0, 0, 1, 0 } } };
		map = new int[n][m];
		
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				for (int a = 0; a < 2; a++) {
					for (int b = -1; b < 2; b += 2) {
						for (int c = -1; c < 2; c += 2) {
							for (int k = 0; k < 5; k++) {
								cnt = 0;
								for (int l = 0; l < 4; l++) {
									y = i + b * tetromino[k][1 - a][l];
									x = j + c * tetromino[k][a][l];
									if (x < 0 || y < 0 || y >= n || x >= m) {
										continue;
									}
									cnt += map[y][x];
								}
								max = Math.max(max, cnt);
							}
						}
					}
				}
			}
		}
		System.out.println(max);

		sc.close();
	}
}
