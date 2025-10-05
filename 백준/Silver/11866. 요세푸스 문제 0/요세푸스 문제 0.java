import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer in;
		StringBuilder out = new StringBuilder();

		int N, K;
		ArrayDeque<Integer> queue = new ArrayDeque<>();

		in = new StringTokenizer(br.readLine());
		N = Integer.parseInt(in.nextToken());
		K = Integer.parseInt(in.nextToken());

		for (int i = 1; i <= N; i++) {
			queue.offer(i);
		}

		out.append("<");

		int cnt = 0;
		while (!queue.isEmpty()) {
			int num = queue.poll();
			if ((++cnt) % K == 0) {
				out.append(num).append(", ");
			} else {
				queue.offer(num);
			}
		}
		out.delete(out.length() - 2, out.length());
		out.append(">");
		bw.append(out);
		bw.flush();
	}
}
