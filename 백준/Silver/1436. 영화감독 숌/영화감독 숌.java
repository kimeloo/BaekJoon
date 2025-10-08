import java.io.*;
import java.util.*;

public class Main {
	static int[] pool = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	static Set<Integer> nums = new TreeSet<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());

		pick(0, 0, false);
		List<Integer> numList = new ArrayList<>();
		numList.addAll(nums);
		int ans = numList.get(N-1);
		System.out.println(ans);
	}

	static void pick(int depth, int bef, boolean six) {
		if (depth == 6) {
			if (six)
				nums.add(bef);
			return;
		}
		for (int i = 0; i < 10; i++) {
			pick(depth + 1, bef * 10 + pool[i], six);
		}
		if (!six) {
			pick(depth + 1, bef * 1000 + 666, true);
		}
	}
}
