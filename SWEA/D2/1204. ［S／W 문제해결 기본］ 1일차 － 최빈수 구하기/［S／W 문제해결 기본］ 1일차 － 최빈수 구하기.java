import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		int t, max;
		int[] counter;
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			sc.nextInt();
			counter = new int[101];
			for (int i = 0; i < 1000; i++) {
				counter[sc.nextInt()]++;
			}
			max = 0;
			for (int i = 100; i >= 0; i--) {
				if (counter[i] > counter[max]) {
					max = i;
				}
			}
			System.out.println("#" + tc + " " + max);
		}
		sc.close();
	}
}
