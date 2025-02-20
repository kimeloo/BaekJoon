import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int result = 1;
		
		for (int i=0; i<k; i++) {
			result *= n-i;
		}
		for (int i=k; i>1; i--) {
			result /= i;
		}
		System.out.println(result);
		
		sc.close();
	}
}
