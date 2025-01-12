import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws IOException{
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		int n, m, maxFlies, currentSum, ccurrentSum, newx, newy, nnewx, nnewy;
		int[] dx = {0, 0, -1, 1};
		int[] dy = {1, -1, 0, 0};
		int[] ddx = {1, 1, -1, -1};
		int[] ddy = {1, -1, 1, -1};
		for (int tc=1; tc<=t; tc++) {
			n = scanner.nextInt();
			m = scanner.nextInt();
			maxFlies = 0;
			int[][] map = new int[n][n];
			for (int i=0; i<n; i++) {
				for (int j=0; j<n; j++) {
					map[i][j] = scanner.nextInt();
				}
			}
			// Map 저장 완료
			for (int y=0; y<n; y++) {
				for (int x=0; x<n; x++) {
					currentSum = map[y][x];
					ccurrentSum = map[y][x];
					for (int j=1; j<m; j++) {
						for (int i=0; i<4; i++) {
							newy = y+dy[i]*j;
							newx = x+dx[i]*j;
							if ((newy>=n)||(newx>=n)||(newy<0)||(newx<0)) {
								continue;
							}
							currentSum += map[newy][newx];	
							nnewy = y+ddy[i]*j;
							nnewx = x+ddx[i]*j;
							if ((nnewy>=n)||(nnewx>=n)||(nnewy<0)||(nnewx<0)) {
								continue;
							}
							ccurrentSum += map[nnewy][nnewx];
						}
					}
				currentSum = Math.max(currentSum, ccurrentSum);
				maxFlies = Math.max(maxFlies, currentSum);
				}
			}
			System.out.println("#"+tc+" "+maxFlies);
		}
		scanner.close();

	}
	}