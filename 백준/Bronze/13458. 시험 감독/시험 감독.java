import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int rooms, mainMonitor, subMonitor, current;
		long result;
		int[] students;

		st = new StringTokenizer(br.readLine());
		rooms = Integer.parseInt(st.nextToken());

		students = new int[rooms];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < rooms; i++) {
			students[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		mainMonitor = Integer.parseInt(st.nextToken());
		subMonitor = Integer.parseInt(st.nextToken());

		result = 0L;
		for (int i = 0; i < rooms; i++) {
			result += 1L;
			current = students[i] - mainMonitor;
			if (current<0) {
				continue;
			}
			result += (long) (current / subMonitor + (current % subMonitor > 0 ? 1 : 0));
		}

		System.out.println(result);

		br.close();
	}
}