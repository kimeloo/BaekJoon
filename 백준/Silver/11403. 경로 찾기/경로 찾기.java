import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int n;
		int[][] map;
		int[][] result;
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		map = new int[n][n];
		result = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		for (int iter = 0; iter < n; iter++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] == 1) {
						result[i][j] = 1;
						for (int k = 0; k < n; k++) {
							if (result[j][k] == 1) {
								result[i][k] = 1;
							}
						}
					}
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
		sc.close();

	}
}