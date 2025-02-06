import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		int t;
		double sum;
		int[] nums = new int[10];
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			sum = 0;
			for (int i = 0; i < 10; i++) {
				nums[i] = sc.nextInt();
			}
			Arrays.sort(nums);
			for (int num:nums) {
				if (num==nums[0]||num==nums[9]) {
					continue;
				}
				sum += num;
			}
			System.out.printf("#%d %.0f\n",tc,sum/8.0);
		}
		sc.close();
	}
}