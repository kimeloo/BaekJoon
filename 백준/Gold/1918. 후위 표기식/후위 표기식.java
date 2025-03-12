import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;

	static char[] input() throws IOException {
		char[] result;
		st = new StringTokenizer(br.readLine());
		result = st.nextToken().toCharArray();
		return result;
	}

	static void simulate(char[] line) {
		ArrayDeque<Character> postfix = toPostFix(line);
        while (!postfix.isEmpty()){
            System.out.print(postfix.poll());
        }
	}

	static ArrayDeque<Character> toPostFix(char[] line) {
		ArrayDeque<Character> result = new ArrayDeque<>();
		Stack<Character> op = new Stack<>();
		HashMap<Character, Integer> priority = new HashMap<>();
		priority.put('(', -1);
		priority.put('*', 1);
		priority.put('/', 1);
		priority.put('+', 0);
		priority.put('-', 0);

		for (char c : line) {
			if (c >= 'A' && c <= 'Z') {
				result.offer(c);
			} else if (op.isEmpty() || c == '(') {
				op.push(c);
			} else if (c == ')') {
				while (op.peek() != '(') {
					result.offer(op.pop());
				}
				op.pop();
			} else {
				while (!op.isEmpty() && priority.get(op.peek()) >= priority.get(c)) {
					result.offer(op.pop());
				}
				op.push(c);
			}
		}
		while (!op.isEmpty()) {
			result.offer(op.pop());
		}
		return result;
	}

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		char[] line = input();
		simulate(line);
		br.close();
	}
}