import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int n30 = (int) Math.round(n * 0.15);

		float sum = 0f;
		float avg = 0f;

		if (n > 0) {
			int[] scores = new int[n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				scores[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(scores);
			for (int i = 0; i < n; i++) {
				if (i < n30 || i > n - n30 - 1) {
					continue;
				}
				sum += scores[i];
			}
			avg = sum / (n - 2 * n30);
		}
		System.out.println(Math.round(avg));
	}
}
