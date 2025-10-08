import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();

		while (true) {
			char[] input = br.readLine().toCharArray();
			if (input[0] == '.') {
				break;
			}

			Stack<Character> stack = new Stack<>();
			boolean flag = false;
			for (char c : input) {
				switch (c) {
				case '(':
					stack.push(c);
					break;
				case '[':
					stack.push(c);
					break;
				case ')':
					if (stack.isEmpty() || stack.pop() != '(') {
						output.append("no").append("\n");
						flag = true;
					}
					break;
				case ']':
					if (stack.isEmpty() || stack.pop() != '[') {
						output.append("no").append("\n");
						flag = true;
					}
					break;
				}
				if (flag) {
					break;
				}
			}
			if (!flag) {
				if (!stack.isEmpty()) {
					output.append("no").append("\n");
				} else {
					output.append("yes").append("\n");
				}
			}
		}
		System.out.println(output);
	}
}
