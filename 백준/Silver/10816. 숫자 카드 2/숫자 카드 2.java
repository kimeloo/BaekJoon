import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] nums;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(nums);
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		StringBuilder out = new StringBuilder();
		for (int i = 0; i < M; i++) {
			int cur = Integer.parseInt(st.nextToken());
			int ans = findRight(cur) - findLeft(cur);
			out.append(ans).append(" ");
		}
		System.out.println(out);
	}

	static int findRight(int cur) {
		int tar = cur;
		int left = 0;
		int right = N;
		int mid = 0;
		while (left < right) {
			mid = left + (right - left) / 2;
			if (nums[mid] > tar) {
				right = mid;
			} else if (nums[mid] <= tar) {
				left = mid + 1;
			}
		}
		return left;
	}

	static int findLeft(int tar) {
		int left = 0;
		int right = N;
		int mid = 0;
		while (left < right) {
			mid = left + (right - left) / 2;
			if (nums[mid] >= tar) {
				right = mid;
			} else if (nums[mid] < tar) {
				left = mid + 1;
			}
		}
		return left;
	}
}
