import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		PriorityQueue<String> heapq = new PriorityQueue<>((o1, o2) -> {
			if (o1.length()!=o2.length()) {
				return o1.length()-o2.length();
			}
			return o1.compareTo(o2);
		});

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			heapq.add(st.nextToken());
		}
		
		String before = "";
		String current;
		for (int i=0; i<N; i++) {
			current = heapq.poll();
			if (!current.equals(before)) {
				System.out.println(current);
			}
			before = current;
		}
		br.close();
	}
}