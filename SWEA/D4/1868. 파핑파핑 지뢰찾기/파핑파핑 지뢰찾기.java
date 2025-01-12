import java.util.Scanner;
import java.util.ArrayList;

public class Solution {

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		int t, n, cnt, len, newY, newX, nearCnt;
		char[] line;
		int[] yx;
		int[] tempYX;
		int[][] table;
		boolean near;
		int[] dy = new int[] {0, 0, 1, -1, 1, -1, 1, -1};		// EE, WW, SS, NN, ES, EN, WS, WN
		int[] dx = new int[] {1, -1, 0, 0, 1, 1, -1, -1};
		ArrayList<int[]> stack = new ArrayList<>();
		t = scanner.nextInt();
		for (int tc=1; tc<=t; tc++) {
			System.out.print("#"+tc+" ");
			// 입력 값 저장 : 지뢰는 9, 없으면 0, 인접개수는 나중에 파악
			cnt = 0;
			n = scanner.nextInt();
			scanner.nextLine();
			table = new int[n][n];
			for (int i=0; i<n; i++) {
				line = scanner.nextLine().toCharArray();
				for (int j=0; j<n; j++) {
					if (line[j]=='.') { table[i][j]=0; }
					else { table[i][j]=9; }
				}
			}
			
			// DFS : 인접 지뢰 탐색
			for (int y=0; y<n; y++) {
				for (int x=0; x<n; x++) {
					if (table[y][x]==9) {continue;}
					nearCnt = 0;
					for (int i=0; i<8; i++) {
						newY = y+dy[i];
						newX = x+dx[i];
						if ((newY<0)||(newX<0)||(newY>=n)||(newX>=n)) {continue;}
						if (table[newY][newX]==9) {nearCnt++;}
					
					}
					table[y][x] = nearCnt;
				}
			}
			// 1차 탐색
			for (int y=0; y<n; y++) {
				for (int x=0; x<n; x++) {
					if (table[y][x]!=0) {continue;}
					cnt++;
					stack.clear();
					yx = new int[] {y,x};
					stack.add(yx);
					while (!stack.isEmpty()) {
						len = stack.size();
						yx = stack.remove(len-1);
						if (table[yx[0]][yx[1]]==0) {
							table[yx[0]][yx[1]] = 9;
							for (int i=0; i<8; i++) {
								newY = yx[0]+dy[i];
								newX = yx[1]+dx[i];
								if ((newY<0)||(newX<0)||(newY>=n)||(newX>=n)) {continue;}
								if (table[newY][newX]==0) {
									tempYX = new int[] {newY, newX};
									stack.add(tempYX);
								}
								else {table[newY][newX]=9;}
							}
						}
					}
				}
			}
			for (int y=0; y<n; y++) {
				for (int x=0; x<n; x++) {
					if (table[y][x]!=9) {cnt++;}
				}
			}
			
			System.out.println(cnt);
		}
		scanner.close();
	}
}
