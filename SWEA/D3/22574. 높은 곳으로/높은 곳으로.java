
import java.io.IOException;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws IOException{
		Scanner scanner = new Scanner(System.in);
		int testCase = scanner.nextInt();
		int n, p, s;
		for (int t=0; t<testCase; t++) {
			n = scanner.nextInt();
			p = scanner.nextInt();
			s = 0;
			for (int i=1; i<=n; i++) {
				s += i;
				if (s==p) {
					s -= 1;
				}
			}
			System.out.println(s);
		}
		
		scanner.close();

	}

}
