import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		int k, num, sum;
		Stack<Integer> stack = new Stack<>();
		Scanner sc = new Scanner(System.in);
		k = sc.nextInt();
		sum = 0;
		for (int i=0; i<k; i++) {
			num = sc.nextInt();
			if (num == 0) {
				sum -= stack.pop();
			} else {
				stack.push(num);
				sum += num;
			}
		}
		System.out.println(sum);
		
		sc.close();
	}
}