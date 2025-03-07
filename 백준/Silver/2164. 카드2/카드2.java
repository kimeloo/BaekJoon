import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
	public static void main(String[] args) throws IOException {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().strip());
		br.close();

		for (int i = 1; i <= N; i++) {
			q.offer(i);
		}
		
		while (q.size()>1) {
			q.poll();
			q.offer(q.poll());
		}
		
		System.out.println(q.peek());
	}
}