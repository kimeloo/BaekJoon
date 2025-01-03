import java.io.IOException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws IOException{
		Scanner scanner = new Scanner(System.in);
		int testCase = scanner.nextInt();
		for (int t=0; t<testCase; t++) {
			int[] heights = new int[6];
			int sumHeight = 0;
			int maxHeight = 0;
			
			for (int i=0; i<6; i++) {
				heights[i] = scanner.nextInt();
				sumHeight += heights[i];
				if (heights[i] > maxHeight) {
					maxHeight = heights[i];
				}
			}
			maxHeight++;
			int tempAvg = sumHeight + maxHeight;
			if (tempAvg%7!=0) {
				maxHeight += 7-(tempAvg%7);
			}
			System.out.println(maxHeight);
		}
		
		scanner.close();
	}
}
