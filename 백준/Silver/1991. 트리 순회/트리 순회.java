import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static HashMap<Character, char[]> tree = new HashMap<>();
	static StringBuilder result;

	static void preOrder(char value) {
		if (value == '.') {
			return;
		}
		result.append(value);
		preOrder(tree.get(value)[0]);
		preOrder(tree.get(value)[1]);
	}

	static void inOrder(char value) {
		if (value == '.') {
			return;
		}
		inOrder(tree.get(value)[0]);
		result.append(value);
		inOrder(tree.get(value)[1]);
	}

	static void postOrder(char value) {
		if (value == '.') {
			return;
		}
		postOrder(tree.get(value)[0]);
		postOrder(tree.get(value)[1]);
		result.append(value);
	}

	public static void main(String[] args) throws IOException {
		int n;
		char value, left, right;

		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			value = st.nextToken().charAt(0);
			left = st.nextToken().charAt(0);
			right = st.nextToken().charAt(0);
			tree.put(value, new char[] { left, right });
		}

		result = new StringBuilder();
		preOrder('A');
		result.append("\n");
		inOrder('A');
		result.append("\n");
		postOrder('A');

		System.out.println(result);

		br.close();
	}
}