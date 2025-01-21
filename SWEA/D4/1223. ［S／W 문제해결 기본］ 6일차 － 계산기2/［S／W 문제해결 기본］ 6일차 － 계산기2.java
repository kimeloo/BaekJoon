import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

/*
 * 1+2*3*4+5+6+7
 * stack
 * 123*4*+5+6+7+
 * 숫자는 바로 q 삽입
 * + 만나면 stack, q 반환, +를 stack에 삽입
 * 1 (+) (2)
 * * 만나면 stack 삽입, q 반환
 * 12 (+*) (3)
 * 123 (+**) (4)
 * 123*4*+ (+) ()
 * + 만나면 stack, q 반환하되 stack 먼저 -> +를 stack에 삽입
 */

public class Solution {

	static char[] toPostfix(char[] expression) {
		char[] result = new char[expression.length];
		ArrayDeque<Character> postfix = new ArrayDeque<>();
		ArrayDeque<Character> opStack = new ArrayDeque<>();
		ArrayDeque<Character> numQueue = new ArrayDeque<>();

		for (char exp : expression) {
			if (exp == '+') {
				while (numQueue.size() > 0 || opStack.size() > 0) {
					if (numQueue.size() > 0) {
						postfix.offer(numQueue.poll());
					}
					if (opStack.size() > 0) {
						postfix.offer(opStack.pollLast());
					}
				}
				opStack.offer('+');
			} else if (exp == '*') {
				if (numQueue.size() > 0) {
					postfix.offer(numQueue.poll());
				}
				opStack.offer('*');
			} else {
				numQueue.offer(exp);
			}
		}
		while (true) {
			if (numQueue.size() == 0 && opStack.size() == 0) {
				break;
			}
			if (numQueue.size() > 0) {
				postfix.offer(numQueue.poll());
			}
			if (opStack.size() > 0) {
				postfix.offer(opStack.pollLast());
			}
		}
		for (int i = 0; i < expression.length; i++) {
			result[i] = postfix.poll();
		}
		return result;
	}

	static int[] calculate(char[] expression, int idx) {
		int[] result = new int[2]; // {연산결과, 다음 idx}
		int[] nextResult;
		char op, next;
		int[] nums = new int[2];

		// 현재 idx는 무조건 연산자라고 가정
		op = expression[idx];
		for (int i = 0; i < 2; i++) {
			next = expression[idx - 1];
			// 1. 연산할 숫자 구하기
			// 1.1. idx-1이 연산자라면
			if (next == '+' || next == '*') {
				nextResult = calculate(expression, idx - 1);
				nums[i] = nextResult[0];
				idx = nextResult[1];
			}
			// 1.2. idx-1이 숫자라면
			else {
				nums[i] = next - '0';
				idx -= 1;
			}
		}
		// 2. 연산하기
		if (op == '+') {
			result[0] = nums[0] + nums[1];
		} else {
			result[0] = nums[0] * nums[1];
		}
		// 3. 다음 idx 맞춰주기
		result[1] = idx;
//		System.out.println(nums[0]+" "+nums[1]+" "+result[0]+" "+result[1]);
		return result;
	}

	public static void main(String[] args) throws Exception {
		int len;
		int[] result;
		char[] expression;

		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			len = sc.nextInt();

			sc.nextLine();
			expression = toPostfix(sc.nextLine().toCharArray());
//			System.out.println(Arrays.toString(expression));

			result = calculate(expression, len - 1);
			System.out.println("#" + tc + " " + result[0]);
		}

		sc.close();
	}

}
