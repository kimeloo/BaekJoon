import java.io.IOException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws IOException{
		Scanner scanner = new Scanner(System.in);
		int testCase, n, maxPrice, curPrice;
		long balance;
		testCase = scanner.nextInt();
		
		for (int t=0; t<testCase; t++) {
			n = scanner.nextInt();
			maxPrice = 0;
			balance = 0;
			scanner.nextLine();
			
			int[] prices = new int[n];
			String[] line = scanner.nextLine().split(" ");
			for (int i=0; i<n; i++) {
				prices[n-i-1] = Integer.parseInt(line[i]);
			}
			
			for (int i=0; i<n; i++) {
				curPrice = prices[i];
				if (curPrice >= maxPrice) {
					maxPrice = curPrice;
				} else {
					balance += maxPrice-curPrice;
				}
			}
			System.out.println("#"+(t+1)+" "+balance);
			
		}
		
		scanner.close();
		
	}
}
