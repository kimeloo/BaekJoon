import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] nums = new int[10000001];
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			nums[Integer.parseInt(br.readLine())]++;
		}
		for (int num = 0; num < nums.length; num++) {
			if (nums[num] == 0) {
				continue;
			}
			System.out.print((num + "\n").repeat(nums[num]));
		}
		br.close();
	}
}
