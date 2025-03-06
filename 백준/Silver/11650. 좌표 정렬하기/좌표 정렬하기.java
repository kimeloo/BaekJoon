import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		PriorityQueue<int[]> heapq = new PriorityQueue<>((o1, o2) -> {
			if (o1[0] == o2[0]) {
				return Integer.compare(o1[1], o2[1]);
			}
			return Integer.compare(o1[0], o2[0]);
		});
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder out = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		int[] temp;
		for (int i = 0; i < N; i++) {
			temp = new int[2];
			st = new StringTokenizer(br.readLine());
			temp[0] = Integer.parseInt(st.nextToken());
			temp[1] = Integer.parseInt(st.nextToken());
			heapq.add(temp);
		}

		while (!heapq.isEmpty()) {
			temp = heapq.poll();
			out.append(temp[0]).append(" ").append(temp[1]).append("\n");
		}
		
		System.out.print(out);

		br.close();
	}
}