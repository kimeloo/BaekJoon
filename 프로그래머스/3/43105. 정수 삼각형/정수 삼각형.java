class Solution {
	static int[][] dp;

	void find(int[][] triangle, int childR, int childC) {
		if (childR == dp.length) {
			return;
		}
		int result = 0;

		if (childC > 0) {
			result = dp[childR - 1][childC - 1] + triangle[childR][childC];
		}
		if (childC < dp[childR - 1].length) {
			result = Math.max(result, dp[childR - 1][childC] + triangle[childR][childC]);
		}
		if (result > dp[childR][childC]) {
			dp[childR][childC] = result;
			find(triangle, childR + 1, childC);
			if (childC + 1 == dp[childR].length) {
				find(triangle, childR + 1, childC + 1);
			}
		}
	}

	public int solution(int[][] triangle) {
		dp = new int[triangle.length][];
		for (int i = 0; i < triangle.length; i++) {
			dp[i] = new int[triangle[i].length];
		}
		dp[0][0] = triangle[0][0];
		find(triangle, 1, 0);
		find(triangle, 1, 1);
		int answer = 0;
		for (int[] line : dp) {
			for (int d : line) {
				answer = Math.max(answer, d);
			}
		}
		return answer;
	}}