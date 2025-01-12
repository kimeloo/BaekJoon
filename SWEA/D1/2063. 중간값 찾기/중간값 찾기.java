import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws IOException{
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.nextLine();
		String[] line = scanner.nextLine().split(" ");
		int[] nums = new int[n];
		for (int i=0; i<n; i++) {
			nums[i] = Integer.parseInt(line[i]);
		}
		Arrays.sort(nums);
		
		System.out.println(nums[(n-1)/2]);
//		System.out.println((n-1)/2);
		
		
		scanner.close();
	}

}
