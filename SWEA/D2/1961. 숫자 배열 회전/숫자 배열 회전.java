import java.io.IOException;
import java.util.Scanner;


public class Solution {

	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int n;
		for (int tc=1; tc<=t; tc++) {
			System.out.println("#"+tc);
			n = sc.nextInt();
			int[][] original = new int[n][n];
			for (int i=0; i<n; i++) {
				for (int j=0; j<n; j++) {
					original[i][j] = sc.nextInt();
				}
			}
			for (int y=0; y<n; y++) {
				for (int x=0; x<n; x++) {
					System.out.print(original[n-x-1][y]);
				}
				System.out.print(" ");
				for (int x=0; x<n; x++) {
					System.out.print(original[n-y-1][n-x-1]);
				}
				System.out.print(" ");
				for (int x=0; x<n; x++) {
					System.out.print(original[x][n-y-1]);
				}
				System.out.print("\n");
			}
		}

	}

}
