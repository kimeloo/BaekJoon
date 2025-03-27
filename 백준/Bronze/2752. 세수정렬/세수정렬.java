import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int min, max;
		int[] a = new int[3];
		a[0] = sc.nextInt();
		a[1] = sc.nextInt();
		a[2] = sc.nextInt();
		Arrays.sort(a);
		for (int i : a) {
			System.out.printf("%d ", i);
		}

		sc.close();
	}
}