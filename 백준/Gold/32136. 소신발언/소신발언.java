import java.util.Scanner;

public class Main {
	static int N;
	static long[] An;

	static boolean check(long maxT) {

		// time / An[i] = | i - heater |

		long minR, maxL;
		minR = Long.MAX_VALUE;
		maxL = Long.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			minR = Math.min(minR, i + maxT / An[i]);
			maxL = Math.max(maxL, i - maxT / An[i]);
		}
		if (maxL <= minR) {
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		long left, mid, right;

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		An = new long[N];
		for (int i = 0; i < N; i++) {
			An[i] = sc.nextInt();
		}
		sc.close();

		mid = 0;
		left = 0;
		right = 300000L * 500000L;
		while (left <= right) {
			mid = (left + right) / 2L;
			if (check(mid)) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		System.out.println(left);
	}
}
