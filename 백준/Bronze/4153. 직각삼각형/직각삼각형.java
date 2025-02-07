import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int a, b, c;
		int[] nums = new int[3];
		Scanner sc = new Scanner(System.in);
		while (true) {
			a = sc.nextInt();
			b = sc.nextInt();
			c = sc.nextInt();
			if (a*b*c==0) {
				break;
			}
			nums[0] = a*a;
			nums[1] = b*b;
			nums[2] = c*c;
			Arrays.sort(nums);
			System.out.println((nums[0]+nums[1]==nums[2])?"right":"wrong");
		}
		
		sc.close();
	}

}
