import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		Stack<Integer> stack = new Stack<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		String op;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			op = st.nextToken();
			if (op.equals("push")) {
				stack.push(Integer.parseInt(st.nextToken()));
			} else if (op.equals("pop")) {
				System.out.println(stack.isEmpty() ? -1 : stack.pop());
			} else if (op.equals("size")) {
				System.out.println(stack.size());
			} else if (op.equals("empty")) {
				System.out.println(stack.isEmpty() ? 1 : 0);
			} else if (op.equals("top")) {
				System.out.println(stack.isEmpty() ? -1 : stack.peek());
			}
		}

		br.close();
	}
}