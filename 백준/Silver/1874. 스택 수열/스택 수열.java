import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		Stack<Integer> stack = new Stack<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();

		int n = Integer.parseInt(br.readLine().strip());
		int a = 1;

		for (int i = 0; i < n; i++) {
			int next = Integer.parseInt(br.readLine().strip());
			while (next >= a) {
				stack.push(a++);
				out.append("+\n");
			}
			if (!stack.isEmpty() && stack.peek() == next) {
				stack.pop();
				out.append("-\n");
			} else {
				System.out.println("NO");
				return;
			}
		}
		System.out.print(out);

		br.close();
	}
}