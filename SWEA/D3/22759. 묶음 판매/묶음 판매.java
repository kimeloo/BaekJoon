import java.io.IOException;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws IOException{
		Scanner scanner = new Scanner(System.in);
		int testCase = scanner.nextInt();
		int l, r, minX, maxX;
		String result;
		for (int t=0; t<testCase; t++) {
			
			l = scanner.nextInt();
			r = scanner.nextInt();

			maxX = 2*l;
			minX = r+1;
			if ( minX <= maxX ) { result = "yes"; }
			else { result = "no"; }
			System.out.println(result);
		}
		
		scanner.close();

	}

}
