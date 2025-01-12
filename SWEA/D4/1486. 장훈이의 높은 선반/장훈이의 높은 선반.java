import java.util.Scanner;

public class Solution {
	// 모두 선택해두고, 하나씩 빼는 방식으로 -> target보다 작아지면 return 2147483647
	static int dfs(int[] heights, int idx, int currentSum, int target) {
		if ((idx<0)&&(currentSum<target)) { return 999999999; }
		if (currentSum>=target) { return currentSum; }
		int skip = dfs(heights, idx-1, currentSum, target);
		int noSkip = dfs(heights, idx-1, currentSum+heights[idx], target);
//		System.out.println(idx+" "+currentSum+" "+noSkip+" "+skip);
		return Math.min(noSkip, skip);
	}

	public static void main(String[] args) throws Exception{
		int t, n, target, currentSum, result;
		int[] heights;
		Scanner scanner = new Scanner(System.in);
		
		t = scanner.nextInt();
		
		for (int tc=1; tc<=t; tc++) {
			System.out.print("#"+tc+" ");
			n = scanner.nextInt();
			target = scanner.nextInt();
			heights = new int[n];
//			currentSum = 0;
			for (int i=0; i<n; i++) {
				heights[i] = scanner.nextInt();
//				currentSum += heights[i];
			}
//			Arrays.sort(heights);
			result = dfs(heights, n-1, 0, target);
			System.out.println(result-target);
		}
		scanner.close();
	}

}
