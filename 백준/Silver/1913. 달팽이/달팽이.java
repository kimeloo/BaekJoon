import java.util.Scanner;

public class Main {
	static int[] dr = new int[] { 1, 0, -1, 0 }; // 남 동 북 서
	static int[] dc = new int[] { 0, 1, 0, -1 };

	public static void main(String[] args) {
		int t, n, m, r, c, direction, nr, nc, mr, mc;
		int[][] map;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][n];
		r = 0;
		c = 0;
		mr = 0;
		mc = 0;
		direction = 0;
		for (int num = n * n; num >= 1; num--) {
			if (num == m) {
				mr = r + 1;
				mc = c + 1;
			}
			map[r][c] = num;
			nr = r + dr[direction];
			nc = c + dc[direction];
			if (nr >= n || nc >= n || nr < 0 || nc < 0 || map[nr][nc] != 0) {
				direction = (++direction) % 4;
				nr = r + dr[direction];
				nc = c + dc[direction];
			}
			r = nr;
			c = nc;
		}
		for (int[] line : map) {
			for (int i : line) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
		System.out.print(mr + " " + mc);
		sc.close();
	}
}
