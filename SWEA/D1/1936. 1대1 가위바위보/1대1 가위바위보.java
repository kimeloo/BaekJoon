import java.io.IOException;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws IOException{
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		if (((a==3)&&(b==2))||((a==2)&&(b==1))||((a==1)&&(b==3))) {
			System.out.println("A");
		} else {System.out.println("B");}
		scanner.close();
	}

}
